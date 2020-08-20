package iua.info3.U1recursividad;

public class Toledo_Ej4 {
    public static void main(String[] args) {

        int[] arr = {54, 3, 2, 1, 0};

        inverso(arr, arr.length);
    }

    public static void inverso(int[] arr, int n) {
        if (n <= 0) {
            return;
        }
        System.out.println(arr[n - 1]);
        inverso(arr, n - 1);
    }
}
