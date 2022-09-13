public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        LinkedListDeque<Character> d = new LinkedListDeque<> ();
        for (int i = 0; i < word.length(); i += 1) {
            d.addLast(word.charAt(i));
        }
        return d;
    }

    private Boolean isPalindrome(LinkedListDeque<Character> d) {
        if(d.size() == 0 || d.size() == 1) {
            return true;
        }
        else if(d.removeFirst() == d.removeLast()) {
            return isPalindrome(d);
        }
        else return false;
    }

    public boolean isPalindrome(String word) {
        LinkedListDeque<Character> d = (LinkedListDeque<Character>) wordToDeque(word);
        return isPalindrome(d);
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        LinkedListDeque<Character> d = (LinkedListDeque<Character>) wordToDeque(word);
        return cc.isPalindrome(d);
    }
}
