package org.mytest.online_shopjee.product;

public class Product {
    private int productID;
    private String name;
    private String description;
    private int amount;
    private double price;
    private int rating;
    private String picture;

    public Product() {}

    public Product(int productID, String name, String description, int amount, double price, int rating, String picture) {
        this.productID = productID;
        this.name = name;
        this.description = description;
        this.amount = amount;
        this.price = price;
        this.rating = rating;
        this.picture = picture;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}

