package org.mytest.online_shopjee;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        System.out.println(username);
        System.out.println(password);

        UserDAO userDAO = new UserDAO();
        User user = userDAO.login(username, password);

        if (user != null) {
            // Benutzerdaten in Session speichern
            HttpSession session = request.getSession();
            session.setAttribute("user", user);  // Benutzerobjekt in der Session speichern
            session.setAttribute("isLoggedIn", true);  // Login-Status speichern

            // Weiterleitung zur nächsten Seite
            response.sendRedirect("OrderItemServlet");
        } else {
            // Bei falschen Anmeldedaten zurück zur Login-Seite mit Fehlernachricht
            response.sendRedirect("login.jsp?error=true");
        }
    }
}
