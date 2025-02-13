<%@ page import="java.util.List" %>
<%@ page import="org.mytest.online_shopjee.Product" %>

<%
    List<Product> products = (List<Product>) request.getAttribute("products");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Product SyncStore</title>
    <link href="https://fonts.googleapis.com/css2?family=Nova+Square&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="style.css">
</head>
<body>
<header class="container">
    <div class="row">
        <div class="col-1">
            <div class="logo-img">
                <a href="index.jsp">
                    <img src="bild/SS_Logo-Photoroom.png" alt="Logo von SyncStore">
                </a>
            </div>
        </div>
        <div class="col-4">
            <h1>SyncStore</h1>
        </div>
        <div class="col-4">
            <nav>
                <a href="index.jsp">Homepage</a> |
                <a href="#">Products</a> |
                <a href="warenkorb.jsp">Warenkorb</a>
            </nav>
        </div>
        <div class="col-1 user-box">
            <span>User</span>
        </div>
    </div>
</header>


<main>
    <section class="hero">
        <h2>Products</h2>
    </section>
    <ul>
        <% if (products != null && !products.isEmpty()) { %>
        <% for (Product product : products) { %>
        <li><%= product.getName() %> - <%= product.getDescription() %> - <%= product.getAmount() %> - <%= product.getPrice() %> - <%= product.getRating() %> - <img src="<%= product.getPicture() %>" alt="<%= product.getName() %>"></li>
        <% } %>
        <% } else { %>
        <p>Keine Produkte gefunden.</p>
        <% } %>
    </ul>
</main>


<footer class="footer">
    <div class="footer-content">
        <!-- Kontaktinformationen -->
        <div class="footer-info">
            <h3>Contact</h3>
            <p>Email: info@onlineshop.com</p>
            <p>Telefon: +41 79 123 45 67</p>
            <p>Adresse: Musterstrasse 12, 8000 Zuerich</p>
        </div>

        <!-- Platzhalterbild -->
        <div class="footer-image">
            <img src="bild/SS_Logo-Photoroom.png" alt="Logo von SyncStore">
        </div>
    </div>
</footer>
</body>
</html>
