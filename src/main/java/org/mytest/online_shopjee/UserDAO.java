package org.mytest.online_shopjee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/online_shop_db?user=root";
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";

    // HINZUGEFÜGT: Statischer Initialisierungsblock zum Laden des JDBC-Treibers
    static {
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL);
    }

    public User login(String username, String password) {
        String sql = "SELECT * FROM User WHERE Username = ? AND Password = ?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new User(
                        rs.getInt("UserID"),
                        rs.getString("Username"),
                        rs.getString("Password"),
                        rs.getString("Name"),
                        rs.getString("FirstName"),
                        rs.getString("Email"),
                        rs.getString("Picture")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // GEÄNDERT: SQL-Anweisung um Picture-Spalte ergänzt
    public void insertUser(User user) {
        String sql = "INSERT INTO User (Username, Password, Name, FirstName, Email, Picture) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getName());
            ps.setString(4, user.getFirstName());
            ps.setString(5, user.getEmail());
            ps.setString(6, user.getPicture());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> selectAllUsers() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM User";
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                users.add(new User(
                        rs.getInt("UserID"),
                        rs.getString("Username"),
                        rs.getString("Password"),
                        rs.getString("Name"),
                        rs.getString("FirstName"),
                        rs.getString("Email"),
                        rs.getString("Picture")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    // GEÄNDERT: SQL-Anweisung um Picture-Spalte ergänzt und Parameter-Reihenfolge korrigiert
    public void updateUser(User user) {
        String sql = "UPDATE User SET Username = ?, Password = ?, Name = ?, FirstName = ?, Email = ?, Picture = ? WHERE UserID = ?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getName());
            ps.setString(4, user.getFirstName());
            ps.setString(5, user.getEmail());
            ps.setString(6, user.getPicture()); // Neu: Parameter für Picture
            ps.setInt(7, user.getUserID());       // Neu: UserID als Parameter 7
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete a user from the database
    public void deleteUser(int userID) {
        String sql = "DELETE FROM User WHERE UserID = ?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, userID);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
