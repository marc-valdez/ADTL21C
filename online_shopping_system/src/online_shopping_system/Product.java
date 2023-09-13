package online_shopping_system;

public class Product {
    private int ID;

    public int getID() {
        return ID;
    }

    public void setID(int newValue) {
        ID = newValue;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String newValue) {
        name = newValue;
    }

    private double price;

    public double getPrice() {
        return price;
    }

    public void setPrice(double newValue) {
        price = newValue;
    }

    private static int lastAssignedID = 0;

    // Constructor
    public Product(String name, double price) {
        this.ID = lastAssignedID++;
        this.name = name;
        this.price = price;
    }

    public String toString() {
        return "[" + Integer.toString(ID) + "] " + name + ", $" + price;
    }
}