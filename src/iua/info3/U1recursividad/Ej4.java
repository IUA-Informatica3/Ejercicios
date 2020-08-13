package iua.info3.U1recursividad;

public class Ej4 {

    public static void main(String[] args) {
        System.out.println("➗ dividir " + dividir(320, 6));
    }

    /***
     15 / 5

     15 - 5 - 5 - 5 = 0

     12 / 3

     12 - 3 - 3 - 3 - 3 = 0

     a        b
     18     / 6  -> 3
     12     / 6  -> 2
     (12-6) / 6  -> 1
     0     / 6  -> 0

     0
     */

    static public int dividir(int a, int b) {
        if (a < b) {
            return 0;
        }
        return 1 + dividir(a - b, b);
    }
}
