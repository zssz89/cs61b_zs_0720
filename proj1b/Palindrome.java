public class Palindrome {
    public Deque<Character> wordToDeque(String word){
        LinkedListDeque<Character> deque = new LinkedListDeque<>();
        for(int i = 0; i < word.length(); i++){
            deque.addLast(word.charAt(i));
        }
        return deque;
    }
    public boolean isPalindrome(String word){
        Deque d = wordToDeque(word);
        return recIsPalindrome(d);
    }

    public boolean isPalindrome(String word, CharacterComparator cc){
        Deque d = wordToDeque(word);
        return recIsPalindrome(d,cc);
    }
    private boolean recIsPalindrome(Deque <Character> deque, CharacterComparator cc) {
        if (deque.size() == 0 || deque.size() == 1) {
            return true;
        } else {
            Character first = deque.removeFirst();
            Character last = deque.removeLast();
            if (cc.equalChars(first, last)){
                return recIsPalindrome(deque, cc);
            }else{
                return false;
            }
        }
    }

    private boolean recIsPalindrome(Deque <Character> deque) {
        if (deque.size() == 0 || deque.size() == 1) {
            return true;
        } else {
            Character first = deque.removeFirst();
            Character last = deque.removeLast();
            if (first == last){
                return recIsPalindrome(deque);
            }else{
                return false;
            }
        }
    }


}
