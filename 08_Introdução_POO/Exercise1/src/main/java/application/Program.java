package application;

/*
Fazer um programa para ler os valores da largura e altura
de um retângulo. Em seguida, mostrar na tela o valor de
sua área, perímetro e diagonal.

Utilize a seguinte classe:
* Rectangle
- Width: double
- Height: double
+ Area(): double
+ Perimeter(): double
+ Diagonal() : double
 */

import entities.Rectangle;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        final Scanner sc = new Scanner(System.in);

        System.out.println("Informe largura e altura do retângulo, respectivamente.");
        double largura = sc.nextDouble();
        double altura = sc.nextDouble();

        Rectangle rec = new Rectangle(largura, altura);

        System.out.printf("Área: %.2f%n", rec.area());
        System.out.printf("Perímetro: %.2f%n", rec.perimeter());
        System.out.printf("Diagonal: %.2f%n", rec.diagonal());
    }
}
