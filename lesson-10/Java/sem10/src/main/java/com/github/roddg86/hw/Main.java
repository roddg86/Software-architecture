package com.github.roddg86.hw;

import java.util.List;
import java.sql.*;
import java.util.ArrayList;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;

class Order {
    private int id;
    private List<OrderItem> orderItems;

    /**
     * Конструктор класса Order.
     *
     * @param id         идентификатор заказа
     * @param orderItems список элементов заказа
     */
    public Order(int id, List<OrderItem> orderItems) {
        this.id = id;
        this.orderItems = orderItems;
    }

    /**
     * Получить идентификатор заказа.
     *
     * @return идентификатор заказа
     */
    public int getId() {
        return id;
    }

    /**
     * Установить идентификатор заказа.
     *
     * @param id идентификатор заказа
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Получить список элементов заказа.
     *
     * @return список элементов заказа
     */
    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    /**
     * Рассчитать общую стоимость заказа.
     *
     * @return общая стоимость заказа
     */
    public double calculateTotalCost() {
        double totalCost = 0;
        for (OrderItem orderItem : orderItems) {
            totalCost += orderItem.getProduct().getPrice() * orderItem.getQuantity();
        }
        return totalCost;
    }
}

/**
 * Представляет элемент заказа.
 */
class OrderItem {
    private int id;
    private Product product;
    private int quantity;

    /**
     * Конструирует элемент заказа.
     *
     * @param id       идентификатор элемента заказа
     * @param product  товар, связанный с элементом заказа
     * @param quantity количество элемента заказа
     */
    public OrderItem(int id, Product product, int quantity) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
    }

    /**
     * Возвращает идентификатор элемента заказа.
     *
     * @return идентификатор элемента заказа
     */
    public int getId() {
        return id;
    }

    /**
     * Возвращает товар, связанный с элементом заказа.
     *
     * @return товар, связанный с элементом заказа
     */
    public Product getProduct() {
        return product;
    }

    /**
     * Возвращает количество элемента заказа.
     *
     * @return количество элемента заказа
     */
    public int getQuantity() {
        return quantity;
    }
}

/**
 * Этот класс представляет собой продукт.
 */
class Product {
    private int id;
    private String name;
    private double price;

    /**
     * Создает новый объект Product с указанным идентификатором, именем и ценой.
     *
     * @param id    идентификатор продукта
     * @param name  название продукта
     * @param price цена продукта
     */
    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    /**
     * Возвращает идентификатор продукта.
     *
     * @return идентификатор продукта
     */
    public int getId() {
        return id;
    }

    /**
     * Возвращает название продукта.
     *
     * @return название продукта
     */
    public String getName() {
        return name;
    }

    /**
     * Возвращает цену продукта.
     *
     * @return цена продукта
     */
    public double getPrice() {
        return price;
    }

}

/**
 * Этот интерфейс представляет репозиторий для сохранения и извлечения заказов.
 */
interface OrderRepository {

    /**
     * Сохраняет указанный заказ в репозитории.
     *
     * @param order Заказ, который нужно сохранить.
     */
    void save(Order order);

    /**
     * Извлекает заказ с указанным идентификатором из репозитория.
     *
     * @param id Идентификатор заказа для извлечения.
     * @return Заказ с указанным идентификатором или null, если не найден.
     */
    Order getById(int id);

    /**
     * Извлекает все заказы из репозитория.
     *
     * @return Список всех заказов.
     */
    List<Order> getAll();
}

class OrderRepositoryImpl implements OrderRepository {

    private final Cache<Integer, Order> orderCache;
    private static final String DB_URL = "jdbc:sqlite:orders.db";

    public OrderRepositoryImpl() {
        this.orderCache = Caffeine.newBuilder().build();
        createTableIfNotExists();
    }

