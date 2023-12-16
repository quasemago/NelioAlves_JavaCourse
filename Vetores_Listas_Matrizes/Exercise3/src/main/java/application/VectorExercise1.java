package application;

import java.util.Scanner;

/*
Faça um programa que leia um número inteiro positivo N (máximo = 10) e depois N números inteiros
e armazene-os em um vetor. Em seguida, mostrar na tela todos os números negativos lidos.
 */

public class VectorExercise1 {
    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of elements (max 10): ");
        int n = sc.nextInt();
        while (n < 0 || n > 10) {
            System.out.print("Enter the number of elements (max 10): ");
            n = sc.nextInt();
        }

        int[] vec = new int[n];

        for (int i = 0; i < vec.length; i++) {
            System.out.print("Enter the number: ");
            vec[i] = sc.nextInt();
        }

        // Check negative numbers.
        System.out.println("\nNegative numbers: ");
        for (int number : vec) {
            if (number < 0) {
                System.out.println(number);
            }
        }

        sc.close();
    }
}
