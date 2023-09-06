package com.codeup.adlister.dao;

import com.codeup.adlister.models.User;
import com.mysql.cj.jdbc.Driver;
import com.mysql.cj.x.protobuf.MysqlxPrepare;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLUsersDao implements Users {
    private Connection connection = null;

    public MySQLUsersDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }


    @Override
    public List<User> all() {
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM users");
            return createUserFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);
        }
    }

    @Override
    public User findByUsername(String username) {
        try {
            String sqlSearchUser = "SELECT * FROM users WHERE name LIKE ? LIMIT 1";
            PreparedStatement statement = connection.prepareStatement(sqlSearchUser);
            statement.setString(1, username);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                User user = new User(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("password")
                );
                return user;
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error finding user by username" + username + ".", e);
        }
    }

    @Override
    public long insert(User user) {
        try {
            String sqlInsertUserQuery = "INSERT INTO users (name, email, password) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sqlInsertUserQuery, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPassword());
            statement.executeUpdate();
            ResultSet results = statement.getGeneratedKeys();
            if (results.next()) {
                return user.getId();
            } else {
                return -1L;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private String registerUserQuery(User user) {
        return "INSERT INTO users (name, email, password) VALUES "
                + "('" + user.getUsername() + "', "
                + "'" + user.getEmail() + "', "
                + "'" + user.getPassword() + "')";
    }

    private User extractUser(ResultSet rs) throws SQLException {
        return new User(
                rs.getString("name"),
                rs.getString("email"),
                rs.getString("password")
        );
    }

    private List<User> createUserFromResults(ResultSet rs) throws SQLException {
        List<User> users = new ArrayList<>();
        while (rs.next()) {
            users.add(extractUser(rs));
        }
        return users;
    }
}
