// 1.1 - Task 04

public class Cat_04 {
    private final String name;

    public Cat_04(String name) {
        this.name = name;
    }

    public void meow() {
        System.out.println("The cat named " + name + " says: Meow!");
    }

    public static void main(String[] args) {
        // Create an instance of the Cat class with a name
        Cat_04 cat = new Cat_04("Whiskers");
        Cat_04 rex = new Cat_04("Rex");

        // Call the meow method on the cat instance
        cat.meow();
        cat.meow();
        rex.meow();
        cat.meow();
    }
}
