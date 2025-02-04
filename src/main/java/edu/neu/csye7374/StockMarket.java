package edu.neu.csye7374;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StockMarket {
    private List<Stock> stocks;
    private static StockMarket instance = null;

    // Private constructor for Singleton pattern
    private StockMarket() {
        stocks = new ArrayList<>();
    }

    // Lazy initialization of Singleton instance
    public static synchronized StockMarket getInstance() {
        if (instance == null) {
            instance = new StockMarket();
        }
        return instance;
    }

    // Add stock to the stock market
    public void addStock(Stock stock) {
        System.out.println("Stock " + stock.getName() + " has been added to the stock market.");
        this.stocks.add(stock);
    }

    // Remove stock from the stock market by name
    public void removeStock(String stockName) {
        Iterator<Stock> iterator = stocks.iterator();
        while (iterator.hasNext()) {
            Stock stock = (Stock) iterator.next();
            if (stock.getName().equalsIgnoreCase(stockName)) {
                iterator.remove();
                System.out.println("Stock " + stockName + " has been removed from the stock market.");
            }
        }
    }

    // Show details of all stocks currently in the market
    public void showAllStocks() {
        System.out.println("-------------------------------------------");
        System.out.println("       Stocks Currently in the Market       ");
        System.out.println("-------------------------------------------");
        System.out.printf("%-15s %-15s %-15s %n", "Stock Name", "Price", "Description");
        System.out.println("===========================================");

        for (Stock stock : this.stocks) {
            if (stock instanceof Stock) {
                System.out.printf("%-15s $%-14.2f %-15s %n",
                        stock.getName(),
                        stock.getPrice(),
                        stock.getDescription()
                );
            }
        }
    }


    // Show details of a specific stock by name
    public void showStock(String name) {
        for (Stock stock : stocks) {
            if (stock.getName().equalsIgnoreCase(name)) {
                System.out.println(stock);
            }
        }
    }

    // Trade stock by placing a bid
    public void tradeStock(String stockName, String bid) {
        System.out.println("Trading " + stockName + " stock for a bid of $" + bid + ".");
        for (Stock stock : stocks) {

            if (stock.getName().equalsIgnoreCase(stockName)) {
                stock.setBid(bid);
            }
        }
    }


    // Method to execute all market operations (this consolidates all trading logic)
    public void executeMarketOperations() {
        Stock zoox = new ZooxStock();
        Stock zomato = new ZomatoStock();

        this.addStock(zoox);
        this.addStock(zomato);

        // Trade Zoox stock with multiple bids
        String[] bids1 = {"12480", "12560", "12490", "12630", "12650", "12690"};
        System.out.println("\n============Zoox Inc Stock===================\n");
        for (String bid : bids1) {
            this.tradeStock("Zoox Inc", bid);
            this.showStock("Zoox Inc");
        }
        System.out.println("============End of Zoox Inc Stock===================\n");

        // Trade Zomato stock with multiple bids
        String[] bids2 = {"50", "47", "62", "67", "71", "77"};
        System.out.println("\n============Zomato Stock===================\n");
        for (String bid : bids2) {
            this.tradeStock("Zomato", bid);
            this.showStock("Zomato");
        }
        System.out.println("============End of Zomato Stock===================\n");

        System.out.println("============Display All Stocks in Market===================\n");
        this.showAllStocks();
        System.out.println("\n");
        System.out.println("====================================================\n");

        this.showAllStocks();
    }
}
