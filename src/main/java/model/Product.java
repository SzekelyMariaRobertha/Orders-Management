package model;

/**
 * Product is the main entity we'll be using to do CRUD operations on products from the database tabla called product
 *
 *
 * @author Szekely Maria-Robertha
 */

public class Product {

    private int id;
    private String name;
    private final int stock;
    private final double price;

    public Product(int id, String name, int stock, double price) {
        this.id = id;
        this.name = name;
        this.stock = stock;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStock() {
        return stock;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product [id = " + id + ", name = " + name + ", stock = " + stock + "]";
    }
}
