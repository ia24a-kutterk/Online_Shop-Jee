<%@ page import="java.util.List" %>
<%@ page import="org.mytest.online_shopjee.Product" %>

<%
    List<Product> products = (List<Product>) request.getAttribute("products");
    String searchQuery = request.getParameter("search");
%>
<!DOCTYPE html>
<html lang="de">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Produktliste - SyncStore</title>
    <link href="https://fonts.googleapis.com/css2?family=Nova+Square&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="style.css">
    <script>
        function updateQuantity(productId, action) {
            var quantityElement = document.getElementById("quantity-" + productId);
            var currentQuantity = parseInt(quantityElement.innerText);
            if (action === 'increase') {
                quantityElement.innerText = currentQuantity + 1;
            } else if (action === 'decrease' && currentQuantity > 1) {
                quantityElement.innerText = currentQuantity - 1;
            }
        }

        function addToCart(productID) {
            // Hole die Menge des Produkts
            var quantity = document.getElementById('quantity-' + productID).textContent;

            // Sende die ProduktID und Menge an das AddToCartServlet
            window.location.href = 'AddToCartServlet?productID=' + productID + '&quantity=' + quantity;
        }
    </script>
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
                <a href="OrderItemServlet">Warenkorb</a>
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
        <section class="search-bar">
            <div class="col-12">
                <button class="add-button">+</button>
            </div>
            <div class="col-11">
                <form method="GET" action="ProductListServlet">
                    <input type="text" name="search" placeholder="Suchleiste" class="search-input" value="<%= searchQuery != null ? searchQuery : "" %>">
                    <button type="submit" class="search-button">Suchen</button>
                </form>
            </div>
        </section>

        <section class="product-list">
            <% if (products != null && !products.isEmpty()) { %>
            <% for (Product product : products) { %>
            <% if (searchQuery == null || product.getName().toLowerCase().contains(searchQuery.toLowerCase())) { %>
            <a href="ProductDetailsServlet?productID=<%= product.getProductID() %>" class="product-card-link">
                <div class="product-card row">
                    <div class="col-3">
                        <img src="bild/<%= product.getPicture() %>" alt="<%= product.getName() %>">
                    </div>
                    <div class="col-6">
                        <a href="ProductDetailsServlet?productID=<%= product.getProductID() %>" class="product-titel">
                            <h3 class="product-title"><%= product.getName() %> - <%= product.getPrice() %> CHF</h3>
                        </a>
                        <p class="product-description"><%= product.getDescription() %></p>
                    </div>
                    <div class="col-3 product-actions">
                        <button class="quantity-button" onclick="updateQuantity(<%= product.getProductID() %>, 'decrease')">-</button>
                        <span id="quantity-<%= product.getProductID() %>">1</span>
                        <button class="quantity-button" onclick="updateQuantity(<%= product.getProductID() %>, 'increase')">+</button>
                        <button class="buy-button" onclick="addToCart(<%= product.getProductID() %>)">Einkaufen</button>
                    </div>
                </div>
            </a>
            <% } %>
            <% } %>
            <% } else { %>
            <p class="no-products">Keine Produkte gefunden.</p>
            <% } %>
        </section>
    </div>
</main>

<footer class="footer">
    <div class="footer-content">
        <div class="footer-info">
            <h3>Contact</h3>
            <p>Email: info@onlineshop.com</p>
            <p>Telefon: +41 79 123 45 67</p>
            <p>Adresse: Musterstrasse 12, 8000 Zuerich</p>
        </div>
        <div class="footer-image">
            <img src="bild/SS_Logo-Photoroom.png" alt="Logo von SyncStore">
        </div>
    </div>
</footer>
</body>
</html>
