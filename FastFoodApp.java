import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FastFoodApp {
    private static Map<String, Double> menu = new HashMap<>();

    static {
        // Initialize menu items
        menu.put("Burger", 5.99);
        menu.put("Fries", 2.49);
        menu.put("Soda", 1.99);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Display menu
        displayMenu();

        // Start taking orders
        boolean continueOrdering = true;
        while (continueOrdering) {
            System.out.println("Enter item name (or type 'done' to finish ordering):");
            String item = scanner.nextLine().trim();

            if (item.equalsIgnoreCase("done")) {
                continueOrdering = false;
            } else {
                if (menu.containsKey(item)) {
                    System.out.println("How many " + item + "s?");
                    int quantity = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    double totalPrice = menu.get(item) * quantity;
                    System.out.println("Added " + quantity + " " + item + "(s) to your order. Total price: $" + totalPrice);
                } else {
                    System.out.println("Sorry, we don't have " + item + " on the menu.");
                }
            }
        }

        System.out.println("Thank you for your order!");
        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("Menu:");
        for (Map.Entry<String, Double> item : menu.entrySet()) {
            System.out.println(item.getKey() + ": $" + item.getValue());
        }
        System.out.println();
    }
}
