package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

//This class represents a customer's order and stores multiple order items with their total.
public class Order {

    private double orderTotal; //total cost of all order items
    private List<OrderItems> items; //list holding order items

    //constructor initializes the items list
    public Order() {
        this.items = new ArrayList<>();
    }

    //add an item to the order
    public void addItemToOrder(OrderItems item) {
        items.add(item);
    }

    //calculate total cost of all order items
    private double calculateOrderTotal() {
        orderTotal = 0;
        for (OrderItems item : items) {
            orderTotal += item.getCost();
        }
        return orderTotal;
    }

    //return a formatted string of the entire order with details and total
    @Override
    public String toString() {
        StringBuilder orderDetails = new StringBuilder("Order Details:\n");

        for (OrderItems item : items) {
            orderDetails.append(item.toString()).append("\n");
        }

        orderDetails.append("\nOrder Total: $")
                .append(String.format("%.2f", calculateOrderTotal()))
                .append("\n");

        return orderDetails.toString();
    }
}