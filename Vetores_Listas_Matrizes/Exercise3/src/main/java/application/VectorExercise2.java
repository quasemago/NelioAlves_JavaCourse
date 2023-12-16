package application;

/*
   Faça um programa que leia N números reais e armazene-os em um vetor. Em seguida
    - Imprimir todos os elementos do vetor
    - Mostrar na tela a soma e a média dos elementos do vetor
 */

import java.util.Locale;
import java.util.Scanner;

public class VectorExercise2 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        final Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();

        double[] vec = new double[n];

        for (int i = 0; i < vec.length; i++) {
            System.out.print("Enter the number: ");
            vec[i] = sc.nextDouble();
        }

        double sum = 0.0;
        double media = 0.0;

        System.out.print("\nElements: ");
        for (double number : vec) {
            sum += number;
            System.out.print(number + " ");
        }

        System.out.printf("%nSum: %.2f%n", sum);
        System.out.printf("Media: %.2f", (sum / vec.length));

        sc.close();
    }
}
