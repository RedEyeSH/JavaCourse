import java.util.HashMap;

public class ShoppingCart {
    private final HashMap<String, Double> fruitList;

    public ShoppingCart() {
        this.fruitList = new HashMap<>();
    }

    public void addItem(String fruitType, double price) {
        fruitList.put(fruitType, price);
    }

    public int getItemCount() {
        return fruitList.size();
    }

    public void removeItem(String fruitType) {
        fruitList.remove(fruitType);
    }

    public double calculateTotal() {
        double total = 0;

        for (double value : fruitList.values()) {
            total += value;
        }
        return total;
    }
}
