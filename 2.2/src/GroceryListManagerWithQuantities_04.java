// 2.2 - Task 03
import java.util.HashMap;

public class GroceryListManagerWithQuantities_04 {
    private final HashMap<String, Item_04> groceryList = new HashMap();

    public void addItem(String item, double cost, String category, int quantity) {
        if (groceryList.containsKey(item)) {
            System.out.println(item + " is already in grocery list!");
        } else {
            System.out.println("\nAdding " + '"' + item + '"' + " with cost (" + cost + "), category (" + category + "), and quantity (" + quantity + ") to the list.");
            groceryList.put(item, new Item_04(item, cost, category, quantity));
        }
    }

    public void removeItem(String item) {
        if (groceryList.containsKey(item)) {
            System.out.println("\nRemoving " + '"' + item + '"' + " from the list...\n");
            groceryList.remove(item);
        } else {
            System.out.println("\n" + item + " doesn't exist in the list!");
        }
    }

    public void displayList() {
        if (groceryList.isEmpty()) {
            System.out.println("The grocery list is empty.\n");
        } else {
            for (Item_04 item : groceryList.values()) {
                System.out.println(item.getItem() + " - " + item.getCost() + " - " + item.getCategory() + " - " + "Quantity: " + item.getQuantity());
            }
        }
    }

    public void checkItem(String item) {
        System.out.println("\nIs " + '"' + item + '"' + " in the grocery list? " + groceryList.containsKey(item));
    }

    public void calculateTotalCost() {
        double totalCost = 0;
        for (Item_04 cost : groceryList.values()) {
            totalCost += cost.getCost() * cost.getQuantity();
        }
        System.out.printf("\nTotal cost: %.2f\n", totalCost);
    }

    public void displayByCategory(String category) {
        boolean isFound = false;

        System.out.println("\nItems in the " + '"' + category + '"' + " category:");

        for (Item_04 item : groceryList.values()) {
            if (item.getCategory().equals(category)) {
                System.out.println(item.getItem() + " - " + item.getCost());
                isFound = true;
            }
        }

        if (!isFound) {
            System.out.println("No items found in the category " + category + ".");
        }
    }

    public void updateQuantity(String item, int newQuantity) {
        if (groceryList.containsKey(item)) {
            Item_04 existingItem = groceryList.get(item);
            existingItem.setQuantity(newQuantity);
            System.out.println("\nUpdating quantity of " + '"' + item + '"' + " to " + newQuantity + "...");
        } else {
            System.out.println(item + "doesn't exist in the list!\n");
        }
    }

    public void displayAvailableItems() {
        boolean isFound = false;

        System.out.println("\nAvailable items (positive quantity):");
        for (Item_04 item : groceryList.values()) {
            if (item.getQuantity() > 0) {
                System.out.println(item.getItem() + " - " + item.getCost() + " - " + item.getCategory() + " - " + "Quantity: " + item.getQuantity());
                isFound = true;
            }
        }

        if (!isFound) {
            System.out.println("No items available in the list with a positive quantity.\n");
        }
    }

    public static void main(String[] args) {
        GroceryListManagerWithQuantities_04 shoppingList = new GroceryListManagerWithQuantities_04();

        shoppingList.addItem("Apples", 0.79, "Fruits", 2);
        shoppingList.addItem("Milk", 0.99, "Dairy", 3);
        shoppingList.addItem("Bread", 1.89, "Bakery", 1);

        System.out.println("\nGrocery List:");
        shoppingList.displayList();
        shoppingList.calculateTotalCost();

        shoppingList.checkItem("Milk");
        shoppingList.removeItem("Milk");

        System.out.println("Updated Grocery list:");
        shoppingList.displayList();
        shoppingList.calculateTotalCost();

        shoppingList.displayByCategory("Bakery");

        shoppingList.updateQuantity("Apples", 3);
        shoppingList.displayList();

        shoppingList.displayAvailableItems();
    }
}

class Item_04 {
    private final String item;
    private final double cost;
    private final String category;
    private int quantity;

    public Item_04(String item, double cost, String category, int quantity) {
        this.item = item;
        this.cost = cost;
        this.category = category;
        this.quantity = quantity;
    }

    public String getItem() {
        return item;
    }

    public double getCost() {
        return cost;
    }

    public String getCategory() {
        return category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}