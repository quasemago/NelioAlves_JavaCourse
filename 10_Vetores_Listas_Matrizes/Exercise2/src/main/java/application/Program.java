package application;

import models.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
        public static void main(String[] args) {
                Locale.setDefault(Locale.US);
                final Scanner sc = new Scanner(System.in);

                System.out.print("How many employees will be registered: ");
                int n = sc.nextInt();

                List<Employee> employees = new ArrayList<>();

                for (int i = 0; i < n; i++) {
                        System.out.println("Employee #" + (i + 1) + ":");

                        // Check if id is already taken.
                        System.out.print("ID: ");
                        int id = sc.nextInt();

                        while (isAlreadyRegistered(employees, id)) {
                                System.out.print("Id already registered. Try again: ");
                                id = sc.nextInt();
                        }

                        System.out.print("Name: ");
                        sc.nextLine();
                        String name = sc.nextLine();

                        System.out.print("Salary: ");
                        double salary = sc.nextDouble();

                        employees.add(new Employee(id, name, salary));
                }

                System.out.print("\nEnter the employee id that will have salary increase: ");
                int id = sc.nextInt();

                Employee employee = findById(employees, id);
                if (employee == null) {
                        System.out.println("This id does not exist!");
                        System.exit(1);
                } else {
                        System.out.print("Enter the percentage: ");
                        double percentage = sc.nextDouble();
                        employee.increaseSalary(percentage);
                }

                System.out.println();
                System.out.println("List of employees:");
                for (Employee e : employees) {
                        System.out.println(e);
                }

                sc.close();
        }

        public static boolean isAlreadyRegistered(List<Employee> employees, int id) {
                return employees.stream().anyMatch(x -> x.getId() == id);
        }
        public static Employee findById(List<Employee> employees, int id) {
                return employees.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
        }
}
