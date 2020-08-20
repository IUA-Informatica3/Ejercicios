package iua.info3.U1recursividad;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class BT_8reinas {
    static String[][] tablero;

    public static void main(String[] args) {
        tablero = new String[8][8];

        // inicializamos el tablero en 0
        for (String[] ints : tablero) {
            Arrays.fill(ints, "⬜");
        }


        putQueen(0, 0);

        print();
    }

    public static boolean checkQueen(int x, int y) {

        // Verifico Fila
        for (int i = 0; i < tablero.length; i++) {
            if (!tablero[y][i].equals("⬜") && i != x) {
                return false;
            }
        }
        // Verifico Columna
        for (int j = 0; j < tablero.length; j++) {
            if (!tablero[j][x].equals("⬜") && j != y) {
                return false;
            }
        }
        // Verifico diagonales
        // Verifico \
        int j = y - tablero.length;
        int i = x - tablero.length;
        while (i < tablero.length * 2 || j < tablero.length * 2) {
            i++;
            j++;
            if (i >= 0 && j >= 0 && i < tablero.length && j < tablero.length) {
                if (!tablero[j][i].equals("⬜") && j != y && i != x) {
                    return false;
                }
            }
        }

        // Verifico /  x4 y5
        i = y + tablero.length;
        j = x - tablero.length;
        while (j < tablero.length * 2 || i >= -tablero.length) {
            j++;
            i--;
            if (i >= 0 && j >= 0 && i < tablero.length && j < tablero.length) {
                if (!tablero[j][i].equals("⬜") && j != y && i != x) {
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean putQueen(int x, int y) {
        String anterior = tablero[y][x];
        if (y >= tablero.length)
            return true;

        tablero[y][x] = "\uD83D\uDD25";
        print();
        if (!checkQueen(x, y)) {
            tablero[y][x] = anterior;
            return false;
        }

        for (int i = 0; i < tablero.length; i++)
            if (putQueen(i, y + 1)) {
                tablero[y][x] = "\uD83D\uDC78";
                return true;
            }

        tablero[y][x] = anterior;
        return false;
    }

    public static void print() {
        System.out.print("\033[H\033[2J");
        for (String[] fila : tablero) {
            for (String columna : fila) {
                System.out.print(columna + " ");
            }
            System.out.print("\n");
        }
        System.out.flush();
        try {

            TimeUnit.MILLISECONDS.sleep(100);
        } catch (Exception e) {

        }
    }
}
