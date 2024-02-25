# FastFood-App
/* basic functionalities including displaying the menu, adding items to the order, and displaying the order summary:

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Define a class for FoodItem
class FoodItem {
    private String name;
    private double price;

    public FoodItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

// Define a class for Menu which contains a list of FoodItems
class Menu {
    private List<FoodItem> items;

    public Menu() {
        this.items = new ArrayList<>();
    }

    public void addItem(FoodItem item) {
        items.add(item);
    }

    public List<FoodItem> getItems() {
        return items;
    }
}

// Define a class for Order which contains a list of FoodItems
class Order {
    private List<FoodItem> items;

    public Order() {
        this.items = new ArrayList<>();
    }

    public void addItem(FoodItem item) {
        items.add(item);
    }

    public List<FoodItem> getItems() {
        return items;
    }

    public double calculateTotal() {
        double total = 0;
        for (FoodItem item : items) {
            total += item.getPrice();
        }
        return total;
    }
}

// Main class
public class FastFoodApp {
    public static void main(String[] args) {
        // Create a menu
        Menu menu = new Menu();
        menu.addItem(new FoodItem("Burger", 5.99));
        menu.addItem(new FoodItem("Fries", 2.99));
        menu.addItem(new FoodItem("Drink", 1.99));

        // Create an order
        Order order = new Order();

        // Display the menu
        System.out.println("Menu:");
        List<FoodItem> menuItems = menu.getItems();
        for (int i = 0; i < menuItems.size(); i++) {
            System.out.println((i + 1) + ". " + menuItems.get(i).getName() + " - $" + menuItems.get(i).getPrice());
        }

        // Take user input to add items to the order
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter item numbers to add to order (separated by commas):");
        String input = scanner.nextLine();
        String[] itemNumbers = input.split(",");
        for (String itemNumber : itemNumbers) {
            int index = Integer.parseInt(itemNumber.trim()) - 1;
            if (index >= 0 && index < menuItems.size()) {
                order.addItem(menuItems.get(index));
            }
        }

        // Display order summary
        System.out.println("Order Summary:");
        List<FoodItem> orderItems = order.getItems();
        for (FoodItem item : orderItems) {
            System.out.println(item.getName() + " - $" + item.getPrice());
        }
        System.out.println("Total: $" + order.calculateTotal());

        scanner.close();
    }
}

Frontend (HTML + CSS + Bootstrap):
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Fast Food App</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        /* Add custom CSS here */
    </style>
</head>
<body>
    <div class="container">
        <h1>Fast Food App</h1>
        <h2>Menu:</h2>
        <ul id="menu-list" class="list-group">
            <!-- Menu items will be dynamically added here -->
        </ul>
        <h2>Order Summary:</h2>
        <ul id="order-list" class="list-group">
            <!-- Order items will be dynamically added here -->
        </ul>
        <h3>Total: <span id="total"></span></h3>
    </div>
    
    <!-- Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <!-- Custom JS -->
    <script>
        // Define menu items
        const menuItems = [
            { name: "Burger", price: 5.99 },
            { name: "Fries", price: 2.99 },
            { name: "Drink", price: 1.99 }
        ];

        // Function to display menu
        function displayMenu() {
            const menuList = document.getElementById("menu-list");
            menuList.innerHTML = "";
            menuItems.forEach((item, index) => {
                const listItem = document.createElement("li");
                listItem.classList.add("list-group-item");
                listItem.textContent = `${index + 1}. ${item.name} - $${item.price}`;
                menuList.appendChild(listItem);
            });
        }

        // Initialize menu display
        displayMenu();

        // Define order array
        let orderItems = [];

        // Function to display order summary
        function displayOrder() {
            const orderList = document.getElementById("order-list");
            orderList.innerHTML = "";
            let total = 0;
            orderItems.forEach((item, index) => {
                const listItem = document.createElement("li");
                listItem.classList.add("list-group-item");
                listItem.textContent = `${index + 1}. ${item.name} - $${item.price}`;
                orderList.appendChild(listItem);
                total += item.price;
            });
            document.getElementById("total").textContent = "$" + total.toFixed(2);
        }

        // Event listener for menu item clicks
        document.getElementById("menu-list").addEventListener("click", function(event) {
            const index = parseInt(event.target.textContent.split(".")[0]) - 1;
            if (!isNaN(index) && index >= 0 && index < menuItems.length) {
                orderItems.push(menuItems[index]);
                displayOrder();
            }
        });
    </script>
</body>
</html>
C:\Users\inaya\OneDrive\Skrivbord\Fastfood app\Fastfood-app\src\main\java\org\example\FoodItem.java:67:8
java: class FastFoodApp is public, should be declared in a file named FastFoodApp.java
The error message you provided indicates that there's a mismatch between the class name and the file name. In Java, each public class should be declared in its own file with the name matching the class name.

In your case, it seems like you have a class named FastFoodApp but it's not in a file named FastFoodApp.java. Instead, it's probably in a file named something else, perhaps FoodItem.java.

To fix this error, you need to ensure that the FastFoodApp class is in a file named FastFoodApp.java. You can either rename the existing file to match the class name or create a new file named FastFoodApp.java and move the class definition into it.

Once the class is in a file named FastFoodApp.java, the error should be resolved.
