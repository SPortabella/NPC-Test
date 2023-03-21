package clases;

public class Item {
    private String name;
    private String type;
    private double price;
    private double wastage;

    public Item(String name, String type, double price, double wastage) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.wastage = wastage;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public double getWastage() {
        return wastage;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", wastage=" + wastage +
                '}';
    }
}
