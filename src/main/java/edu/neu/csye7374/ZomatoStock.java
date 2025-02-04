package edu.neu.csye7374;

import java.util.ArrayList;
import java.util.List;

public class ZomatoStock extends Stock{
    private List<Double> bids = new ArrayList<>();

    public ZomatoStock() {
        this.setName("Zomato");
        this.setDescription("Food Delivery");
        this.setPrice(48.6);
    }

    @Override
    public String getMetric() {
        if (bids.isEmpty()) {
            return "No valid bids yet.";
        }
        // Calculate the average of all bids
        double averageBid = bids.stream().mapToDouble(b -> b).average().orElse(0.0);
        double newMetric = ((averageBid - this.getPrice()) / this.getPrice()) * 100;
        return String.valueOf(newMetric);
    }

    @Override
    public void setBid(String bid) {
        if (bid == null || bid.isEmpty()) {
            System.out.println("Invalid bid, no update made.");
            return;
        }

        try {
            double newBid = Double.parseDouble(bid);
            bids.add(newBid);
            super.setBid(bid);  // Updates the bid in the parent class

            // Update price based on the average of all bids
            double averageBid = bids.stream().mapToDouble(b -> b).average().orElse(this.getPrice());
            double currentPrice = this.getPrice();
            double newPrice = currentPrice + (averageBid - currentPrice) * 0.1;
            this.setPrice(newPrice);

        } catch (NumberFormatException e) {
            System.out.println("Invalid bid format, please provide a numeric value.");
        }
    }
}
