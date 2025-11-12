package com.pluralsight;

import static com.pluralsight.Main.scanner;

//This class represents a drink item in an order. It contains size, name, and price.
public class Drinks extends OrderItems {

    private double price; //price varies by size
    private String drinkSize; //small, medium, large
    private String drinkName; //Pepsi, Coke, etc.

    //default constructor
    public Drinks() {
    }

    //getters and setters
    public String getDrinkSize() {
        return drinkSize;
    }

    public void setDrinkSize(String drinkSize) {
        this.drinkSize = drinkSize;
    }

    public String getDrinkName() {
        return drinkName;
    }

    public void setDrinkName(String drinkName) {
        this.drinkName = drinkName;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    //this static method prompts the user to make a selection, then adds the drink to the order
    static void addDrinkToOrder(Order order) {
        Drinks drink = new Drinks();
        double price = 0;

        System.out.println("What drink would you like to order? ");

        for (int i = 0; i < MenuItems.drinks.length; i++) {
            System.out.println(i + 1 + ") " + MenuItems.drinks[i]);
        }

        System.out.print("\nEnter selection: ");
        int selection = Integer.parseInt(scanner.nextLine());
        System.out.println("-------------------------------------------------------------------");

        if (selection <= 0 || selection > MenuItems.drinks.length) {
            System.out.println("Invalid selection.");
            return;
        }

        drink.setDrinkName(MenuItems.drinks[selection - 1]);

        System.out.println("Select drink size: ");
        System.out.println("1) Small");
        System.out.println("2) Medium");
        System.out.println("3) Large");
        System.out.print("\nSize selection: ");
        int size = Integer.parseInt(scanner.nextLine());
        System.out.println("-------------------------------------------------------------------");

        switch (size) {
            case 1:
                drink.setDrinkSize("Small");
                price = 2.00;
                break;
            case 2:
                drink.setDrinkSize("Medium");
                price = 2.50;
                break;
            case 3:
                drink.setDrinkSize("Large");
                price = 3.00;
                break;
            default:
                System.out.println("Invalid size selection.");
                return;
        }

        drink.setPrice(price);
        order.addItemToOrder(drink);

        System.out.println("You selected a " + drink.getDrinkSize() + " " + drink.getDrinkName() + " for $" + drink.getCost());
        System.out.println("-------------------------------------------------------------------");
    }

    //returns drink price
    @Override
    public double getCost() {
        return price;
    }

    //returns formatted drink details
    @Override
    public String toString() {
        return "\nDrink: " +
                "\nFlavor: " + drinkName +
                "\nSize: " + drinkSize +
                "\nPrice: $" + String.format("%.2f", price);
    }
}