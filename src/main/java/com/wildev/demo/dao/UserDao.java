package com.wildev.demo.dao;

import com.wildev.demo.config.DatabaseConnection;
import com.wildev.demo.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    // CREATE
    public void createUser(User user) {

        String sql = "INSERT INTO users(name, email) VALUES (?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, user.getName());
            stmt.setString(2, user.getEmail());

            stmt.executeUpdate();

            System.out.println("Usuario creado 🚀");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // READ (LISTAR)
    public List<User> getUsers() {

        List<User> users = new ArrayList<>();

        String sql = "SELECT * FROM users";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {

                User user = new User(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email")
                );

                users.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }
    //UPDATE
    public void updateUser(User user) {

        String sql =
                "UPDATE users SET name = ?, email = ? WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, user.getName());
            stmt.setString(2, user.getEmail());
            stmt.setInt(3, user.getId());

            int rows = stmt.executeUpdate();

            if (rows > 0) {
                System.out.println("Usuario actualizado 🚀");
            } else {
                System.out.println("No se encontró el usuario ❌");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //DELETE
    public void deleteUser(int id) {

        String sql = "DELETE FROM users WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            int rows = stmt.executeUpdate();

            if (rows > 0) {
                System.out.println("Usuario eliminado 🗑️");
            } else {
                System.out.println("No se encontró el usuario ❌");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}