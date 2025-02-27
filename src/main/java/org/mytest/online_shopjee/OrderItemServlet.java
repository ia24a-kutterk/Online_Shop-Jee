package org.mytest.online_shopjee;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@WebServlet(value = "/OrderItemServlet")
public class OrderItemServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<OrderItem> orderItems = new ArrayList<>();
        double total = 0;  // Gesamtpreis
        int totalQuantity = 0;  // Gesamtanzahl der Produkte

        String jdbcURL = "jdbc:mysql://localhost:3306/online_shop_db?user=root";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(jdbcURL);
            String sql = "SELECT oi.OrderItemID, p.Name, oi.Amount, p.Picture, p.ProductID, p.Price " +
                    "FROM OrderItem oi " +
                    "JOIN Product p ON oi.ProductID = p.ProductID";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                double price = resultSet.getDouble("Price");
                int amount = resultSet.getInt("Amount");
                double itemTotalPrice = price * amount; // Berechnung des Gesamtpreises für dieses Produkt

                OrderItem orderItem = new OrderItem(
                        resultSet.getInt("OrderItemID"),
                        resultSet.getString("Name"),
                        amount,
                        itemTotalPrice,  // Verwende berechneten Preis
                        resultSet.getString("Picture"),
                        resultSet.getInt("ProductID"),
                        price
                );
                orderItems.add(orderItem);

                // Berechne Gesamtpreis und Gesamtanzahl
                totalQuantity += amount;
                total += itemTotalPrice; // Gesamtpreis basierend auf berechnetem itemTotalPrice
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Setze die berechneten Werte als Attribute
        request.setAttribute("orderItems", orderItems);
        request.setAttribute("total", total);
        request.setAttribute("totalQuantity", totalQuantity);

        request.getRequestDispatcher("warenkorb.jsp").forward(request, response);
    }
}
