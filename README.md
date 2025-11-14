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
```
com.pluralsight  
│── Main.java  
│── Pizza.java  
│── Drinks.java  
│── GarlicKnots.java  
│── Order.java  
│── OrderItems.java  
│── ReceiptFileManager.java  
```
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

This allows the program to calculate totals without knowing whether each item is a pizza, drink, or side. Each subclass defines its own getCost() behavior, making the system flexible and easy to expand.

```java
private double calculateOrderTotal() {
    double orderTotal = 0;
    for (OrderItems item : items) {
        orderTotal += item.getCost(); // Each subclass defines its own version
    }
    return orderTotal;
}
```

### How to Run
1. Open the project in IntelliJ IDEA.  
2. Run `Main.java` located in `com.pluralsight`.  
3. Follow the console prompts to place an order.  
4. After checkout, view your saved receipt in the `/receipts` folder.  

### Screenshots

Homescreen:
<img width="1429" height="825" alt="Screenshot 2025-11-12 at 10 04 27 AM" src="https://github.com/user-attachments/assets/62deacba-65d3-458a-83d4-279fe077db15" />

OrderScreen:
<img width="1429" height="681" alt="Screenshot 2025-11-12 at 10 25 39 AM" src="https://github.com/user-attachments/assets/f2e49701-3147-4481-89df-fefcbef83238" />

CheckOut:
<img width="1440" height="536" alt="Screenshot 2025-11-12 at 10 27 04 AM" src="https://github.com/user-attachments/assets/1d55f92b-9efc-49b0-80bf-f6af5cb781aa" />

ReceiptFileManager:
<img width="1440" height="831" alt="Screenshot 2025-11-12 at 10 27 54 AM" src="https://github.com/user-attachments/assets/5587229f-63af-4d6a-b0b0-e6effd58877d" />

### Technologies Used
- Java 17  
- IntelliJ IDEA  
- Object-Oriented Programming (OOP) principles  
- File I/O using BufferedWriter


### Developer: Najib
- Student / Year Up United
- Advanced Java OOP Capstone Project
