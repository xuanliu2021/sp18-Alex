public class LinkedListDeque<T> {

    private Node sentF;
    private Node sentB;
    private int size;

    //why private static不行

    public class Node {
        private Node prev;
        private T item;
        private Node next;

        public Node(Node p, T i, Node n) {
            prev = p;
            item = i;
            next = n;
        }
    }

    public LinkedListDeque() {
        sentF = new Node(null, null, null);
        sentB = new Node(null, null, null);
        sentF.next = sentB;
        sentB.prev = sentF;
        size = 0;
    }


    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }


    public void printDeque() {
        Node p = sentF;
        while (p.next != null) {
            System.out.print(p.item + " ");
            p = p.next;
        }
        System.out.println("/n");
    }


    public void addFirst(T item) {
        sentF.next = new Node(sentF, item, sentF.next);
        sentF.next.next.prev = sentF.next;
        size += 1;
    }


    public void addLast(T item) {
        sentB.prev = new Node(sentB.prev, item, sentB);
        sentB.prev.prev.next = sentB.prev;
        size += 1;
    }


    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        Node p = sentF.next;
        sentF.next = p.next;
        sentF.next.prev = sentF;
        size -= 1;
        return p.item;
    }


    public T removeLast() {
        if (size == 0) {
            return null;
        }
        Node p = sentB.prev;
        sentB.prev = p.prev;
        sentB.prev.next = sentB;
        size -= 1;
        return p.item;
    }

    public T get(int index) {
        Node p = sentF.next;
        int count = 0;

        while (count < index) {
            if (p.next != null) {
                p = p.next;
            }
            count += 1;
        }

        return p.item;
    }

    public T getHelper(Node p, int index) {
        if (index == 0) {
            return p.item;
        }
        return getHelper(p.next, index - 1);
    }

    public T getRecursive(int index) {
        if (index >= size) {
            return null;
        }
        return getHelper(sentF.next, index);
    }

    public LinkedListDeque(LinkedListDeque other) {
        this();
        for (int i = 0; i < other.size(); i += 1) {
            addFirst((T) other.get(i));
        }
    }
}
