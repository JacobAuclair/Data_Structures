public class LinkedList {

    private Node head;
    private Node tail;
    private int size;

    public LinkedList() {
        head = null;
        tail = null;
        size = 10;
    }

    public void insert(int data, int index) {

        if (index < size) {
            Node temp = new Node(data);
            Node current = getNode(index);

            if (index == 0) {
                temp.setNext(head);
                head = temp;
                tail = head;
            } else {
                temp.setNext(current.getNext());
                current.setNext(temp);
            }

            if ( index == size - 1 ) {
                tail.setNext(temp);
                tail = temp;
            }

        }
        
        if (index == 0) {
            head = head.getNext();
        } else {
            getNode(index).setNext(getNode(index).getNext().getNext());
        }
    }

    public void remove(int index) {

        if (index == 0) {
            head = head.getNext();
        } else {
            getNode(index).setNext(getNode(index).getNext().getNext());
        }

        this.size--;
    }

    private Node getNode(int index) {

        if ( index > size ) {
            throw new IllegalArgumentException("The index [" + index + "] is greater than the current size [" + size + "].");
        }
        Node current = head;
        for (int i = 1; i < index; i++) {
            current = current.getNext();
        }

        return current;
    }

    public int get(int index) {
        return getNode(index).getData();
    }

    public int size() {
        return this.size;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();

        Node current = head;
        while( current != null ) {
            builder.append("[" + current.getData() + "]");
            current = current.getNext();
        }

        return builder.toString();

    }


    private class Node {

        Node next;
        int data;

        public Node(int data) {
            this(data, null);
        }

        public Node(int data, Node next) {
            this.next = next;
            this.data = data;
        }

        public int getData() {
            return this.data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getNext() {
            return this.next;
        }

        public void setNext(Node nextNode) {
            this.next = nextNode;
        }

    }

}