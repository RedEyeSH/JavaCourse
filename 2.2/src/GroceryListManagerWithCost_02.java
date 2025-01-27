// 2.2 - Task 02
import java.util.HashMap;

public class GroceryListManagerWithCost_02 {
    private final HashMap<String, Double> groceryList = new HashMap();

    public void addItem(String item, double cost) {
        if (groceryList.containsKey(item)) {
            System.out.println(item + " is already in grocery list!");
        } else {
            System.out.println("Adding " + '"' + item + '"' + " with cost (" + cost + ") to the list.");
            groceryList.put(item, cost);
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
            for (String item : groceryList.keySet()) {
                System.out.println(item + " - " + groceryList.get(item));
            }
        }
    }

    public void checkItem(String item) {
        System.out.println("\nIs " + '"' + item + '"' + " in the grocery list? " + groceryList.containsKey(item));
    }

    public void calculateTotalCost() {
        double totalCost = 0;
        for (double cost : groceryList.values()) {
            totalCost += cost;
        }
        System.out.printf("\nTotal cost: %.2f", totalCost);
    }

    public static void main(String[] args) {
        GroceryListManagerWithCost_02 shoppingList = new GroceryListManagerWithCost_02();

        shoppingList.addItem("Apples", 0.79);
        shoppingList.addItem("Milk", 0.99);
        shoppingList.addItem("Bread", 1.89);

        System.out.println("\nGrocery List:");
        shoppingList.displayList();
        shoppingList.calculateTotalCost();

        shoppingList.checkItem("Milk");
        shoppingList.removeItem("Milk");

        System.out.println("Updated Grocery list:");
        shoppingList.displayList();
        shoppingList.calculateTotalCost();
    }
}
