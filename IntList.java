public class IntList {
    public int first;
    public IntList rest;
    
    public IntList(int f, IntList r) {
        first = f;
        rest = r;
    }

    public int get(int i) {
        // IntList p = this;
        // int index = 0;
        // while (index < i) {
        //     p = p.rest;
        //     index += 1;
        // }
        // return p.first;
        if (i == 0) {
            return this.first;
        }
        return this.rest.get(i-1);
    }

    public static void main(String[] args) {
        IntList L = new IntList(5, null);
        L.rest = new IntList(10, null);
        L.rest.rest = new IntList(15, null);
        System.out.print(L.get(1));
    }

} 