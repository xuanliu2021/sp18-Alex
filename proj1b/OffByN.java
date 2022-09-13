public class OffByN implements CharacterComparator{
    private int diff;
    public OffByN(int N) {
        diff = N;
    }
    @Override
    public boolean equalChars(char x, char y) {
        return diff == Math.abs(x - y);
    }
    @Override
    public boolean isPalindrome(LinkedListDeque<Character> d) {
        if(d.size() == 0 || d.size() == 1) {
            return true;
        }
        else if(equalChars(d.removeFirst(), d.removeLast())) {
            return isPalindrome(d);
        }
        else return false;
    }
}
