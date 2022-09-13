public class ArrayDeque<T> {

    private T[] items;
    private int size;

    private int nextFirst;

    private int nextLast;


    /** Build an empty array.*/
    public ArrayDeque() {
        items = (T []) new Object[8];
        nextFirst = nextLast = 0;
        size = 0;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void addFirst(T item) {

        items[nextFirst] = item;
        size += 1;

        if (nextFirst == nextLast) {
            resize();
            nextFirst = items.length - 1;
            nextLast = size;
        } else if (nextFirst == 0) {
            nextFirst = items.length - 1;
        } else {
            nextFirst -= 1;
        }
    }


    public void addLast(T item) {

        items[nextLast] = item;
        size += 1;

        if (nextFirst == nextLast) {
            resize();
            nextFirst = items.length - 1;
            nextLast = size;
        } else if (nextLast == items.length - 1) {
            nextLast = 0;
        } else {
            nextLast += 1;
        }
    }


    public int size() {
        return size;
    }


    public T removeFirst() {
        size -= 1;
        T ptr;

        if (nextFirst == items.length - 1) {
            ptr = items[0];
            nextFirst = 0;
            items[0] = null;
        } else {
            ptr = items[nextFirst + 1];
            nextFirst += 1;
            items[nextFirst + 1] = null;
        }
        resize();
        return ptr;
    }


    public T removeLast() {
        size -= 1;
        T ptr;

        if (nextLast == 0) {
            ptr = items[items.length - 1];
            nextLast = items.length - 1;
            items[items.length - 1] = null;
        } else {
            ptr = items[nextLast - 1];
            nextLast -= 1;
            items[nextLast - 1] = null;
        }
        resize();
        return ptr;
    }

    public T get(int index) {
        int n = nextFirst;
        int idx = n + index + 1;
        if (idx > items.length - 1) {
            idx = idx - items.length;
        }

        return items[idx];
    }


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
        T[] a;
        //delete extra spaces when usage ratio is less than 0.25
        double uFactor = size / items.length;
        if (uFactor < 0.25 && items.length > 16) {
            a = (T[]) new Object[size * 2];
            for (int i = 0; i < size; i += 1) {
                if (nextFirst == items.length - 1) {
                    a[i] = items[0];
                } else {
                    a[i] = items[nextFirst + 1];
                    nextFirst += 1;
                }
            }
        } else {
            a = (T[]) new Object[size * 2];
            System.arraycopy(items, 0, a, 0, size);
        }
        items = a;
    }

    public ArrayDeque(ArrayDeque other) {
        items = (T []) new Object[other.items.length];
        nextFirst = other.nextFirst;
        if (nextFirst == items.length - 1) {
            nextLast = 0;
        } else {
            nextLast = other.nextFirst + 1;
        }
        size = 0;

        for (int i = 0; i < other.size; i += 1) {
            addLast((T) other.get(i));
        }
    }
}
