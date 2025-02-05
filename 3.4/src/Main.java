import java.io.*;

class Student implements Serializable {
    // Attributes and methods
    private final int id;
    private final String name;
    private final int age;

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Id: " + getId() + ", Name: " + getName() + ", Age: " + getAge();
    }
}

class Course implements Serializable {
    // Attributes and methods
    private final String courseCode;
    private final String courseName;
    private final String instructor;

    public Course(String courseCode, String courseName, String instructor) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.instructor = instructor;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getInstructor() {
        return instructor;
    }

    public String toString() {
        return "Course code: " + getCourseCode() + ", Course name: " + getCourseName() + " , Instructor: " + getInstructor();
    }
}

class Enrollment implements Serializable {
    // Attributes and methods
    private final Student student;
    private final Course course;
    private final String enrollmentDate;

    public Enrollment(Student student, Course course, String enrollmentDate) {
        this.student = student;
        this.course = course;
        this.enrollmentDate = enrollmentDate;
    }

    public Student getStudent() {
        return student;
    }

    public Course getCourse() {
        return course;
    }

    public String getEnrollmentDate() {
        return enrollmentDate;
    }

    @Override
    public String toString() {
        return "Student - " + getStudent() + "\n" + "Course - " + getCourse() + "\n" + "Enrollment date: " + getEnrollmentDate();
    }
}

public class Main {
    private static final String FILE = "enrollments.ser";

    public static void main(String[] args) {
        // Create instances of Student, Course, and Enrollment
        Student student1 = new Student(1, "Than Ngoc", 20);
        Course course1 = new Course("1", "Course1", "Instructor 1");
        Enrollment enrollment = new Enrollment(student1, course1, "2024-02-05");

        // Serialize and save the Enrollment instance
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE))) {
            oos.writeObject(enrollment);
            System.out.println("Enrollment serialized successfully.");
        } catch (IOException e) {
            System.err.println("Error during serialization: " + e.getMessage());
        }

        // Deserialize and print the Enrollment instance
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE))) {
            Enrollment deserializedEnrollment = (Enrollment) ois.readObject();
            System.out.println("Deserialized Enrollment Details:\n" + deserializedEnrollment);
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error during deserialization: " + e.getMessage());
        }
    }
}