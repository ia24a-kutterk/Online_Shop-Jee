package org.mytest.online_shopjee;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String firstName = request.getParameter("firstName");
        String email = request.getParameter("email");

        User newUser = new User(0, username, password, name, firstName, email, "platzhalter.webp");

        System.out.println(newUser);
        UserDAO userDAO = new UserDAO();
        userDAO.insertUser(newUser);

        response.sendRedirect("login.jsp");
    }
}
