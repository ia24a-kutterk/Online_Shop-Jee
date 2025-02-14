package org.mytest.online_shopjee;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/AddToCartServlet")
public class AddToCartServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int productId = Integer.parseInt(request.getParameter("productID"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        HttpSession session = request.getSession();
        List<OrderItem> orderItems = (List<OrderItem>) session.getAttribute("orderItems");
        if (orderItems == null) {
            orderItems = new ArrayList<>();
            session.setAttribute("orderItems", orderItems);
        }

        Product product = getProductById(productId);
        double totalPrice = product.getPrice() * quantity;

        int orderItemID = (int) (Math.random() * 10000);

        OrderItem orderItem = new OrderItem(orderItemID, product.getName(), quantity, totalPrice, product.getPicture()); // Übergib alle 5 Argumente
        orderItems.add(orderItem);
        response.sendRedirect("orderitems");
    }

    private Product getProductById(int productId) {
        return new Product(productId, "Produktname", "Produktbeschreibung", 10, 20.0, 5, "bild.jpg");
    }
}



