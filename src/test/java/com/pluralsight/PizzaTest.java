package com.pluralsight;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PizzaTest {

    @Test
    public void testPizzaBasePriceLarge() {
        Pizza pizza = new Pizza("Large");
        double cost = pizza.getCost();

        assertEquals(12.00, cost, 0.01);
    }

    @Test
    public void testPizzaCostChangesWhenCheeseIsAdded() {
        Pizza pizza = new Pizza("Medium");
        pizza.addCheese("Mozzarella");

        double cost = pizza.getCost();
        assertTrue(cost > 0);
    }



}

