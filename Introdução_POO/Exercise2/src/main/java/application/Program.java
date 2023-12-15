package application;

/*
Fazer um programa para ler os dados de um funcionário (nome, salário bruto e imposto). Em
seguida, mostrar os dados do funcionário (nome e salário líquido). Em seguida, aumentar o
salário do funcionário com base em uma porcentagem dada (somente o salário bruto é
afetado pela porcentagem) e mostrar novamente os dados do funcionário.

Use a classe projetada abaixo:
Employee
- Name: string
- GrossSalary: double
- Tax: double
+ NetSalary(): double
+ IncreaseSalary(percentage: double): void
 */

import entities.Employee;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        final Scanner sc = new Scanner(System.in);

        System.out.println("Informe o Nome do funcionário");
        String name = sc.nextLine();

        System.out.println("Informe o Salário Bruto do funcionário");
        double grossSalary = sc.nextDouble();

        System.out.println("Informe o imposto");
        double tax = sc.nextDouble();

        Employee employee = new Employee(name, grossSalary, tax);
        System.out.printf("Employee: %s, $ %.2f%n%n", employee.getName(), employee.netSalary());

        System.out.println("Which percentage to increase salary?");
        double percentage = sc.nextDouble();
        employee.increaseSalary(percentage);

        System.out.printf("Updated data: %s, $ %.2f%n", employee.getName(), employee.netSalary());

        sc.close();
    }
}
