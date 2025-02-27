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

    private OrderItemDAO orderItemDAO = new OrderItemDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<OrderItem> orderItems = orderItemDAO.selectAll();
        double total = 0;
        int totalQuantity = 0;

        for (OrderItem orderItem : orderItems) {
            totalQuantity += orderItem.getAmount();
            total += orderItem.getTotalPrice();
        }

        request.setAttribute("orderItems", orderItems);
        request.setAttribute("total", total);
        request.setAttribute("totalQuantity", totalQuantity);

        request.getRequestDispatcher("warenkorb.jsp").forward(request, response);
    }

    // Methode zum Löschen eines einzelnen OrderItems oder der gesamten Liste
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("delete".equals(action)) {
            int orderItemID = Integer.parseInt(request.getParameter("orderItemID"));
            boolean deleted = orderItemDAO.delete(orderItemID); // Löscht das OrderItem

            if (deleted) {
                response.sendRedirect("OrderItemServlet"); // Leitet nach erfolgreichem Löschen zurück
            } else {
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Löschen fehlgeschlagen.");
            }
        } else if ("deleteAll".equals(action)) {
            boolean deletedAll = orderItemDAO.deleteAll(); // Löscht alle OrderItems

            if (deletedAll) {
                response.sendRedirect("OrderItemServlet"); // Leitet nach erfolgreichem Löschen zurück
            } else {
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Alle Bestellpositionen konnten nicht gelöscht werden.");
            }
        }
    }
}

