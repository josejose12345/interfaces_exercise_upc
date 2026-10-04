import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

class Person implements Comparable<Person> {
    String name;
    String surname;

    Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String toString() {
        return name + " " + surname;
    }

    public int compareTo(Person other) {
        int result = surname.compareTo(other.surname);
        if (result == 0) {
            result = name.compareTo(other.name);
        }
        return result;
    }
}

class Rectangle implements Comparable<Rectangle> {
    double width;
    double height;

    Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    double area() {
        return width * height;
    }

    public String toString() {
        return width + "x" + height + "=" + area();
    }

    public int compareTo(Rectangle other) {
        if (area() < other.area()) return -1;
        if (area() > other.area()) return 1;
        return 0;
    }
}

public class Main {

    static Person[] persons() {
        return new Person[] { new Person("Juan", "Perez"), new Person("Ana", "Lopez"),
                new Person("Luis", "Perez"), new Person("Maria", "Garcia"), new Person("Carlos", "Lopez") };
    }

    static Rectangle[] rectangles() {
        return new Rectangle[] { new Rectangle(3, 4), new Rectangle(1, 2), new Rectangle(5, 5),
                new Rectangle(2, 2), new Rectangle(10, 1) };
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option = -1;
        while (option != 0) {
            System.out.println("\n1. Sort persons\n2. Sort rectangles\n0. Exit");
            option = scanner.nextInt();

            Person[] p = persons();
            Rectangle[] r = rectangles();
            if (option == 1) {
                Collections.sort(Arrays.asList(p));
                System.out.println(Arrays.toString(p));
            } else if (option == 2) {
                Collections.sort(Arrays.asList(r));
                System.out.println(Arrays.toString(r));
            }
        }
    }
}