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

@WebServlet(value="/ProductDetailsServlet")
public class ProductDetailsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int productID = Integer.parseInt(request.getParameter("productID"));
        Product product = null;

        String jdbcURL = "jdbc:mysql://localhost:3306/online_shop_db?user=root";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(jdbcURL);
            String sql = "SELECT ProductID, Name, Description, Amount, Price, rating, picture FROM Product WHERE ProductID = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, productID);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                product = new Product(
                        resultSet.getInt("ProductID"),
                        resultSet.getString("Name"),
                        resultSet.getString("Description"),
                        resultSet.getInt("Amount"),
                        resultSet.getDouble("Price"),
                        resultSet.getInt("rating"),
                        resultSet.getString("picture")
                );
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Setze das Produkt als Attribut für die JSP
        request.setAttribute("product", product);
        request.getRequestDispatcher("productDetails.jsp").forward(request, response);
    }

    public static class ProductDAO {
        private static final String URL = "jdbc:mysql://localhost:3306/onlineshop?user=root";

        public Product getProductById(int productID) {
            String sql = "SELECT * FROM Product WHERE ProductID = ?";
            try (Connection connection = DriverManager.getConnection(URL);
                 PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setInt(1, productID);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    return new Product(
                            rs.getInt("ProductID"),
                            rs.getString("Name"),
                            rs.getString("Description"),
                            rs.getInt("Amount"),
                            rs.getDouble("Price"),
                            rs.getInt("Rating"),
                            rs.getString("Picture")
                    );
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}
