import model.Student;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);

        Set<Student> courseA = new HashSet<>();
        Set<Student> courseB = new HashSet<>();
        Set<Student> courseC = new HashSet<>();

        // Course A.
        System.out.print("How many students for Course A? ");
        int count = sc.nextInt();

        for (int i = 0; i < count; i++) {
            courseA.add(new Student(sc.nextInt()));
        }

        // Course B.
        System.out.print("How many students for Course B? ");
        count = sc.nextInt();

        for (int i = 0; i < count; i++) {
            courseB.add(new Student(sc.nextInt()));
        }

        // Course C.
        System.out.print("How many students for Course C? ");
        count = sc.nextInt();

        for (int i = 0; i < count; i++) {
            courseC.add(new Student(sc.nextInt()));
        }

        // Calculate total students.
        Set<Student> courseTotal = new HashSet<>(courseA);
        courseTotal.addAll(courseB);
        courseTotal.addAll(courseC);

        System.out.println("Total Students: " + courseTotal.size());

        sc.close();
    }
}
