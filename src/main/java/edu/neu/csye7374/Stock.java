package edu.neu.csye7374;

public abstract class Stock implements Tradable {
    private String name;
    private double price;
    private String description;
    private String bid;

    @Override
    public void setBid(String bid) {
        double newBid = Double.parseDouble(bid);
        if (this.bid == null || Double.parseDouble(this.bid) < newBid) {
            this.bid = bid;
        }
        // Price update logic will be implemented by subclasses
    }

    public String getBid() {
        return bid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "\n" + name + " Stock\n" +
                "Current price: $" + price + "\n" +
                "Current bid: $" + bid + "\n" +
                "Description: " + description + "\n" +
                "Metric: " + getMetric() + "\n\n";
    }
}
