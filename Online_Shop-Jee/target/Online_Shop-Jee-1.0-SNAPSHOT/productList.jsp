<%@ page import="java.util.List" %>

<%
    List<String> products = (List<String>) request.getAttribute("products");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Produktliste</title>
</head>
<body>
<h1>Produktliste</h1>
<ul>
    <% if (products != null) { %>
    <% for (String product : products) { %>
    <li><%= product %></li>
    <% } %>
    <% } else { %>
    <p>Keine Produkte gefunden.</p>
    <% } %>
</ul>
</body>
</html>
