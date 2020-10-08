package iua.info3.U0PilasColas;

import iua.info3.structures.ArrayStack;
import iua.info3.structures.LinkedStack;

public class Main {
    public static void main(String[] args) throws Exception {
        ArrayStack miPila = new ArrayStack(3);

        String txt = "Hola mundo, como andan todos?";

        for (int i = 0; i < txt.length(); i++) {
            miPila.push(txt.charAt(i));
        }

        try {
            for (int i = 0; i < txt.length(); i++) {
                System.out.println(miPila.popAndTop());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            System.out.println(miPila.popAndTop()); // throw
        } catch (Exception e) {
            System.out.println("Tire bien exce");
        }

        System.out.println("\n\n\n\n\n");
        print();
    }

    private static void print() throws Exception {
        LinkedStack<Integer> p = new LinkedStack<>();
        Integer tmp;
        for (int n = 0; n < 6; n++) p.push(n);
        while (!p.isEmpty()) {
            tmp = p.topAndPop();
            if (tmp % 2 == 1)
                p.push(tmp * p.topAndPop());
            else
                System.out.println(tmp);
        }
    } // 20  6  0
}
