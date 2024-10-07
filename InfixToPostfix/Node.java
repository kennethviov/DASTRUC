class Node<E> {
    E data;
    Node<E> next;

    public Node(E data) {
        this.data = data;
        this.next = null;
    }
}

class Stack<E> {
    Node<E> head;
    private int count;
    
    public Stack() {
        head = null;
        count = 0;
    }

    public Stack(Node<E> head) {
        this.head = head;
        count = 0;
    }

    void push(E data) {
        Node<E> node = new Node<>(data);
        node.next = head;
        head = node;
        count++;
    }

    E pop() {
        if (!isEmpty()) {
            E data = head.data;
            head = head.next;
            count--;
            return data;
        }
        return null;
    }

    E peek() {
        if (!isEmpty())
            return head.data;
        return null;
    }

    void display() {
        Node<E> curr = head;
        
        while(curr != null) {
            System.out.println("[" + curr.data + "]");
            curr = curr.next;
        }
    }
    
    int getCount() {
        return count;
    }

    boolean isEmpty() {
        return head == null || count == 0;
    }
}
