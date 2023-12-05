package edu.neu.csye6200;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Item {
    private String name;
    private double price;
    private static final String REVISION = "1.0";

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return name + ": $" + String.format("%.2f", price);
    }

    public static void billing(List<Item> items, double cashPayment) {
        // Get the current date and time
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date now = new Date();
        String formattedDateTime = dateFormat.format(now);

        double totalCost = 0;
        for (Item item : items) {
            totalCost += item.price;
        }
        // Print itemized receipt
        System.out.println("Receipt");
        System.out.println("*******");
        System.out.println("Current Date & Time: " + formattedDateTime);
        System.out.println("");
        System.out.println("Items purchased:");
        for (Item item : items) {
            System.out.println(item);
        }
        System.out.println("");
        System.out.println("Total cost: $" + String.format("%.2f", totalCost));

        if (cashPayment >= totalCost) {
            double change = cashPayment - totalCost;
            System.out.println("Payment: $" + String.format("%.2f", cashPayment));
            System.out.println("");
            System.out.println("Change: $" + String.format("%.2f", change));
            System.out.println("Thank You for Shopping");
        } else {
            System.out.println("Insufficient funds. Payment failed.");
        }
    }
    public static void demo()
    {
    	{
            Item item1 = new Item("Apple", 10.89);
            Item item2 = new Item("Mango", 6.69);
            Item item3 = new Item("Bananna", 1.99);

            List<Item> itemsToPurchase = new ArrayList<>();
            itemsToPurchase.add(item1);
            itemsToPurchase.add(item2);
            itemsToPurchase.add(item3);

            double cashPayment = 20.00;

            Item.billing(itemsToPurchase, cashPayment);
        }
    }
}
