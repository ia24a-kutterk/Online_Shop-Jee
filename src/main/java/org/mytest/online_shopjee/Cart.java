package org.mytest.online_shopjee;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/Cart")
public class Cart extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Hole die Parameter aus der Anfrage
        String quantityStr = req.getParameter("quantity");
        String productId = req.getParameter("productID");

        // Konvertiere quantity in eine Zahl
        int amount = Integer.parseInt(quantityStr);

        System.out.println("Produkt ID: " + productId);
        System.out.println("Menge: " + amount);


        OrderItemDAO dao = new OrderItemDAO();
        OrderItemAdd orderItem = new OrderItemAdd(Integer.parseInt(productId), amount);

        boolean inserted = dao.insert(orderItem);

        if (inserted) {
            resp.sendRedirect("OrderItemServlet");
        } else {
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Bestellung konnte nicht in den Warenkorb gelegt werden.");
        }
    }
}

