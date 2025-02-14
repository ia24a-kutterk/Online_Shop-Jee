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
    <!-- Optional: Einbinden von Font Awesome für die Sterne-Icons -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" integrity="sha512-XXXXXXXXXXXX" crossorigin="anonymous" referrerpolicy="no-referrer" />
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

<main class="product-detail">
    <div class="product-container">
        <div class="product-image">
            <img src="bild/<%= product.getPicture() %>" alt="<%= product.getName() %>">
        </div>
        <div class="product-info">
            <h2><%= product.getName() %> - <%= product.getPrice() %> CHF</h2>
            <p><strong>Lagerbestand:</strong> <%= product.getAmount() %> Stück</p>
            <div class="product-rating">
                <!-- Sterneanzeige: Rating = 1 ? 1 gefüllter Stern, 4 leere Sterne -->
                <c:set var="rating" value="${product.rating}" />
                <c:forEach var="i" begin="1" end="5">
                    <c:choose>
                        <c:when test="${i <= rating}">
                            <i class="fa fa-star"></i>
                        </c:when>
                        <c:otherwise>
                            <i class="fa fa-star-o"></i>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </div>
            <p class="product-description"><strong>Beschreibung:</strong> <%= product.getDescription() %></p>
        </div>
    </div>
    <a href="ProductListServlet" class="back-button">Zurück zur Produktübersicht</a>
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
