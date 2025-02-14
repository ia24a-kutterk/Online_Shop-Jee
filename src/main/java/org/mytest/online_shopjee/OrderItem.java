package org.mytest.online_shopjee;

public class OrderItem {
    private int orderItemID;
    private String name;
    private int amount;
    private double totalPrice;
    private String picture;

    public OrderItem(int orderItemID, String name, int amount, double totalPrice, String picture) {
        this.orderItemID = orderItemID;
        this.name = name;
        this.amount = amount;
        this.totalPrice = totalPrice;
        this.picture = picture;
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
}
