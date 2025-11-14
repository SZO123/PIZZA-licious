package com.pluralsight;

import java.util.Scanner;

//This main class serves as the user interface. It contains the home screen, order screen, and checkout screen.
public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        homeScreen();
    }

    //this method is the home screen
    public static void homeScreen() {
        int selection;
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("\n Welcome to PIZZA-licious, how can we help you?");
            System.out.println("-------------------------------------------------------------------");
            System.out.println("1) New Order");
            System.out.println("0) Exit");
            System.out.print("\nEnter selection: ");
            selection = Integer.parseInt(scanner.nextLine());
            System.out.println("-------------------------------------------------------------------");

            switch (selection) {
                case 1:
                    orderScreen();
                    break;
                case 0:
                    System.out.println("Have a nice day!");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid input, please try again.");
            }
        }
    }

    //this method is the order screen
    static void orderScreen() {
        int selection;
        Order order = new Order();

        do {
            System.out.println("Please make a selection");
            System.out.println("1) Pizza");
            System.out.println("2) Drink");
            System.out.println("3) Garlic Knots");
            System.out.println("4) Checkout");
            System.out.println("0) Cancel Order");
            System.out.print("\nEnter selection:");
            selection = Integer.parseInt(scanner.nextLine());
            System.out.println("-------------------------------------------------------------------");

            switch (selection) {
                case 1:
                    Pizza.addPizzaToOrder(order);
                    break;
                case 2:
                    Drinks.addDrinkToOrder(order);
                    break;
                case 3:
                    GarlicKnots.addKnotsToOrder(order);
                    break;
                case 4:
                    displayCheckout(order);
                    break;
                case 0:
                    System.out.println("Your order has been cancelled.");
                    return;
                default:
                    System.out.println("Sorry, invalid option.");
            }

        } while (selection != 0 && selection != 4);
    }

    //this method is the checkout screen
    static void displayCheckout(Order order) {
        System.out.println("\n Checkout:");
        System.out.println("-------------------------------------------------------------------");

        System.out.println(order.toString());
        System.out.println("-------------------------------------------------------------------");
        System.out.println("1) Confirm");
        System.out.println("2) Cancel");
        System.out.print("\nEnter selection: ");
        String answer = scanner.nextLine();

        if (answer.equals("1")) {
            try {
                new ReceiptFileManager(order);
                System.out.println("Thank you for ordering from PIZZA-licious!");
            } catch (Exception e) {
                System.out.println("There was an error saving your receipt.");
            }
        } else if (answer.equals("2")) {
            System.out.println("Your order has been cancelled.");
        }
    }
}