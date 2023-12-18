package application;

/*
 * Faça um programa para ler o valor do raio de um círculo, e depois mostrar o valor da área deste círculo com quatro
 * casas decimais conforme exemplos.
 *
 * Fórmula da área: area = π . raio²
 *
 * Considere o valor de π = 3.14159
 */

import java.util.Locale;
import java.util.Scanner;

public class Exercise2 {
    private final static double PI = 3.14159;

    public static void main (String[] args){
        Locale.setDefault(Locale.US);

        final Scanner sc = new Scanner(System.in);

        System.out.println("Informe o valor do raio de um círculo:");
        double raio = sc.nextDouble();

        // Calcular á area.
        double area = PI * Math.pow(raio, 2.0);

        // Informa á area.
        System.out.printf("Área do círculo: %.4f", area);
    }
}
