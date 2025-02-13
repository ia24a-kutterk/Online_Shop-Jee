<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<%@ page import="org.mytest.online_shopjee.Product" %>


<%
    Product product = (Product) request.getAttribute("product");
%>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Product-Details SyncStore</title>
    <link href="https://fonts.googleapis.com/css2?family=Nova+Square&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="style.css">
</head>
<body>
<header>
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
<h2>Details zum Produkt: <%= product.getName() %></h2>
<img src="bild/<%= product.getPicture() %>" alt="<%= product.getName() %>">
<p><strong>Preis:</strong> <%= product.getPrice() %> CHF</p>
<p><strong>Beschreibung:</strong> <%= product.getDescription() %></p>
<p><strong>Verfügbarkeit:</strong> <%= product.getAmount() %> Stück</p>
<p><strong>Bewertung:</strong> <%= product.getRating() %> / 5</p>
<!-- Weitere Details hinzufügen -->
<a href="ProductListServlet">Zurück zur Produktübersicht</a>
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
