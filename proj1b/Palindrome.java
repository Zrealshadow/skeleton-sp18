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
        CharacterComparator cc = new OffByOne();
        return isPalindrome(d) || isPalindrome(word,cc);
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

    public boolean isPalindrome(String word, CharacterComparator cc) {
        if (word.length()==1 || word.length()==0){
            return true;
        }
        else{
            int first_idx = 0;
            int last_idx = word.length() - 1;
            return isPalindrome_(word, first_idx, last_idx, cc);
        }
    }

    private boolean isPalindrome_(String word, int first_idx, int last_idx,CharacterComparator cc) {
        if (first_idx >= last_idx){
            return true;
        }
        else if (cc.equalChars(word.charAt(first_idx),word.charAt(last_idx))) {
            first_idx ++;
            last_idx --;
            return isPalindrome_(word, first_idx, last_idx, cc);
        }
        else {
            return false;
        }
    }



}
