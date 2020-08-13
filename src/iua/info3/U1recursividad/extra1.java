package iua.info3.U1recursividad;

public class extra1 {
    public static void main(String[] args) {
        char[] a = {'H', 'o', 'l', 'a', ' ', 'm', 'u', 'n', 'd', 'o',
                ' ', 'c', 'o', 'm', 'o', ' ', 'v', 'a', '?'};
        System.out.println(contar(a, 'H', a.length)); // 2
        System.out.println(contar(a, 'o', a.length)); // 4

    }

    public static int contar(char[] arr, char letra, int tam) {
        if (tam == 0)
            return 0;

        if (arr[tam - 1] == letra) {
            return 1 + contar(arr, letra, tam - 1);
        } else {
            return contar(arr, letra, tam - 1);
        }
    }
}
