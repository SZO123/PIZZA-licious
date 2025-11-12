package com.pluralsight;

import java.util.ArrayList;
import static com.pluralsight.Main.scanner;

//This class represents a pizza item in an order, including size, crust, toppings, and stuffed crust option.
public class Pizza extends OrderItems {

    private String pizzaSize; //8", 12", 16"
    private String crustType; //Thin, Regular, Thick, Cauliflower
    private boolean stuffedCrust; //true or false
    private ArrayList<String> sauces; //sauce list
    private ArrayList<String> meats; //premium toppings
    private ArrayList<String> cheeses; //premium toppings
    private ArrayList<String> regularToppings; //included toppings
    private double basePrice; //base price depending on size

    //constructor
    public Pizza(String pizzaSize) {
        this.pizzaSize = pizzaSize;
        this.sauces = new ArrayList<>();
        this.meats = new ArrayList<>();
        this.cheeses = new ArrayList<>();
        this.regularToppings = new ArrayList<>();
        setBasePrice(pizzaSize);
    }

    //set base price depending on pizza size
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

    //add toppings to pizza
    public void addSauce(String sauce) {
        sauces.add(sauce);
    }

    public void addMeat(String meat) {
        meats.add(meat);
    }

    public void addCheese(String cheese) {
        cheeses.add(cheese);
    }

    public void addRegularTopping(String topping) {
        regularToppings.add(topping);
    }

    //prompt user to build and add pizza to order
    static void addPizzaToOrder(Order order) {

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

        //crust type
        System.out.println("Select crust type:");
        for (int i = 0; i < MenuItems.crustTypes.length; i++) {
            System.out.println(i + 1 + ") " + MenuItems.crustTypes[i]);
        }
        System.out.print("\nEnter selection: ");
        int crustSelection = Integer.parseInt(scanner.nextLine());
        pizza.crustType = MenuItems.crustTypes[crustSelection - 1];
        System.out.println("-------------------------------------------------------------------");

        //stuffed crust
        System.out.print("Would you like stuffed crust? (Y or N): ");
        String stuffed = scanner.nextLine();
        pizza.stuffedCrust = stuffed.equalsIgnoreCase("Y");
        System.out.println("-------------------------------------------------------------------");

        //sauce
        System.out.println("Select your sauces (comma separated for multiple):");
        for (int i = 0; i < MenuItems.sauces.length; i++) {
            System.out.println(i + 1 + ") " + MenuItems.sauces[i]);
        }
        System.out.print("\nEnter selection: ");
        String[] sauceSelection = scanner.nextLine().split(",");
        for (String s : sauceSelection) {
            int idx = Integer.parseInt(s.trim()) - 1;
            pizza.addSauce(MenuItems.sauces[idx]);
        }
        System.out.println("-------------------------------------------------------------------");

        //meats
        System.out.println("Select meats (premium, comma separated):");
        for (int i = 0; i < MenuItems.meats.length; i++) {
            System.out.println(i + 1 + ") " + MenuItems.meats[i]);
        }
        System.out.print("\nEnter selection: ");
        String[] meatSelection = scanner.nextLine().split(",");
        for (String m : meatSelection) {
            int idx = Integer.parseInt(m.trim()) - 1;
            pizza.addMeat(MenuItems.meats[idx]);
        }

        System.out.print("Would you like extra meat for an additional cost? (Y or N): ");
        String extraMeat = scanner.nextLine();
        if (extraMeat.equalsIgnoreCase("Y")) {
            pizza.addExtraMeat();
        }
        System.out.println("-------------------------------------------------------------------");

        //cheeses
        System.out.println("Select cheeses (premium, comma separated):");
        for (int i = 0; i < MenuItems.cheeses.length; i++) {
            System.out.println(i + 1 + ") " + MenuItems.cheeses[i]);
        }
        System.out.print("\nEnter selection: ");
        String[] cheeseSelection = scanner.nextLine().split(",");
        for (String c : cheeseSelection) {
            int idx = Integer.parseInt(c.trim()) - 1;
            pizza.addCheese(MenuItems.cheeses[idx]);
        }

        System.out.print("Would you like extra cheese for an additional cost? (Y or N): ");
        String extraCheese = scanner.nextLine();
        if (extraCheese.equalsIgnoreCase("Y")) {
            pizza.addExtraCheese();
        }
        System.out.println("-------------------------------------------------------------------");

        //regular toppings
        System.out.println("Select regular toppings (comma separated):");
        for (int i = 0; i < MenuItems.regularToppings.length; i++) {
            System.out.println(i + 1 + ") " + MenuItems.regularToppings[i]);
        }
        System.out.print("\nEnter selection: ");
        String[] toppingSelection = scanner.nextLine().split(",");
        for (String t : toppingSelection) {
            int idx = Integer.parseInt(t.trim()) - 1;
            pizza.addRegularTopping(MenuItems.regularToppings[idx]);
        }

        order.addItemToOrder(pizza);
        System.out.println("Pizza added to your order!");
        System.out.println("-------------------------------------------------------------------");
    }

    //extra topping cost logic
    private void addExtraMeat() {
        switch (pizzaSize) {
            case "8" -> basePrice += 0.50;
            case "12" -> basePrice += 1.00;
            case "16" -> basePrice += 1.50;
        }
    }

    private void addExtraCheese() {
        switch (pizzaSize) {
            case "8" -> basePrice += 0.30;
            case "12" -> basePrice += 0.60;
            case "16" -> basePrice += 0.90;
        }
    }

    //calculate total pizza cost
    @Override
    public double getCost() {
        double total = basePrice;

        switch (pizzaSize) {
            case "8" -> total += 1.00 + 0.75;
            case "12" -> total += 2.00 + 1.50;
            case "16" -> total += 3.00 + 2.25;
        }

        return total;
    }

    //return formatted pizza details
    @Override
    public String toString() {
        return "\nPizza:" +
                "\nSize: " + pizzaSize + "\"" +
                "\nCrust: " + crustType +
                "\nStuffed Crust: " + stuffedCrust +
                "\nSauces: " + sauces +
                "\nMeats: " + meats +
                "\nCheeses: " + cheeses +
                "\nToppings: " + regularToppings +
                "\nPrice: $" + String.format("%.2f", getCost());
    }
}