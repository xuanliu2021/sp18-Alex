public class LinkedListDeque<Item> implements Deque<Item> {

    private Node sentF;
    private Node sentB;
    private int size;

    private class Node {
        private Node prev;
        private Item item;
        private Node next;

        public Node(Node p, Item i, Node n) {
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
    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void printDeque() {
        Node p = sentF.next;
        while (p.next != null) {
            System.out.print(p.item + " ");
            p = p.next;
        }
        System.out.println("/n");
    }

    @Override
    public void addFirst(Item item) {
        sentF.next = new Node(sentF, item, sentF.next);
        sentF.next.next.prev = sentF.next;
        size += 1;
    }

    @Override
    public void addLast(Item item) {
        sentB.prev = new Node(sentB.prev, item, sentB);
        sentB.prev.prev.next = sentB.prev;
        size += 1;
    }

    @Override
    public Item removeFirst() {
        if (size == 0) {
            return null;
        }
        Node p = sentF.next;
        sentF.next = p.next;
        sentF.next.prev = sentF;
        size -= 1;
        return p.item;
    }

    @Override
    public Item removeLast() {
        if (size == 0) {
            return null;
        }
        Node p = sentB.prev;
        sentB.prev = p.prev;
        sentB.prev.next = sentB;
        size -= 1;
        return p.item;
    }

    public Item get(int index) {
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

    private Item getHelper(Node p, int index) {
        if (index == 0) {
            return p.item;
        }
        return getHelper(p.next, index - 1);
    }

    public Item getRecursive(int index) {
        if (index >= size) {
            return null;
        }
        return getHelper(sentF.next, index);
    }

    /*
    public LinkedListDeque(LinkedListDeque other) {
        sentF = new Node(null, null, null);
        sentB = new Node(null, null, null);
        sentF.next = sentB;
        sentB.prev = sentF;

        for (int i = 0; i < other.size(); i += 1) {
            addLast((Item) other.get(i));
        }

        size = other.size;
    }

     */
}
