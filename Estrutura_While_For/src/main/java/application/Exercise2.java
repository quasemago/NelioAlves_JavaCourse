package application;

/*
Um Posto de combustíveis deseja determinar qual de seus produtos tem a preferência de seus clientes. Escreva
um algoritmo para ler o tipo de combustível abastecido (codificado da seguinte forma: 1.Álcool 2.Gasolina 3.Diesel
4.Fim).

Caso o usuário informe um código inválido (fora da faixa de 1 a 4) deve ser solicitado um novo código (até
que seja válido).

O programa será encerrado quando o código informado for o número 4. Deve ser escrito a
mensagem: "MUITO OBRIGADO" e a quantidade de clientes que abasteceram cada tipo de combustível, conforme
exemplo
 */

import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);

        System.out.println("Informe o tipo de Combustível: 1.Álcool 2.Gasolina 3.Diesel\nOu 4 para encerrar o Programa.");
        int tipo = sc.nextInt();

        int alcool = 0, gasolina = 0, diesel = 0;

        while (tipo != 4) {
            if (tipo == 1) {
                alcool += 1;
            }
            if (tipo == 2) {
                gasolina += 1;
            }
            if (tipo == 3) {
                diesel += 1;
            }

            tipo = sc.nextInt();
        }

        System.out.println("MUITO OBRIGADO");
        System.out.printf("Álcool: %d, Gasolina: %d, Diesel: %d", alcool, gasolina, diesel);
    }
}
