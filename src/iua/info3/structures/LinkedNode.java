package iua.info3.structures;

public class LinkedNode<AnyType> {
    public LinkedNode<AnyType> next;
    public AnyType data;

    public LinkedNode(LinkedNode<AnyType> next, AnyType data) {
        this.next = next;
        this.data = data;
    }
}
