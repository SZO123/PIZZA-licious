package com.pluralsight;

//This class holds all menu item options for pizzas, toppings, and sides.
public class MenuItems {

    //Pizza sizes available
    public static final String[] pizzaSizes = {"8\"", "12\"", "16\""};

    //Crust types available
    public static final String[] crustTypes = {"Thin", "Regular", "Thick", "Cauliflower"};

    //Sauce options
    public static final String[] sauces = {"Marinara", "Alfredo", "Pesto", "BBQ", "Buffalo", "Olive Oil", "None"};

    //Meat toppings (premium)
    public static final String[] meats = {"Pepperoni", "Sausage", "Ham", "Bacon", "Chicken", "Meatball", "None"};

    //Cheese toppings (premium)
    public static final String[] cheeses = {"Mozzarella", "Parmesan", "Ricotta", "Goat Cheese", "Buffalo", "None"};

    //Regular toppings (included)
    public static final String[] regularToppings = {"Onions", "Mushrooms", "Bell Peppers", "Olives", "Tomatoes",
            "Spinach", "Basil", "Pineapple", "Anchovies", "None"};

    //Drink options
    public static final String[] drinks = {"Pepsi", "Coca-Cola", "Sprite", "Ginger Ale", "Lemonade", "Fruit Punch", "None"};
}