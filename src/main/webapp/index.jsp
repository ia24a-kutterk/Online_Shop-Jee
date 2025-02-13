<!DOCTYPE html>
<html lang="de">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Hompage SyncStore</title>
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
                <a href="#">Homepage</a> |
                <a href="ProductListServlet">Products</a> |
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
        <h2>Startseite</h2>
    </section>
    <section class="welcome-text">
        <section class="col-12">
            <section class="welcome">
                <h3>Willkommen in unserem Online-Shop!</h3>

                <p>Entdecke eine Welt voller exklusiver Produkte, die deinen Alltag bereichern. Egal, ob du nach den neuesten Trends, hochwertigen Essentials oder besonderen Angeboten suchst - bei uns findest du alles an einem Ort. Stoebere durch unser Sortiment, profitiere von schnellen Lieferzeiten und geniesse ein unkompliziertes Einkaufserlebnis.</p>

                <p> Deine Zufriedenheit steht bei uns an erster Stelle - viel Spass beim Shoppen!</p>
            </section>
        </section>
    </section>

    <!-- Produktreihe -->

    <section class="product-row">
           <a class="product-box" href="ProductListServlet">
                <div class="col-3">
                    <div>
                        <img src="bild/shopping_card.png" alt="Product">
                        <p>Product</p>
                    </div>
                </div>
           </a>
        <div class="col-3">
        </div>
        <div class="col-3">
        </div>
        <div class="col-3">
        </div>
    </section>
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
