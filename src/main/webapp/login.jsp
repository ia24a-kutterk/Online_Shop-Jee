<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login SyncStore</title>
    <link href="https://fonts.googleapis.com/css2?family=Nova+Square&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="style.css">
</head>
<body>
<main class="center">
    <div class="login-container-unique">
        <%
            // Entferne die folgende Zeile, da 'session' bereits vorhanden ist:
            // HttpSession session = request.getSession();
            Boolean isLoggedIn = (Boolean) session.getAttribute("isLoggedIn");
            if (isLoggedIn != null && isLoggedIn) {
        %>
        <!-- Benutzer ist eingeloggt -->
        <div class="logo-container">
            <img src="logo.png" alt="SyncStore Logo">
        </div>
        <% } %>
        <h2 class="login-title-unique">Login</h2>
        <form action="LoginServlet" method="post">
            <div class="input-group-unique">
                <input type="text" id="username" name="username" class="input-field-unique" placeholder="Username" required>
            </div>
            <div class="input-group-unique">
                <input type="password" id="password" name="password" class="input-field-unique" placeholder="Password" required>
            </div>
            <div class="options-unique">
                <input type="checkbox" id="remember-me" name="remember-me" class="checkbox-unique">
                <label for="remember-me" class="checkbox-label-unique">Remember Me</label>
                <button type="submit" class="login-button-unique">Sign In</button>
            </div>
        </form>
        <% if (request.getParameter("error") != null) { %>
        <p style="color: red;">Invalid username or password. Please try again.</p>
        <% } %>
        <p class="register-link-unique">New to SyncStore? <a href="register.jsp" class="register-unique">Register here</a></p>
    </div>
</main>
</body>
</html>
