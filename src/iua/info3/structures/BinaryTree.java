package iua.info3.structures;


public class BinaryTree<AnyType extends Comparable<? super AnyType>> {
    BinaryNode<AnyType> root;

    public void insert(AnyType d) {
        root = insert(d, root);
    }

    private BinaryNode<AnyType> insert(AnyType d, BinaryNode<AnyType> node) {
        if (node == null)
            return new BinaryNode<>(d);

        int comp = d.compareTo(node.data);

        if (comp > 0) {
            node.left = insert(d, node.left);
        } else if (comp < 0) {
            node.right = insert(d, node.right);
        } else {
            // Dato duplicado
        }
        return node;
    }

    public AnyType get(AnyType d) throws Exception {
        return get(d, root);
    }

    public AnyType get(AnyType d, BinaryNode<AnyType> node) throws Exception {
        if (node == null)
            throw new Exception("Not found");

        int comp = node.data.compareTo(d);

        if (comp > 0) {
            return get(d, node.left);
        } else if (comp < 0) {
            return get(d, node.right);
        } else {
            return node.data;
        }
    }

    public boolean contains(AnyType d) {
        return contains(d, root);
    }

    public boolean contains(AnyType d, BinaryNode<AnyType> node) {
        if (node == null)
            return false;

        int comp = node.data.compareTo(d);

        if (comp > 0) {
            return contains(d, node.left);
        } else if (comp < 0) {
            return contains(d, node.right);
        } else {
            return true;
        }
    }

    public void remove(AnyType d) {
        root = remove(d, root);
    }

    private BinaryNode<AnyType> remove(AnyType d, BinaryNode<AnyType> t) {
        if (t == null)
            return t;   // Item not found; do nothing

        int compareResult = d.compareTo(t.data);

        if (compareResult < 0)
            t.left = remove(d, t.left);
        else if (compareResult > 0)
            t.right = remove(d, t.right);
        else if (t.left != null && t.right != null) // Two children
        {
            t.data = findMin(t.right).data;
            t.right = remove(t.data, t.right);
        } else
            t = (t.left != null) ? t.left : t.right;
        return t;
    }

    private BinaryNode<AnyType> findMin(BinaryNode<AnyType> t) {
        if (t == null)
            return null;
        else if (t.left == null)
            return t;
        return findMin(t.left);
    }


    private BinaryNode<AnyType> findMax(BinaryNode<AnyType> node) {
        while (node.right != null)
            node = node.right;

        return node;
    }

    public void print() {
        print(false, "", root);
    }

    private void print(boolean esDerecho, String identacion, BinaryNode<AnyType> r) {
        if (r.right != null) {
            print(true, identacion + (esDerecho ? "     " : "|    "), r.right);
        }
        System.out.print(identacion);
        if (esDerecho) {
            System.out.print(" /");
        } else {
            System.out.print(" \\");
        }
        System.out.print("-- ");
        System.out.println(r.data);
        if (r.left != null) {
            print(false, identacion + (esDerecho ? "|    " : "     "), r.left);
        }
    }

    public void iterInorder() throws Exception {
        LinkedStack<BinaryNode<AnyType>> st = new LinkedStack<>();
        BinaryNode<AnyType> curr = root;

        while (curr != null || !st.isEmpty()) {
            while (curr != null) {
                st.push(curr);
                curr = curr.left;
            }
            curr = st.topAndPop();
            System.out.print(curr.data + " ");
            curr = curr.right;
        }

    }


    private class BinaryNode<AnyType> {
        AnyType data;
        BinaryNode<AnyType> left, right;

        public BinaryNode(AnyType data) {
            this.data = data;
            left = right = null;
        }
    }
}
