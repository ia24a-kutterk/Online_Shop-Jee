package org.mytest.online_shopjee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderItemDAO {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/online_shop_db?user=root";
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";

    // Methode zum Abrufen aller OrderItems
    public List<OrderItem> selectAll() {
        List<OrderItem> orderItems = new ArrayList<>();
        String sql = "SELECT oi.OrderItemID, p.Name, oi.Amount, p.Picture, p.ProductID, p.Price " +
                "FROM OrderItem oi " +
                "JOIN Product p ON oi.ProductID = p.ProductID";

        try (Connection connection = DriverManager.getConnection(JDBC_URL);
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                double price = resultSet.getDouble("Price");
                int amount = resultSet.getInt("Amount");
                double itemTotalPrice = price * amount;

                OrderItem orderItem = new OrderItem(
                        resultSet.getInt("OrderItemID"),
                        resultSet.getString("Name"),
                        amount,
                        itemTotalPrice,
                        resultSet.getString("Picture"),
                        resultSet.getInt("ProductID"),
                        price
                );
                orderItems.add(orderItem);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return orderItems;
    }

    // Methode zum Löschen eines OrderItems anhand der OrderItemID
    public boolean delete(int orderItemID) {
        String sql = "DELETE FROM OrderItem WHERE OrderItemID = ?";
        try (Connection connection = DriverManager.getConnection(JDBC_URL);
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, orderItemID);
            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    // Methode zum Löschen aller OrderItems
    public boolean deleteAll() {
        String sql = "DELETE FROM OrderItem";
        try (Connection connection = DriverManager.getConnection(JDBC_URL);
             PreparedStatement statement = connection.prepareStatement(sql)) {

            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean insert(OrderItemAdd orderItem) {
        String sql = "INSERT INTO OrderItem (ProductID, Amount) VALUES (?, ?)";
        try (Connection connection = DriverManager.getConnection(JDBC_URL);
             PreparedStatement statement = connection.prepareStatement(sql)) {

            // Setze die Parameter für das SQL-Statement
            statement.setInt(1, orderItem.getProductID());
            statement.setInt(2, orderItem.getAmount());

            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
