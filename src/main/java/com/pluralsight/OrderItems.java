package com.pluralsight;

//This abstract class defines the structure for all order items like Pizza, Drinks, and Garlic Knots.
public abstract class OrderItems {

    //calculate the total cost of an order item
    public abstract double getCost();

    //convert the order item to a formatted string
    public abstract String toString();
}