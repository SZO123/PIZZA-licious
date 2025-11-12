## PIZZA-licious

### Project Description
PIZZA-licious is a Java console application that lets users build and order custom pizzas.  
Customers select their pizza size, crust, toppings, cheese, and sauce, then add drinks and garlic knots before checking out.  
Once the order is complete, the app creates a timestamped receipt and saves it in a `receipts/` folder.

This project demonstrates advanced Object-Oriented Programming principles including abstraction, inheritance, and polymorphism.

---

### Application Features
- **Interactive Menu System**
  - Start a new order or exit.  
  - Add pizza, drinks, or garlic knots.  
  - Checkout or cancel the order.  
- **Pizza Builder**
  - Choose size (Small, Medium, Large).  
  - Choose crust type (Thin, Hand-Tossed, Deep Dish).  
  - Add multiple toppings, cheese, and sauces.  
  - Request extra cheese or meat for an additional cost.  
- **Drinks and Sides**
  - Add drinks with selectable flavors and sizes.  
  - Add garlic knots as a side item.  
- **Checkout and Receipt**
  - Displays complete order summary with formatted prices.  
  - Saves a receipt named by date and time (e.g., `20251112-092213.txt`).

---

### Project Structure
com.pluralsight
│── Main.java
│── Pizza.java
│── Drinks.java
│── GarlicKnots.java
│── Order.java
│── OrderItems.java
│── ReceiptFileManager.java

---

### OOP Concepts Demonstrated
- **Abstraction**  
  `OrderItems` is an abstract class that defines a `getCost()` method used by all order items.  
- **Inheritance**  
  `Pizza`, `Drinks`, and `GarlicKnots` extend `OrderItems`, inheriting its structure.  
- **Polymorphism**  
  The `Order` class uses a list of `OrderItems`, allowing it to treat all items (pizza, drinks, sides) the same way.  
- **Encapsulation**  
  Each model class has private fields with getter and setter methods for controlled access.

---

### Interesting Code Example
This method in `Order.java` demonstrates **polymorphism** clearly:

```java
private double calculateOrderTotal() {
    double orderTotal = 0;
    for (OrderItems item : items) {
        orderTotal += item.getCost(); // Each subclass defines its own version
    }
    return orderTotal;
}

### Screenshots

Homescreen: <img width="1429" height="825" alt="Screenshot 2025-11-12 at 10 04 27 AM" src="https://github.com/user-attachments/assets/e57109ea-9a06-47fa-9e0b-7eb739f7ba0e" />
