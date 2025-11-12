package com.pluralsight;

import java.util.Scanner;

//This class manages user interaction for selecting pizza toppings and sauces.
public class Topping extends OrderItems {

    static Scanner scanner = new Scanner(System.in);

    //display sauces
    static void displaySauces(Pizza pizza) {
        System.out.println("Select sauces (comma separated):");
        for (int i = 0; i < MenuItems.sauces.length; i++) {
            System.out.println(i + 1 + ") " + MenuItems.sauces[i]);
        }
        System.out.print("\nEnter selection: ");
        String[] selection = scanner.nextLine().split(",");
        for (String s : selection) {
            int index = Integer.parseInt(s.trim()) - 1;
            if (index >= 0 && index < MenuItems.sauces.length) {
                pizza.addSauce(MenuItems.sauces[index]);
                System.out.println("Added sauce: " + MenuItems.sauces[index]);
            }
        }
    }

    //display meats
    static void displayMeats(Pizza pizza) {
        System.out.println("Select meats (comma separated):");
        for (int i = 0; i < MenuItems.meats.length; i++) {
            System.out.println(i + 1 + ") " + MenuItems.meats[i]);
        }
        System.out.print("\nEnter selection: ");
        String[] selection = scanner.nextLine().split(",");
        for (String s : selection) {
            int index = Integer.parseInt(s.trim()) - 1;
            if (index >= 0 && index < MenuItems.meats.length) {
                pizza.addMeat(MenuItems.meats[index]);
                System.out.println("Added meat: " + MenuItems.meats[index]);
            }
        }
    }

    //display cheeses
    static void displayCheeses(Pizza pizza) {
        System.out.println("Select cheeses (comma separated):");
        for (int i = 0; i < MenuItems.cheeses.length; i++) {
            System.out.println(i + 1 + ") " + MenuItems.cheeses[i]);
        }
        System.out.print("\nEnter selection: ");
        String[] selection = scanner.nextLine().split(",");
        for (String s : selection) {
            int index = Integer.parseInt(s.trim()) - 1;
            if (index >= 0 && index < MenuItems.cheeses.length) {
                pizza.addCheese(MenuItems.cheeses[index]);
                System.out.println("Added cheese: " + MenuItems.cheeses[index]);
            }
        }
    }

    //display regular toppings
    static void displayRegularToppings(Pizza pizza) {
        System.out.println("Select regular toppings (comma separated):");
        for (int i = 0; i < MenuItems.regularToppings.length; i++) {
            System.out.println(i + 1 + ") " + MenuItems.regularToppings[i]);
        }
        System.out.print("\nEnter selection: ");
        String[] selection = scanner.nextLine().split(",");
        for (String s : selection) {
            int index = Integer.parseInt(s.trim()) - 1;
            if (index >= 0 && index < MenuItems.regularToppings.length) {
                pizza.addRegularTopping(MenuItems.regularToppings[index]);
                System.out.println("Added topping: " + MenuItems.regularToppings[index]);
            }
        }
    }

    @Override
    public double getCost() {
        return 0; //Topping class does not have an individual cost
    }

    @Override
    public String toString() {
        return "Toppings: (handled in Pizza)";
    }
}