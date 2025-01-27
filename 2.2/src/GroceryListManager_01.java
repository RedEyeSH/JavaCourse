// 2.2 - Task 01
import java.util.ArrayList;

public class GroceryListManager_01 {
    private final ArrayList<String> groceryList = new ArrayList<>();

    public void addItem(String item) {
        if (groceryList.contains(item)) {
            System.out.println(item + " is already in grocery list!");
        } else {
            System.out.println("Adding " + '"' + item + '"' + " to the list.");
            groceryList.add(item);
        }
    }

    public void removeItem(String item) {
        if (groceryList.contains(item)) {
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
            for (int i = 0; i < groceryList.size(); i++) {
                System.out.println(i + 1 + ". " + groceryList.get(i));
            }
        }
    }

    public void checkItem(String item) {
        System.out.println("\nIs " + '"' + item + '"' + " in the grocery list? " + groceryList.contains(item));
    }

    public static void main(String[] args) {
        GroceryListManager_01 shoppingList = new GroceryListManager_01();

        shoppingList.addItem("Apples");
        shoppingList.addItem("Milk");
        shoppingList.addItem("Bread");

        System.out.println("\nGrocery List:");
        shoppingList.displayList();

        shoppingList.checkItem("Milk");

        shoppingList.removeItem("Milk");

        System.out.println("Updated Grocery list:");
        shoppingList.displayList();
    }
}
