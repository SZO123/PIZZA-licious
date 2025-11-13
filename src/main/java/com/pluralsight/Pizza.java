package com.pluralsight;

import java.util.ArrayList;
import static com.pluralsight.Main.scanner;

public class Pizza extends OrderItems {

    // Size of the pizza: 8, 12, or 16
    private String pizzaSize;

    // Crust type: Thin, Hand Tossed, Deep Dish, etc.
    private String crustType;

    // True if the user selected stuffed crust
    private boolean stuffedCrust;

    // Lists for different topping types
    private ArrayList<String> sauces;
    private ArrayList<String> meats;            // premium toppings
    private ArrayList<String> cheeses;          // premium toppings
    private ArrayList<String> regularToppings;  // included toppings

    // Base price depends on size
    private double basePrice;

    // Constructor sets size, creates lists, and sets base price
    public Pizza(String pizzaSize) {
        this.pizzaSize = pizzaSize;
        this.sauces = new ArrayList<>();
        this.meats = new ArrayList<>();
        this.cheeses = new ArrayList<>();
        this.regularToppings = new ArrayList<>();
        setBasePrice(pizzaSize);
    }

    // Set base price based on pizza size
// 8" = 8.50, 12" = 12.00, 16" = 16.50
    private void setBasePrice(String pizzaSize) {
        switch (pizzaSize) {
            case "8":
                basePrice = 8.50;
                break;
            case "12":
                basePrice = 12.00;
                break;
            case "16":
                basePrice = 16.50;
                break;
            default:
                basePrice = 12.00;
                break;
        }
    }

    // Add sauce to the pizza
    public void addSauce(String sauce) {
        sauces.add(sauce);
    }

    // Add premium meat topping
    public void addMeat(String meat) {
        meats.add(meat);
    }

    // Add premium cheese topping
    public void addCheese(String cheese) {
        cheeses.add(cheese);
    }

    // Add regular topping (included in price)
    public void addRegularTopping(String topping) {
        regularToppings.add(topping);
    }

    // Build a pizza by asking the user questions
// Then add the pizza to the order
    static void addPizzaToOrder(Order order) {

        // Ask for size
        System.out.println("Choose pizza size:");
        System.out.println("1) 8\"");
        System.out.println("2) 12\"");
        System.out.println("3) 16\"");
        System.out.print("\nEnter selection: ");
        int sizeSelection = Integer.parseInt(scanner.nextLine());
        System.out.println("-------------------------------------------------------------------");

        String pizzaSize = switch (sizeSelection) {
            case 1 -> "8";
            case 2 -> "12";
            case 3 -> "16";
            default -> "12";
        };

        Pizza pizza = new Pizza(pizzaSize);

        // Ask for crust type
        System.out.println("Select crust type:");
        for (int i = 0; i < MenuItems.crustTypes.length; i++) {
            System.out.println((i + 1) + ") " + MenuItems.crustTypes[i]);
        }
        System.out.print("\nEnter selection: ");
        int crustSelection = Integer.parseInt(scanner.nextLine());
        pizza.crustType = MenuItems.crustTypes[crustSelection - 1];
        System.out.println("-------------------------------------------------------------------");

        // Ask for stuffed crust
        System.out.print("Would you like stuffed crust? (Y or N): ");
        pizza.stuffedCrust = scanner.nextLine().equalsIgnoreCase("Y");
        System.out.println("-------------------------------------------------------------------");

        // Ask for sauces
        System.out.println("Select your sauces (comma separated):");
        for (int i = 0; i < MenuItems.sauces.length; i++) {
            System.out.println((i + 1) + ") " + MenuItems.sauces[i]);
        }
        System.out.print("\nEnter selection: ");
        String[] sauceSelection = scanner.nextLine().split(",");
        for (String s : sauceSelection) {
            int idx = Integer.parseInt(s.trim()) - 1;
            pizza.addSauce(MenuItems.sauces[idx]);
        }
        System.out.println("-------------------------------------------------------------------");

        // Ask for meats (premium)
        System.out.println("Select meats (comma separated):");
        for (int i = 0; i < MenuItems.meats.length; i++) {
            System.out.println((i + 1) + ") " + MenuItems.meats[i]);
        }
        System.out.print("\nEnter selection: ");
        String[] meatSelection = scanner.nextLine().split(",");
        for (String m : meatSelection) {
            int idx = Integer.parseInt(m.trim()) - 1;
            pizza.addMeat(MenuItems.meats[idx]);
        }

        // Ask for extra meat
        System.out.print("Would you like extra meat? (Y or N): ");
        if (scanner.nextLine().equalsIgnoreCase("Y")) {
            pizza.addExtraMeat();
        }
        System.out.println("-------------------------------------------------------------------");

        // Ask for cheeses (premium)
        System.out.println("Select cheeses (comma separated):");
        for (int i = 0; i < MenuItems.cheeses.length; i++) {
            System.out.println((i + 1) + ") " + MenuItems.cheeses[i]);
        }
        System.out.print("\nEnter selection: ");
        String[] cheeseSelection = scanner.nextLine().split(",");
        for (String c : cheeseSelection) {
            int idx = Integer.parseInt(c.trim()) - 1;
            pizza.addCheese(MenuItems.cheeses[idx]);
        }

        // Ask for extra cheese
        System.out.print("Would you like extra cheese? (Y or N): ");
        if (scanner.nextLine().equalsIgnoreCase("Y")) {
            pizza.addExtraCheese();
        }
        System.out.println("-------------------------------------------------------------------");

        // Ask for regular toppings (included)
        System.out.println("Select regular toppings (comma separated):");
        for (int i = 0; i < MenuItems.regularToppings.length; i++) {
            System.out.println((i + 1) + ") " + MenuItems.regularToppings[i]);
        }
        System.out.print("\nEnter selection: ");
        String[] toppingSelection = scanner.nextLine().split(",");
        for (String t : toppingSelection) {
            int idx = Integer.parseInt(t.trim()) - 1;
            pizza.addRegularTopping(MenuItems.regularToppings[idx]);
        }

        // Add pizza to order
        order.addItemToOrder(pizza);
        System.out.println("Pizza added to order!");
        System.out.println("-------------------------------------------------------------------");
    }

