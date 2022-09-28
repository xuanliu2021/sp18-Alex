public class ArrayDeque<T> {
    private T[] items;
    public int size;
    public int length;
    private int nextFirst;
    private int nextLast;


    /** Build an empty array.*/
    public ArrayDeque() {
        items = (T []) new Object[8];
        nextFirst = 3;
        nextLast = 4;
        size = 0;
        length = 8;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void resize() {
        T[] a = (T[]) new Object[size * 2];
        for (int i = 0; i < size; i++) {
            nextFirst = plusOne(nextFirst);
            a[i] = items[nextFirst];
        }

        if (size == length) {
            length = length * 2;
        } else {
            length = length / 2;
        }

        nextFirst = length - 1;
        nextLast = size;
        items = a;
    }

    private int minusOne(int index) {
        if (index == 0) {
            return length - 1;
        } else {
            return index - 1;
        }
    }

    private int plusOne(int index) {
        if (index == length - 1) {
            return 0;
        } else {
            return index + 1;
        }
    }

    public void addFirst(T item) {
        if (size == length) {
            resize();
        }
        items[nextFirst] = item;
        nextFirst = minusOne(nextFirst);
        size += 1;
    }

    public void addLast(T item) {
        if (size == length) {
            resize();
        }
        items[nextLast] = item;
        nextLast = plusOne(nextLast);
        size += 1;
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        nextFirst = plusOne(nextFirst);
        T ptr = items[nextFirst];
        items[nextFirst] = null;
        size -= 1;
        if (length >= 16 && length / size >= 4) {
            resize();
        }
        return ptr;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }
        nextLast = minusOne(nextLast);
        T ptr = items[nextLast];
        items[nextLast] = null;
        size -= 1;
        if (length >= 16 && length / size >= 4) {
            resize();
        }
        return ptr;
    }

    public T get(int index) {
        if (index >= size) {
            return null;
        }

        index = nextFirst + index + 1;
        if (index > length - 1) {
            index = index - length;
        }
        return items[index];
    }

    public void printDeque() {
        int n = nextFirst;
        for (int i = 0; i < size; i += 1) {
            n = plusOne(n);
            System.out.print(items[n] + " ");
        }
        System.out.println("\n");
    }

/*
    public ArrayDeque(ArrayDeque other) {
        items = (T []) new Object[other.length];
        nextFirst = other.nextFirst;

        for (int i = 0; i < other.size; i += 1) {
            addLast((T) other.get(i));
        }
        size = other.size;
    }
 */
}
