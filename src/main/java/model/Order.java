package model;

/**
 * Order is the main entity we'll be using to do CRUD operations on orders from the database tabla called orderr
 *
 *
 * @author Szekely Maria-Robertha
 */

public class Order {

    private int id;
    private final int clientID;
    private final String clientName;
    private final int productID;
    private final String productName;
    private final int quantity;
    private final double price;

    public Order(int id, int clientID, String clientName, int productID, String productName, int quantity, double price) {
        this.id = id;
        this.clientID = clientID;
        this.productID = productID;
        this.quantity = quantity;
        this.productName = productName;
        this.clientName = clientName;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClientID() {
        return clientID;
    }

    public int getProductID() {
        return productID;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getProductName() {
        return productName;
    }

    public String getClientName() {
        return clientName;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Order [orderID = " + id + ", clientID = " + clientID + ", clientName = " + clientName + ", productID = " + productID + ", productName = " + productName + "]";
    }
}