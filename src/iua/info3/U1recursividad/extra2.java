package iua.info3.U1recursividad;

/**
 * el mayor del arreglo
 */
public class extra2 {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 3, 1, 2, 3, 4, 3, 1, 2, 3, 4, 3, 1, 2, 3, 4, 3, 1, 2, 3, 4, 3, 1, 2, 3, 4, 3, 1, 2, 3, 4, 3, 1, 2, 3, 4, 3,};

        System.out.println(a.length);

        long startTime = System.nanoTime();
        int ma = mayorRapido(a, a.length);
        long stopTime = System.nanoTime();
        System.out.println("rapido:" + (stopTime - startTime) / 1000000.0 + " ms");
        System.out.println(ma);

        startTime = System.nanoTime();
        ma = mayorLento(a, a.length);
        stopTime = System.nanoTime();
        System.out.println("lento:" + (stopTime - startTime) / 1000000.0 + " ms");

        System.out.println(ma);

    }

    public static int mayorRapido(int[] arr, int tam) {
        if (tam == 1)
            return arr[0];

        int mayor_del_resto = mayorRapido(arr, tam - 1);

        if (mayor_del_resto > arr[tam - 1])
            return mayor_del_resto;
        else
            return arr[tam - 1];
    }

    /**
     * 1    1
     * 2    1 + 2
     * 3    1 + 2 + 3 + 3
     * 4    1 + 2 + 3 + 3 +
     */
    public static int mayorLento(int[] arr, int tam) {
        if (tam == 1)
            return arr[0];

        if (mayorLento(arr, tam - 1) > arr[tam - 1])
            return mayorLento(arr, tam - 1);
        else
            return arr[tam - 1];
    }
}
