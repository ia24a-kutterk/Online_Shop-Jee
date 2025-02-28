<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registrierung</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
    <style>
        body{
            background-color: #111;
        }

        .register-container {
            background-color: #222;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(255, 255, 255, 0.2);
            text-align: center;
            width: 500px;
            border: 2px solid white;
            margin: 50px auto;
        }

        .register-title {
            font-size: 28px;
            margin-bottom: 20px;
            font-weight: bold;
            color: white;
        }

        .input-group {
            margin-bottom: 15px;
            text-align: left;
        }

        .input-label {
            display: block;
            margin-bottom: 5px;
            font-size: 14px;
            color: white;
        }

        .input-field {
            width: 100%;
            padding: 10px;
            border: 1px solid #444;
            background-color: #333;
            color: white;
            border-radius: 5px;
            font-size: 16px;
            box-sizing: border-box;
        }

        .register-button {
            width: 50%;
            padding: 10px 15px;
            border: 2px solid white;
            background-color: transparent;
            color: white;
            cursor: pointer;
            border-radius: 5px;
            transition: background 0.3s, color 0.3s;
        }

        .register-button:hover {
            background-color: white;
            color: black;
        }

        .login-link {
            margin-top: 15px;
            font-size: 14px;
            color: white;
        }

        .login-link a {
            color: white;
            font-weight: bold;
            text-decoration: none;
        }

        .login-link a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
<div class="register-container">
    <h2 class="register-title">Registrierung</h2>
    <form action="RegisterServlet" method="post">
        <div class="input-group">
            <label class="input-label" for="username">Benutzername:</label>
            <input class="input-field" type="text" id="username" name="username" required>
        </div>
        <div class="input-group">
            <label class="input-label" for="name">Name:</label>
            <input class="input-field" type="text" id="name" name="name" required>
        </div>
        <div class="input-group">
            <label class="input-label" for="firstName">Vorname:</label>
            <input class="input-field" type="text" id="firstName" name="firstName" required>
        </div>
        <div class="input-group">
            <label class="input-label" for="email">E-Mail:</label>
            <input class="input-field" type="email" id="email" name="email" required>
        </div>
        <div class="input-group">
            <label class="input-label" for="password">Passwort:</label>
            <input class="input-field" type="password" id="password" name="password" required>
        </div>
        <div class="input-group">
            <label class="input-label" for="confirmPassword">Passwort bestätigen:</label>
            <input class="input-field" type="password" id="confirmPassword" name="confirmPassword" required>
        </div>
        <button class="register-button" type="submit">Registrieren</button>
    </form>
    <p class="login-link">Bereits registriert? <a href="login.jsp">Hier einloggen</a></p>
</div>
</body>
</html>
