package application;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);

        int lines, columns;

        System.out.println("Informe dois números inteiros para elaboração da matriz (linhas e colunas):");
        lines = sc.nextInt();
        columns = sc.nextInt();

        int[][] matrix = new int[lines][columns];

        System.out.printf("Informe os valores (números inteiros) das linhas e colunas, sendo uma matriz de %dx%d:%n", lines, columns);
        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        System.out.print("Informe um número inteiro para busca na matriz: ");
        int searchNumber = sc.nextInt();

        // Pesquisa na matriz o número inteiro informado.
        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == searchNumber) {
                    System.out.printf("Posição %d,%d:%n", i, j);

                    if (j > 0) {
                        System.out.printf("Esquerda: %d%n", matrix[i][j - 1]);
                    }
                    if (i > 0) {
                        System.out.printf("Acima: %d%n", matrix[i - 1][j]);
                    }
                    if (j < columns - 1) {
                        System.out.printf("Direita: %d%n", matrix[i][j + 1]);
                    }
                    if (i < lines - 1) {
                        System.out.printf("Abaixo: %d%n", matrix[i + 1][j]);
                    }
                }
            }
            System.out.println();
        }
    }
}
