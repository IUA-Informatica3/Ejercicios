package iua.info3.structures;

public class LinkedQueue<AnyType> {
    private LinkedNode<AnyType> front;
    private LinkedNode<AnyType> back;

    public LinkedQueue() {
        front = null;
        back = null;
    }

    //   front [] [] [] [] [] [] [back] -> [ ]

    public void enqueue(AnyType d) {
        if (back == null) {
            back = new LinkedNode<>(null, d);
            front = back;
        } else {
            back.next = new LinkedNode<>(null, d);
            back = back.next;
        }
    }

    public AnyType dequeue() throws Exception {
        if (front == null)
            throw new Exception("Empty Queue");

        AnyType d = front.data;
        front = front.next;

        if (front == null)
            back = null;
        return d;
    }
}
