package org.mytest.online_shopjee.product;

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

@WebServlet("/ProductListServlet")
public class ProductListServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> products = new ArrayList<>();

        // Stelle sicher, dass die JDBC-Treiber verfügbar sind
        String jdbcURL = "jdbc:mysql://localhost:3306/shop?user=root";

        try {
            Connection connection = DriverManager.getConnection(jdbcURL);
            String sql = "SELECT * FROM Product";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Product product = new Product(
                        resultSet.getInt("ProductID"),
                        resultSet.getString("Name"),
                        resultSet.getString("Description"),
                        resultSet.getInt("Amount"),
                        resultSet.getDouble("Price"),
                        resultSet.getInt("rating"),
                        resultSet.getString("picture")
                );
                System.out.println("Produkt gefunden: " + product.getName());
                products.add(product);
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        request.setAttribute("products", products);
        request.getRequestDispatcher("productList.jsp").forward(request, response);
    }
}
