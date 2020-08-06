package iua.info3;

import iua.info3.structures.LinkedQueue;
import iua.info3.structures.LinkedList;
import iua.info3.structures.LinkedStack;

public class Main {

    public static void main(String[] args) {


        System.out.println("\n\uD83D\uDD25 LinkedList Test");
        LinkedList<Integer> lista = new LinkedList<Integer>();

        try {
            lista.add(1, 0);
            lista.add(0);
            lista.add(3, 2);
            lista.add(2, 2);

            for (int i = 0; i < 4; i++) {
                System.out.println(lista.get(i));
            }

            System.out.println(" Size: " + lista.getSize());

            lista.delete(0);
            lista.update(0, 2);
            System.out.println(" Size: " + lista.getSize());

            for (int i = 0; i < 3; i++) {
                System.out.println(lista.get(i));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            System.out.println(lista.get(3));
        } catch (Exception e) {
            System.out.println("✅ Good Exeption: lista.get(3)");;
        }
        try {
            lista.add(2,2000);
        } catch (Exception e) {
            System.out.println("✅ Good Exeption: lista.add(2,2000)");;
        }


        System.out.println("\n\uD83D\uDD25 LinkedStack Test");



        LinkedStack<Integer> pila = new LinkedStack<>();

        pila.push(3);
        pila.push(2);
        pila.push(1);
        pila.push(0);
        try {
            for (int i = 0; i < 4; i++) {
                System.out.println(pila.topAndPop());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            pila.pop();
        } catch (Exception e) {
            System.out.println("✅ Good Exeption: pila.pop();");;
        }


        System.out.println("\n\uD83D\uDD25 LinkedQueue Test");
        LinkedQueue<Integer> cola = new LinkedQueue<>();

        cola.enqueue(0);
        cola.enqueue(1);
        cola.enqueue(2);
        cola.enqueue(3);
        try {
            for (int i = 0; i < 4; i++) {
                System.out.println(cola.dequeue());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            cola.dequeue();
        } catch (Exception e) {
            System.out.println("✅ Good Exeption: cola.dequeue();");;
        }

        System.out.println("\uD83D\uDE00 The end");
    }
}