    // Mark that the user wants extra meat
// Extra cost is added in basePrice
    private void addExtraMeat() {
        switch (pizzaSize) {
            case "8":
                basePrice += 0.50;
                break;
            case "12":
                basePrice += 1.00;
                break;
            case "16":
                basePrice += 1.50;
                break;
        }
    }

    // Mark that the user wants extra cheese
// Extra cost is added in basePrice
    private void addExtraCheese() {
        switch (pizzaSize) {
            case "8":
                basePrice += 0.30;
                break;
            case "12":
                basePrice += 0.60;
                break;
            case "16":
                basePrice += 0.90;
                break;
        }
    }

    // Calculate the total price of the pizza
// Uses base price, premium toppings, extra toppings, and stuffed crust
    @Override
    public double getCost() {

        // Set premium topping prices based on size
        double meatCost;
        double cheeseCost;

        switch (pizzaSize) {
            case "8":
                meatCost = 1.00;
                cheeseCost = 0.75;
                break;
            case "12":
                meatCost = 2.00;
                cheeseCost = 1.50;
                break;
            case "16":
                meatCost = 3.00;
                cheeseCost = 2.25;
                break;
            default:
                meatCost = 0.00;
                cheeseCost = 0.00;
                break;
        }

        // Ignore "None" as a topping so it does not add cost
        long realMeats = meats.stream()
                .filter(m -> !m.equalsIgnoreCase("None"))
                .count();

        long realCheeses = cheeses.stream()
                .filter(c -> !c.equalsIgnoreCase("None"))
                .count();

        // Start with base price
        double total = basePrice;

        // Add cost for premium meats and cheeses
        total += realMeats * meatCost;
        total += realCheeses * cheeseCost;

        // Add cost for stuffed crust if selected
        if (stuffedCrust) {
            total += 2.00;
        }

        return total;
    }

    // Format pizza details for order summary and receipt
    @Override
    public String toString() {
        return "\nPizza:" +
                "\nSize: " + pizzaSize + "\"" +
                "\nCrust: " + crustType +
                "\nStuffed Crust: " + stuffedCrust +
                "\nSauces: " + sauces +
                "\nMeats: " + meats +
                "\nCheeses: " + cheeses +
                "\nRegular Toppings: " + regularToppings +
                "\nPrice: $" + String.format("%.2f", getCost());
    }}