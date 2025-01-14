
class Student {
    String name;
    int rollNumber;
    String course;
    int age;

    Student(String name, int rollNumber, String course, int age) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.course = course;
        this.age = age;
    }

    void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Course: " + course);
        System.out.println("Age: " + age);
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student("Aarav", 101, "Computer Science", 20);
        Student student2 = new Student("Ishita", 102, "Mechanical Engineering", 21);
        Student student3 = new Student("Rahul", 103, "Electrical Engineering", 22);

        System.out.println("Student 1 Details:");
        student1.displayDetails();

        System.out.println("Student 2 Details:");
        student2.displayDetails();

        System.out.println("Student 3 Details:");
        student3.displayDetails();
    }
}
