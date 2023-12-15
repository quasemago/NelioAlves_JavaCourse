package application;

import java.util.Scanner;

/*
 * Fazer um programa para ler um número inteiro, e depois dizer se este número é negativo ou não.
 */

public class Exercise1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Informe um número inteiro:");
        int n = sc.nextInt();

        if (n < 0) {
            System.out.println("O numero é negativo!");
        } else {
            System.out.println("O numero não é negativo!");
        }
    }
}
