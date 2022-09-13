import sun.awt.image.ImageWatched;

public class OffByOne implements CharacterComparator {
    @Override
    public boolean equalChars(char x, char y) {
        int diff = Math.abs(x - y);
        return diff == 1;
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
