package iua.info3.U1recursividad;

import java.util.Scanner;

/***
 * Escribir una función que introduzca un entero no negativo por teclado y lo imprima
 * como una serie de dígitos separados por espacios.
 * Ej: fn(2345)
 * 2 3 4 5
 */

public class Ej7 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("\uD83D\uDC4D Ingrese Número");

        //int numero = in.nextInt();
        // imprimir(numero);
        imprimir(30324);
    }

    static public void imprimir(int n) {
        if (n < 10) {
            System.out.print(" " + n);
            return;
        }
        imprimir(n / 10);
        System.out.print(" " + n % 10);
    }
}
