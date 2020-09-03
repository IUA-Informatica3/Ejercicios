package iua.info3.U0PilasColas;

import iua.info3.structures.ArrayStack;

public class Main {
    public static void main(String[] args) {
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

    }
}
