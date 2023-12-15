package application;

import java.util.Scanner;

/*
 * Leia 2 valores inteiros (A e B). Após, o programa deve mostrar uma mensagem "Sao Multiplos" ou "Nao sao
 * Multiplos", indicando se os valores lidos são múltiplos entre si. Atenção: os números devem poder ser digitados em
 * ordem crescente ou decrescente.
 */

public class Exercise2 {
    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);

        int a, b;

        System.out.println("Informe 2 valores inteiros em ordem crescente/decrescente:");
        a = sc.nextInt();
        b = sc.nextInt();

        if (a % b == 0 || b % a == 0) {
            System.out.println("Os números informados são múltiplos.");
        } else {
            System.out.println("Os números informados não são múltiplos.");
        }
    }
}
