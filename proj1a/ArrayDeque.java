public class ArrayDeque<Item> implements Deque<Item> {

    public Item[] items;
    public int size;

    public int nextFirst;

    public int nextLast;


    /** Build an empty array.*/
    public ArrayDeque() {
        items = (Item []) new Object[8];
        nextFirst = nextLast = 0;
        size = 0;
    }

    @Override
    public void addFirst(Item item) {

        items[nextFirst] = item;
        size += 1;

        if (nextFirst == nextLast) {
            resize();
            nextFirst = items.length - 1;
            nextLast = size;
        }
        else if (nextFirst == 0) {
            nextFirst = items.length - 1;
        }
        else {
            nextFirst -= 1;
        }
    }

    @Override
    public void addLast(Item item) {

        items[nextLast] = item;
        size += 1;

        if (nextFirst == nextLast) {
            resize();
            nextFirst = items.length - 1;
            nextLast = size;
        }
        else if (nextLast == items.length - 1) {
            nextLast = 0;
        }
        else {
            nextLast += 1;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Item removeFirst() {
        size -= 1;
        Item ptr;

        if (nextFirst == items.length-1) {
            ptr = items[0];
            nextFirst = 0;
            items[0] = null;
        }
        else {
            ptr = items[nextFirst + 1];
            nextFirst += 1;
            items[nextFirst + 1] = null;
        }
        resize();
        return ptr;
    }

    @Override
    public Item removeLast() {
        size -= 1;
        Item ptr;

        if (nextLast == 0) {
            ptr = items[items.length - 1];
            nextLast = items.length - 1;
            items[items.length - 1] = null;
        }
        else {
            ptr = items[nextLast - 1];
            nextLast -= 1;
            items[nextLast - 1] = null;
        }
        resize();
        return ptr;
    }

    public Item get(int index) {
        int n = nextFirst;
        int idx = n + index + 1;
        if (idx > items.length - 1) {
            idx = idx - items.length;
        }

        return items[idx];
    }

    @Override
    public void printDeque() {
        int n = nextFirst;
        for (int i = 0; i < size; i += 1) {
            if (n == items.length - 1) {
                n = -1;
            }
            System.out.print(items[n + 1] + " ");
            n += 1;
        }
        System.out.println("/n");
    }

    public void resize() {
        Item[] a;
        //delete extra spaces when usage ratio is less than 0.25
        double UFactor = size / items.length;
        if (UFactor < 0.25 && items.length > 16) {
            a = (Item[]) new Object[size * 2];
            for (int i = 0; i < size; i += 1) {
                if (nextFirst == items.length - 1) {
                    a[i] = items[0];
                }
                else{
                    a[i] = items[nextFirst + 1];
                    nextFirst += 1;
                }
            }
        }
        else {
            a = (Item[]) new Object[size * 2];
            System.arraycopy(items, 0, a, 0, size);
        }
        items = a;
    }

    public ArrayDeque(ArrayDeque other) {
        items = (Item []) new Object[other.items.length];
        nextFirst = other.nextFirst;
        if (nextFirst == items.length - 1) {
            nextLast = 0;
        }
        else {
            nextLast = other.nextFirst + 1;
        }
        size = 0;

        for (int i = 0; i < other.size; i += 1) {
            addLast((Item) other.get(i));
        }
    }
}