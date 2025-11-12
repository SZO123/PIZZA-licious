package com.pluralsight;

import static com.pluralsight.Main.scanner;

//This class represents garlic knots, a side item with a fixed price per order.
public class GarlicKnots extends OrderItems{

    private int quantity; //number of garlic knot orders
    private final double price = 1.50; //fixed price per order

    //constructor sets quantity
    public GarlicKnots(int quantity) {
        this.quantity = quantity;
    }

    //default constructor
    public GarlicKnots() {
    }

    //method to prompt user for quantity and add garlic knots to order
    static void addKnotsToOrder(Order order) {
        System.out.print("How many garlic knot orders would you like? ");
        int quantity = Integer.parseInt(scanner.nextLine());

        if (quantity <= 0) {
            System.out.println("Invalid quantity.");
            return;
        }

        GarlicKnots knots = new GarlicKnots(quantity);
        order.addItemToOrder(knots);

        System.out.println("Added " + quantity + " order(s) of Garlic Knots for $" + String.format("%.2f", knots.getCost()));
        System.out.println("-------------------------------------------------------------------");
    }

    //returns total cost of garlic knots
    @Override
    public double getCost() {
        return quantity * price;
    }

    //returns formatted garlic knot details
    @Override
    public String toString() {
        return "\nGarlic Knots:" +
                "\nQuantity: " + quantity +
                "\nPrice: $" + String.format("%.2f", getCost());
    }
}