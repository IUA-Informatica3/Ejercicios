package iua.info3.structures;

public class ArrayStack {
    private char[] stack;
    private int size;
    private int index;

    public ArrayStack() {
        this.index = 0;
        this.size = 10;
        this.stack = new char[10];
    }

    public ArrayStack(int size) {
        this.size = size;
        this.stack = new char[size];
    }

    public void push(char data) {
        stack[index] = data;
        index++;
        if (index == size) {
            // Duplicar y copiar
            char[] aux = new char[size * 2];
            size = size * 2;
            System.arraycopy(stack, 0, aux, 0, stack.length);
//            for (int i = 0; i < stack.length; i++) {
//                aux[i] = stack[i];
//            }
            stack = aux;
        }
    }

    public char popAndTop() throws Exception {
        pop();
        return stack[index];
    }

    public void pop() throws Exception {
        if (index == 0)
            throw new Exception("Stack Empty");

        index--;
        if (size > 3 && index < size / 3) {
            // Reducir a la mitad y copiar
            char[] aux = new char[size / 2];
            size = size / 2;
            System.arraycopy(stack, 0, aux, 0, aux.length);
            stack = aux;
        }
    }

    public char top() throws Exception {
        if (index == 0)
            throw new Exception("Stack Empty");
        return stack[index - 1];
    }

    public boolean isEmpty() {
        return index == 0;
    }

    public void makeEmpty() {
        index = 0;
    }
}
