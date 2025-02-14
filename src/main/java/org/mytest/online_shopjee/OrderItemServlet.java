package org.mytest.online_shopjee;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/orderitems")
public class OrderItemServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<OrderItem> orderItems = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/online_shop_db?user=root");

            String sql = "SELECT oi.OrderItemID, p.Name, oi.Amount, oi.TotalPrice, p.Picture " +
                    "FROM OrderItem oi " +
                    "JOIN Product p ON oi.ProductID = p.ProductID";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                OrderItem orderItem = new OrderItem(
                        rs.getInt("OrderItemID"),
                        rs.getString("Name"),
                        rs.getInt("Amount"),
                        rs.getDouble("TotalPrice"),
                        rs.getString("Picture")
                );
                orderItems.add(orderItem);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        request.setAttribute("orderItems", orderItems);
        request.getRequestDispatcher("warenkorb.jsp").forward(request, response);
    }
}
