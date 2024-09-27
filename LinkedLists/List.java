package DASTRUC.LinkedLists;

public class List<E> {
    private Node<E> head;
    private int size = 0;
    
    public List() {
        head = null;
    }

    private boolean isEmpty() {
        return head == null;
    }

    public void add(E data) {
        if (!isEmpty()) {
            Node<E> temp = head;
            while (temp.tail != null) {
                temp = temp.tail;
            }
            temp.tail = new Node<>(data);
        } else {
            head = new Node<>(data);
        }
        size++;
    }

    //Overload
    public void add(int index, E data) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        Node<E> newNode = new Node<>(data);

        if (index != 0) {
            Node<E> temp = head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.tail;
            }
            newNode.tail = temp.tail;
            temp.tail = newNode;
        } else {
            newNode.tail = head;
            head = newNode;
        }
        size++;
    }

    public void remove() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
        }

        if (head.tail == null) {
            head = null;
        } else {
            Node<E> temp = head;

            while (temp.tail.tail != null) {
                temp = temp.tail;
            }
            temp.tail = null;
        }
        size--;
    }

    //Overload
    public void remove(int index) {
        if (isEmpty()) {
            System.out.println("Stack is empty");
        }

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        if (index == 0) {
            head = head.tail;
        } else {
            Node<E> temp = head;

            for (int i = 0; i < index - 1; i++) {
                temp = temp.tail;
            }
            temp.tail = temp.tail.tail;
        }
        size--;
    }

    public void display() {
        Node<E> temp = head;
        while (temp!= null) {
            System.out.print(temp.data + " -> ");
            temp = temp.tail;
        }
        System.out.println("null");
    }

    public int size() {
        return size;
    }
}
