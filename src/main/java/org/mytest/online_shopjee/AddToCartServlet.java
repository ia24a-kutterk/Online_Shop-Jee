package org.mytest.online_shopjee;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/AddToCartServlet")
public class AddToCartServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int productId = Integer.parseInt(request.getParameter("productID"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        // Produkt aus der Datenbank holen
        Product product = getProductById(productId);
        double totalPrice = product.getPrice() * quantity; // Gesamtpreis berechnen

        // Neue OrderItem erstellen
        OrderItem orderItem = new OrderItem(0, product.getName(), quantity, totalPrice, product.getPicture(), productId, product.getPrice());

        // Speichern in der Datenbank
        saveOrderItemToDatabase(orderItem);

        // Bestellpositionen in der Session speichern
        HttpSession session = request.getSession();
        List<OrderItem> orderItems = (List<OrderItem>) session.getAttribute("orderItems");
        if (orderItems == null) {
            orderItems = new ArrayList<>();
            session.setAttribute("orderItems", orderItems);
        }
        orderItems.add(orderItem);

        // Weiterleitung zum Warenkorb (OrderItemServlet)
        response.sendRedirect("OrderItemServlet");
    }

    private Product getProductById(int productId) {
        // Hier wird das Produkt aus der Datenbank geholt (Datenbankabfrage anpassen)
        return new Product(productId, "Produktname", "Produktbeschreibung", 10, 20.0, 5, "bild.jpg");
    }

    private void saveOrderItemToDatabase(OrderItem orderItem) {
        // Hier wird das OrderItem in die Datenbank gespeichert (z. B. mit JDBC)
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineshop?user=root")) {
            String sql = "INSERT INTO OrderItems (productID, name, quantity, totalPrice, picture) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setInt(1, orderItem.getProductID());
                stmt.setString(2, orderItem.getName());
                stmt.setInt(3, orderItem.getAmount());
                stmt.setDouble(4, orderItem.getTotalPrice());
                stmt.setString(5, orderItem.getPicture());
                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
