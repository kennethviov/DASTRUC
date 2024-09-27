package DASTRUC.LinkedLists;

public class Node<E> {
    E data;
    Node<E> tail;

    Node(E data) {
        this.data = data;
        tail = null;
    }
}
