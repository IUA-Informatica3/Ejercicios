package iua.info3.U5Tree;

import iua.info3.structures.BinaryTree;

class Main {

    public static void main(String[] args) {
        BinaryTree<Integer> miArbol = new BinaryTree<>();

        for (int i = 0; i < 10; i++) {
            miArbol.insert((int) (Math.random() * 25));
        }

        miArbol.print();

        try {
            miArbol.iterInorder();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}