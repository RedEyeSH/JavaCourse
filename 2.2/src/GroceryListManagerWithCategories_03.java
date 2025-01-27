// 2.2 - Task 03
import java.util.HashMap;

public class GroceryListManagerWithCategories_03 {
    private final HashMap<String, Item> groceryList = new HashMap();

    public void addItem(String item, double cost, String category) {
        if (groceryList.containsKey(item)) {
            System.out.println(item + " is already in grocery list!");
        } else {
            System.out.println("Adding " + '"' + item + '"' + " with cost (" + cost + ") and category (" + category + ") to the list.");
            groceryList.put(item, new Item(item, cost, category));
        }
    }

    public void removeItem(String item) {
        if (groceryList.containsKey(item)) {
            System.out.println("\nRemoving " + '"' + item + '"' + " from the list...\n");
            groceryList.remove(item);
        } else {
            System.out.println(item + " doesn't exist in the list!\n");
        }
    }

    public void displayList() {
        if (groceryList.isEmpty()) {
            System.out.println("The grocery list is empty.\n");
        } else {
            for (Item item : groceryList.values()) {
                System.out.println(item.getItem() + " - " + item.getCost() + " - " + item.getCategory());
            }
        }
    }

    public void checkItem(String item) {
        System.out.println("\nIs " + '"' + item + '"' + " in the grocery list? " + groceryList.containsKey(item));
    }

    public void calculateTotalCost() {
        double totalCost = 0;
        for (Item cost : groceryList.values()) {
            totalCost += cost.getCost();
        }
        System.out.printf("\nTotal cost: %.2f\n", totalCost);
    }

    public void displayByCategory(String category) {
        boolean isFound = false;

        System.out.println("\nItems in the " + '"' + category + '"' + " category:");

        for (Item item : groceryList.values()) {
            if (item.getCategory().equals(category)) {
                System.out.println(item.getItem() + " - " + item.getCost());
                isFound = true;
            }
        }

        if (!isFound) {
            System.out.println("No items found in the category " + category + ".");
        }
    }

    public static void main(String[] args) {
        GroceryListManagerWithCategories_03 shoppingList = new GroceryListManagerWithCategories_03();

        shoppingList.addItem("Apples", 0.79, "Fruits");
        shoppingList.addItem("Milk", 0.99, "Dairy");
        shoppingList.addItem("Bread", 1.89, "Bakery");

        System.out.println("\nGrocery List:");
        shoppingList.displayList();
        shoppingList.calculateTotalCost();

        shoppingList.checkItem("Milk");
        shoppingList.removeItem("Milk");

        System.out.println("Updated Grocery list:");
        shoppingList.displayList();
        shoppingList.calculateTotalCost();

        shoppingList.displayByCategory("Bakery");
    }
}

class Item {
    private final String item;
    private final double cost;
    private final String category;

    public Item(String item, double cost, String category) {
        this.item = item;
        this.cost = cost;
        this.category = category;
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
}