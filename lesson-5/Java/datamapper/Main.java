package datamapper;

import java.util.HashMap;
import java.util.Map;

// Интерфейс для класса Data Mapper
interface IDataMapper {
    /**
     * Сохраняет пользователя в базу данных.
     *
     * @param user Пользователь для сохранения.
     */
    void save(User user);

    /**
     * Находит пользователя по идентификатору.
     *
     * @param id Идентификатор пользователя.
     * @return Пользователь с указанным идентификатором.
     */
    User findById(int id);

    /**
     * Обновляет информацию о пользователе в базе данных.
     *
     * @param user Пользователь для обновления.
     */
    void update(User user);

    /**
     * Удаляет пользователя из базы данных.
     *
     * @param user Пользователь для удаления.
     */
    void delete(User user);
}

// Класс модели данных (бизнес-объект)
class User {
    private int id; // идентификатор пользователя
    private String username; // имя пользователя
    private String email; // электронная почта пользователя

    /**
     * Конструктор класса User.
     *
     * @param id       идентификатор пользователя
     * @param username имя пользователя
     * @param email    электронная почта пользователя
     */
    public User(int id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
    }

    /**
     * Возвращает идентификатор пользователя.
     *
     * @return идентификатор пользователя
     */
    public int getId() {
        return id;
    }

    /**
     * Устанавливает идентификатор пользователя.
     *
     * @param id идентификатор пользователя
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Возвращает имя пользователя.
     *
     * @return имя пользователя
     */
    public String getUsername() {
        return username;
    }

    /**
     * Устанавливает имя пользователя.
     *
     * @param username имя пользователя
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Возвращает электронную почту пользователя.
     *
     * @return электронная почта пользователя
     */
    public String getEmail() {
        return email;
    }

    /**
     * Устанавливает электронную почту пользователя.
     *
     * @param email электронная почта пользователя
     */
    public void setEmail(String email) {
        this.email = email;
    }
}

// Класс Data Mapper
class UserMapper implements IDataMapper {
    private Map<Integer, User> userMap;

    /**
     * Конструктор класса UserMapper.
     * Инициализирует пустую хэш-карту для хранения пользователей.
     */
    public UserMapper() {
        this.userMap = new HashMap<>();
    }

    /**
     * Метод для сохранения пользователя в хранилище.
     * 
     * @param user Пользователь для сохранения.
     */
    @Override
    public void save(User user) {
        userMap.put(user.getId(), user);
        System.out.println("Пользователь с ID " + user.getId() + " сохранен в хранилище.");
    }

    /**
     * Метод для получения пользователя из хранилища по ID.
     * 
     * @param id ID пользователя.
     * @return Пользователь с указанным ID или null, если пользователь не найден.
     */
    @Override
    public User findById(int id) {
        User user = userMap.get(id);
        if (user != null) {
            System.out.println("Полученный пользователь: ID=" + user.getId() +
                    ", Username=" + user.getUsername() +
                    ", Email=" + user.getEmail());
        } else {
            System.out.println("Пользователь с ID " + id + " не найден в хранилище.");
        }
        return user;
    }

    /**
     * Метод для обновления пользователя в хранилище.
     * 
     * @param user Пользователь для обновления.
     */
    @Override
    public void update(User user) {
        if (userMap.containsKey(user.getId())) {
            userMap.put(user.getId(), user);
            System.out.println("Пользователь с ID " + user.getId() + " обновлен в хранилище.");
        } else {
            System.out.println("Пользователь с ID " + user.getId() + " не найден в хранилище.");
        }
    }

    /**
     * Метод для удаления пользователя из хранилища.
     * 
     * @param user Пользователь для удаления.
     */
    @Override
    public void delete(User user) {
        if (userMap.containsKey(user.getId())) {
            userMap.remove(user.getId());
            System.out.println("Пользователь с ID " + user.getId() + " удален из хранилища.");
        } else {
            System.out.println("Пользователь с ID " + user.getId() + " не найден в хранилище.");
        }
    }
}

// Пример использования
public class Main {
    public static void main(String[] args) {
        UserMapper userMapper = new UserMapper();

        // Создаем нового пользователя
        User user = new User(1, "John", "john@example.com");

        // Сохраняем пользователя в хранилище
        userMapper.save(user);

        // Получаем пользователя из хранилища по ID и выводим его на экран
        userMapper.findById(1);

        // Обновляем пользователя в хранилище
        user.setUsername("Mark");
        userMapper.update(user);
        userMapper.findById(1);

        // Удаляем пользователя из хранилища
        userMapper.delete(user);
    }
}
