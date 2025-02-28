package org.mytest.online_shopjee;

public class OrderItem {
    private int orderItemID;
    private String name;
    private int amount;
    private double totalPrice;
    private String picture;
    private int productID;
    private double price;

    public OrderItem(int orderItemID, String name, int amount, double totalPrice, String picture, int productID, double price) {
        this.orderItemID = orderItemID;
        this.name = name;
        this.amount = amount;
        this.totalPrice = totalPrice;
        this.picture = picture;
        this.productID = productID;
        this.price = price;
    }

    public int getOrderItemID() {
        return orderItemID;
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public String getPicture() {
        return picture;
    }

    public int getProductID() {
        return productID;
    }

    public double getPrice() {
        return price;
    }
}
