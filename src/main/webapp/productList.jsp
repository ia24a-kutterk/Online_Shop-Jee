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

    <div class="container">
        <section class="search-bar row">
            <div class="col-1">
                <button class="add-button">+</button>
            </div>
            <div class="col-8">
                <input type="text" placeholder="Suchleiste" class="search-input">
            </div>
            <div class="col-1">
                <button class="search-button">Search</button>
            </div>
        </section>
        <section class="product-list row">
            <% if (products != null && !products.isEmpty()) { %>
            <% for (Product product : products) { %>
            <div class="col-12 product-card">
                <div class="row">
                    <div class="col-3">
                        <a href="ProductDetailsServlet?productID=<%= product.getProductID() %>">
                            <img src="bild/<%= product.getPicture() %>" alt="<%= product.getName() %>">
                        </a>
                    </div>
                    <div class="col-6 product-info">
                        <a class="product-titel" href="ProductDetailsServlet?productID=<%= product.getProductID() %>">
                            <h3 class="product-titel"><%= product.getName() %> - <%= product.getPrice() %> CHF</h3>
                        </a>
                        <p><%= product.getDescription() %></p>
                    </div>
                    <div class="col-3 product-actions">
                        <button class="quantity-button">-</button>
                        <span>1</span>
                        <button class="quantity-button">+</button>
                        <button class="buy-button">Einkaufen</button>
                    </div>
                </div>
            </div>
            <% } %>
            <% } else { %>
            <p class="no-products">Keine Produkte gefunden.</p>
            <% } %>
        </section>
    </div>
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
