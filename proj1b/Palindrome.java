/**
 * @program: proj1b
 * @description:
 * @author: Lingze_Waldinsamkeit
 * @create: 2020-09-23 22:38
 **/
public class Palindrome {

    public Deque<Character> wordToDeque(String word) {
        LinkedListDeque<Character> ans = new LinkedListDeque<Character>();
        for(int i = 0; i < word.length(); i++){
            ans.addLast(word.charAt(i));
        }
        return ans;
    }

    public boolean isPalindrome(String word) {
        Deque<Character> d = wordToDeque(word);
        return isPalindrome(d);
    }

    private boolean isPalindrome(Deque<Character> d) {
        if (d.size() == 0 || d.size() == 1) {
            return true;
        }
        else {
            char first = d.removeFirst();
            char last = d.removeLast();
            if (first == last) {
                return isPalindrome(d);
            }
            else {
                return false;
            }
        }
    }
}