    private void createTableIfNotExists() {
        try (Connection conn = DriverManager.getConnection(DB_URL);
                Statement stmt = conn.createStatement()) {

            String sql = "CREATE TABLE IF NOT EXISTS orders (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "total_cost REAL" +
                    ")";
            stmt.execute(sql);

            sql = "CREATE TABLE IF NOT EXISTS order_items (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "order_id INTEGER," +
                    "product_id INTEGER," +
                    "quantity INTEGER," +
                    "FOREIGN KEY (order_id) REFERENCES orders(id)," +
                    "FOREIGN KEY (product_id) REFERENCES products(id)" +
                    ")";
            stmt.execute(sql);

            sql = "CREATE TABLE IF NOT EXISTS products (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "name TEXT," +
                    "price REAL" +
                    ")";
            stmt.execute(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Сохраняет заказ в базе данных. Этот метод вставляет общую стоимость заказа в
     * таблицу 'orders'
     * и генерирует новый идентификатор заказа. Он также сохраняет каждый товар
     * заказа, связанный с заказом,
     * и кэширует заказ в кэше заказов.
     *
     * @param order заказ, который нужно сохранить
     */
    @Override
    public void save(Order order) {
        try (Connection conn = DriverManager.getConnection(DB_URL);
                PreparedStatement pstmt = conn.prepareStatement(
                        "INSERT INTO orders (total_cost) VALUES (?)",
                        Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setDouble(1, order.calculateTotalCost());
            pstmt.executeUpdate();

            ResultSet generatedKeys = pstmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                int orderId = generatedKeys.getInt(1);
                order.setId(orderId);

                List<OrderItem> orderItems = order.getOrderItems();
                for (OrderItem orderItem : orderItems) {
                    saveOrderItem(orderItem, orderId);
                }

                // Сохранение заказа в кэше
                orderCache.put(order.getId(), order);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Сохраняет позицию заказа в базу данных.
     *
     * @param orderItem позиция заказа для сохранения
     * @param orderId   идентификатор заказа
     */
    private void saveOrderItem(OrderItem orderItem, int orderId) {
        try (Connection conn = DriverManager.getConnection(DB_URL);
                PreparedStatement pstmt = conn.prepareStatement(
                        "INSERT INTO order_items (order_id, product_id, quantity) VALUES (?, ?, ?)")) {

            pstmt.setInt(1, orderId);
            pstmt.setInt(2, orderItem.getProduct().getId());
            pstmt.setInt(3, orderItem.getQuantity());
            pstmt.executeUpdate();

            // Инвалидация соответствующего заказа в кэше
            orderCache.invalidate(orderId);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Получает заказ по его идентификатору.
     *
     * @param id идентификатор заказа
     * @return заказ с указанным идентификатором или null, если его нет
     */
    @Override
    public Order getById(int id) {

        Order order = orderCache.getIfPresent(id);

        if (order == null) {
            try (Connection conn = DriverManager.getConnection(DB_URL);
                    PreparedStatement pstmt = conn.prepareStatement(
                            "SELECT * FROM orders WHERE id = ?")) {

                pstmt.setInt(1, id);
                ResultSet rs = pstmt.executeQuery();

                if (rs.next()) {
                    double totalCost = rs.getDouble("total_cost");
                    order = new Order(id, new ArrayList<OrderItem>());

                    List<OrderItem> orderItems = getOrderItemsByOrderId(id);
                    order.getOrderItems().addAll(orderItems);
                    // Сохранение заказа в кэше
                    orderCache.put(id, order);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return order;
    }

    /**
     * Получает все заказы из базы данных.
     *
     * @return список объектов Order, представляющих все заказы
     */
    @Override
    public List<Order> getAll() {
        List<Order> orders = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(DB_URL);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM orders")) {

            while (rs.next()) {
                int id = rs.getInt("id");
                double totalCost = rs.getDouble("total_cost");

                // Попытка получить заказ из кэша
                Order order = orderCache.getIfPresent(id);

                if (order == null) {
                    order = new Order(id, new ArrayList<OrderItem>());
                    List<OrderItem> orderItems = getOrderItemsByOrderId(id);
                    order.getOrderItems().addAll(orderItems);

                    // Сохранение заказа в кэше
                    orderCache.put(id, order);
                }

                orders.add(order);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return orders;
    }

    /**
     * Получает список элементов заказа, связанных с заданным идентификатором
     * заказа.
     *
     * @param orderId идентификатор заказа
     * @return список элементов заказа, связанных с заданным идентификатором заказа
     */
    private List<OrderItem> getOrderItemsByOrderId(int orderId) {
        List<OrderItem> orderItems = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(DB_URL);
                PreparedStatement pstmt = conn.prepareStatement(
                        "SELECT * FROM order_items WHERE order_id = ?")) {

            pstmt.setInt(1, orderId);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int orderItemId = rs.getInt("id");
                int productId = rs.getInt("product_id");
                int quantity = rs.getInt("quantity");

                Product product = getProductById(productId);
                if (product != null) {
                    OrderItem orderItem = new OrderItem(orderItemId, product, quantity);
                    orderItems.add(orderItem);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return orderItems;
    }

        /**
         * Возвращает продукт из базы данных на основе заданного идентификатора продукта.
         *
         * @param  productId  идентификатор продукта для получения
         * @return            объект Product, представляющий полученный продукт, или null, если продукт не найден
         */
    private Product getProductById(int productId) {
        Product product = null;

        try (Connection conn = DriverManager.getConnection(DB_URL);
                PreparedStatement pstmt = conn.prepareStatement(
                        "SELECT * FROM products WHERE id = ?")) {

            pstmt.setInt(1, productId);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                String name = rs.getString("name");
                double price = rs.getDouble("price");

                product = new Product(productId, name, price);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return product;
    }

}

public class Main {
    public static void main(String[] args) {
        // Создание репозитория заказов
        OrderRepository orderRepository = new OrderRepositoryImpl();

        // Получение заказа по идентификатору
        int orderId = 1;
        Order order = orderRepository.getById(orderId);

        if (order != null) {
            System.out.println("Заказ с идентификатором " + orderId + ":");
            System.out.println("Общая стоимость: " + order.calculateTotalCost());
            System.out.println("Элементы заказа:");

            for (OrderItem orderItem : order.getOrderItems()) {
                System.out.println(
                        " - " + orderItem.getProduct().getName() + " (количество: " + orderItem.getQuantity() + ")");
            }
        } else {
            System.out.println("Заказ с идентификатором " + orderId + " не найден.");
        }

        // Получение всех заказов
        List<Order> orders = orderRepository.getAll();

        if (!orders.isEmpty()) {
            System.out.println("Все заказы:");

            for (Order o : orders) {
                System.out.println("Заказ с идентификатором " + o.getId() + ":");
                System.out.println("Общая стоимость: " + o.calculateTotalCost());
                System.out.println("Элементы заказа:");

                for (OrderItem orderItem : o.getOrderItems()) {
                    System.out.println(" - " + orderItem.getProduct().getName() + " (количество: "
                            + orderItem.getQuantity() + ")");
                }
            }
        } else {
            System.out.println("Нет доступных заказов.");
        }
    }
}
