import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Person {
    private String name;
    private int age;
    private String city;

    // Constructor
    public Person(String name, int age, String city) {
        this.name = name;
        this.age = age;
        this.city = city;
    }

    public int getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return name + " (" + age + ") - " + city;
    }

    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();

        people.add(new Person("Quang", 20, "Vantaa"));
        people.add(new Person("Erik", 20, "Helsinki"));
        people.add(new Person("Shane", 19, "Vantaa"));
        people.add(new Person("Stranger", 21, "New York"));

        people.sort(Comparator.comparingInt(Person::getAge));

        System.out.println("Sorted by Age:");
        people.forEach(System.out::println);

        people.removeIf(person -> !person.getCity().equals("New York"));

        System.out.println("\nFiltered by City (New York):");
        people.forEach(System.out::println);
    }
}
