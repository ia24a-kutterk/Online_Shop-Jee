package org.mytest.online_shopjee;

public class OrderItemAdd {
    private int productID;
    private int amount;

    public OrderItemAdd(int productID, int amount) {
        this.productID = productID;
        this.amount = amount;
    }

    public int getProductID() {
        return productID;
    }
    public void setProductID(int productID) {
        this.productID = productID;
    }
    public int getAmount() {
        return amount;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }
}


