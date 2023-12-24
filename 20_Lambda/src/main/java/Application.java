import model.Employee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Application {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        final Scanner sc = new Scanner(System.in);

        System.out.print("Enter full CSV file path: ");
        final String csvPath = sc.next();

        try (BufferedReader bf = new BufferedReader(new FileReader(csvPath))) {
            final List<Employee> employeeList = new ArrayList<>();

            // Read data.
            String line = bf.readLine();
            while (line != null) {
                final String[] parts = line.split(",");

                employeeList.add(new Employee(parts[0], parts[1], Double.parseDouble(parts[2])));
                line = bf.readLine();
            }

            // Filter data.
            System.out.print("Enter salary: ");
            final Double salaryTarget = sc.nextDouble();

            System.out.println("\nEmail of people whose salary is more than " + String.format("%.2f", salaryTarget) + ":");
            employeeList.stream()
                    .filter(e -> e.getSalary() > salaryTarget)
                    .map(Employee::getEmail)
                    .sorted((email1, email2) -> email1.toUpperCase().compareTo(email2.toUpperCase()))
                    .forEach(System.out::println);

            final Double sumSalary = employeeList.stream()
                    .filter(e -> e.getName().charAt(0) == 'M')
                    .map(Employee::getSalary)
                    .reduce(0.0, (s1, s2) -> s1 + s2);
            System.out.println("\nSum of salary of people whose name starts with 'M': " + String.format("%.2f", sumSalary));
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}
