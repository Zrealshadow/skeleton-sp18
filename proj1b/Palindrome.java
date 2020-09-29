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
//        CharacterComparator cc = new OffByOne();
        return isPalindrome(d);
    }

    private boolean isPalindrome(Deque<Character> d) {
        if (d.size() == 0) {
            return true;
        }
        else if(d.size() == 1) {
            return isCharacter(d.removeFirst());
        }else {
            char first = d.removeFirst();
            char last = d.removeLast();
//            if (first == last) {
//                return isPalindrome(d);
//            }
//            else {
//                return false;
//            }
            return isCharacter(first) && isCharacter(last) && first == last && isPalindrome(d);
        }
    }

    private boolean isCharacter(char c) {
        return (c <= 'Z' && c>= 'A') || (c <= 'z' && c>= 'a');
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        if (word.length()==0){
            return true;
        }
        else if (word.length() == 1){
            return isCharacter(word.charAt(0));
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
        else {
            char a = word.charAt(first_idx++);
            char b = word.charAt(last_idx--);
            boolean t =  cc.equalChars(a,b) && isCharacter(a) && isCharacter(b);
            return t && isPalindrome_(word,first_idx,last_idx,cc);
        }
    }



}
