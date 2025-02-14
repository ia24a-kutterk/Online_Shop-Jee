<%@ page import="org.mytest.online_shopjee.OrderItem" %>
<%@ page import="java.util.List" %>
<%@ page import="org.mytest.online_shopjee.Product" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  List<OrderItem> orderItems = (List<OrderItem>) request.getAttribute("orderItems");
  List<Product> products = (List<Product>) request.getAttribute("products");
%>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Warenkorb SyncStore</title>
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
        <a href="ProductListServlet">Products</a> |
        <a href="#">Warenkorb</a>
      </nav>
    </div>
    <div class="col-1 user-box">
      <span>User</span>
    </div>
  </div>
</header>

<main>
  <section class="hero">
    <h2>Warenkorb</h2>
  </section>

  <div class="container">
    <section class="product-list row">
      <% if (orderItems != null && !orderItems.isEmpty()) { %>
      <% for (OrderItem item : orderItems) { %>
      <div class="col-12 product-card">
        <div class="row">
          <div class="col-3">
            <%
              Product product = null;
              // Suche das Produkt, das zum OrderItem gehört
              for (Product p : products) {
                if (p.getProductID() == product.getProductID()) {
                  product = p;
                  break;
                }
              }
            %>
            <a href="ProductDetailsServlet?productID=<%= product.getProductID() %>">
              <img src="bild/<%= product.getPicture() %>" alt="<%= product.getName() %>">
            </a>
          </div>
          <div class="col-6 product-info">
            <a class="product-titel" href="ProductDetailsServlet?productID=<%= product.getProductID() %>">
              <h3 class="product-titel"><%= product.getName() %> - <%= item.getTotalPrice() %> CHF</h3>
            </a>
            <p><%= item.getAmount() %> items, Total: <%= item.getTotalPrice() %> CHF</p>
          </div>
          <div class="col-3 product-actions">
            <button class="delete-button" onclick="deleteItem(<%= item.getOrderItemID() %>)">Löschen</button>
          </div>
        </div>
      </div>
      <% } %>
      <% } else { %>
      <p class="no-products">Keine Bestellpositionen gefunden.</p>
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
