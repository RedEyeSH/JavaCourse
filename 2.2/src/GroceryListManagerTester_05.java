// 2.2 - Task 05

public class GroceryListManagerTester_05 {
    public static void main(String[] args) {
        GroceryListManagerWithQuantities_04 shoppingList = new GroceryListManagerWithQuantities_04();

        shoppingList.addItem("Apples", 0.79, "Fruits", 2);
        shoppingList.addItem("Milk", 0.99, "Dairy", 3);
        shoppingList.addItem("Bread", 1.89, "Bakery", 1);

        System.out.println("Grocery List:");
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

        // Testing the program
        shoppingList.addItem("Eggs", 3.59, "Dairy", 6);

        System.out.println("\nUpdated Grocery list:");
        shoppingList.displayList();

        shoppingList.removeItem("Cookie");
        shoppingList.checkItem("Pear");

        shoppingList.displayAvailableItems();
        shoppingList.calculateTotalCost();

    }
}
