package com.github.roddg86;

/**
 * Простой пример http сервера
 *
 * http://localhost:8080/users
 *
 */

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    private static List<User> users = new ArrayList<>();
    private static AtomicInteger idGenerator = new AtomicInteger(1);
    private static ObjectMapper objectMapper = new ObjectMapper(); // Создаем объект ObjectMapper

    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.createContext("/users", new UsersHandler());
        server.start();
        System.out.println("Server started on port 8080");
    }

    static class UsersHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            if ("GET".equals(exchange.getRequestMethod())) {
                String responseBody = objectMapper.writeValueAsString(users);
                exchange.getResponseHeaders().set("Content-Type", "application/json");
                exchange.sendResponseHeaders(200, responseBody.length());
                try (OutputStream os = exchange.getResponseBody()) {
                    os.write(responseBody.getBytes());
                }
            } else if ("POST".equals(exchange.getRequestMethod())) {
                int newId = idGenerator.getAndIncrement();
                User newUser = new User(newId, "User" + newId);
                users.add(newUser);
                String responseBody = objectMapper.writeValueAsString(newUser);
                exchange.getResponseHeaders().set("Content-Type", "application/json");
                exchange.sendResponseHeaders(201, responseBody.length());
                try (OutputStream os = exchange.getResponseBody()) {
                    os.write(responseBody.getBytes());
                }
            } else if ("DELETE".equals(exchange.getRequestMethod())) {
                String[] pathParts = exchange.getRequestURI().getPath().split("/");
                if (pathParts.length == 3) {
                    int userId = Integer.parseInt(pathParts[2]);
                    users.removeIf(user -> user.getId() == userId);
                    String responseBody = "{\"message\":\"User with ID " + userId + " removed.\"}";
                    exchange.getResponseHeaders().set("Content-Type", "application/json");
                    exchange.sendResponseHeaders(200, responseBody.length());
                    try (OutputStream os = exchange.getResponseBody()) {
                        os.write(responseBody.getBytes());
                    }
                }
            } else {
                String responseBody = "{\"error\":\"Method not allowed\"}";
                exchange.getResponseHeaders().set("Content-Type", "application/json");
                exchange.sendResponseHeaders(405, responseBody.length());
                try (OutputStream os = exchange.getResponseBody()) {
                    os.write(responseBody.getBytes());
                }
            }
        }
    }

    static class User {
        private int id;
        private String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "User{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}