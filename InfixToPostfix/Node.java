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
        count= 0;
    }

    void push(E data) {
        Node<E> n = new Node<E>(data);

        if (head == null) {
            head = n;
        } else {
            Node<E> curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = n;
        }
        count++;
        //System.out.println("Added " + data);
    }

    E pop() {
        if (head == null) {
            System.out.println("No data in the list.");
            return null;
        } else if (head.next == null) {
            E data = head.data;
            head = null;
            count--;
            return data;
        } else {
            Node<E> curr = head;
            while (curr.next.next != null) {
                curr = curr.next;
            }
            E data = curr.next.data;
            curr.next = null;
            count--;
            return data;
        }
    }

    E peek() {
        if (head == null) {
            System.out.println("No data in the list.");
            return null;
        } else {
            Node<E> curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            return curr.data;
        }
    }

    int getCount() {
        return count;
    }

    void display() {
        Node<E> curr = head;

        while(curr != null) {
            System.out.println("[" + curr.data + "]");
            curr = curr.next;
        }
    }
}