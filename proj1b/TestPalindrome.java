import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();
    static CharacterComparator cmp = new OffByOne();
    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    } /* Uncomment this class once you've created your Palindrome class. */

    @Test
    public void testIsPalindrome(){
        assertTrue(palindrome.isPalindrome(""));
        assertTrue(palindrome.isPalindrome("a" ));
        assertTrue(palindrome.isPalindrome("k"));
        assertTrue(palindrome.isPalindrome("kk"));
        assertTrue(palindrome.isPalindrome("noon"));
        assertTrue(palindrome.isPalindrome("racecar"));
        assertFalse(palindrome.isPalindrome("ka"));
        assertFalse(palindrome.isPalindrome("car"));
        assertFalse(palindrome.isPalindrome("aaaaaaab"));
        assertTrue(palindrome.isPalindrome("5665"));
        assertFalse(palindrome.isPalindrome("5kk6"));
        assertTrue(palindrome.isPalindrome("%%%&%%%"));
        assertTrue(palindrome.isPalindrome("ABA"));
        assertFalse(palindrome.isPalindrome("AB"));
        assertFalse(palindrome.isPalindrome("%&"));

        assertFalse(palindrome.isPalindrome("ka",cmp));
        assertFalse(palindrome.isPalindrome("car",cmp));
        assertFalse(palindrome.isPalindrome("aaaaaaab",cmp));

        assertTrue(palindrome.isPalindrome("flake",cmp));
        assertTrue(palindrome.isPalindrome("tuts",cmp));
        assertTrue(palindrome.isPalindrome("ungot",cmp));

        assertFalse(palindrome.isPalindrome("ABBA",cmp));

        assertTrue(palindrome.isPalindrome("hong",cmp));

        assertTrue(palindrome.isPalindrome("%",cmp));
        assertTrue(palindrome.isPalindrome("",cmp));
        assertTrue(palindrome.isPalindrome("%%%&&&",cmp));
        assertTrue(palindrome.isPalindrome("ABCBBAB",cmp));
        assertFalse(palindrome.isPalindrome("ABCBCBA",cmp));
        assertFalse(palindrome.isPalindrome("%%%&",cmp));
        assertFalse(palindrome.isPalindrome("aa",cmp));
        assertTrue(palindrome.isPalindrome("ba",cmp));

        assertFalse(palindrome.isPalindrome("ABABK",cmp));
        assertFalse(palindrome.isPalindrome("hogM",cmp));
        assertFalse(palindrome.isPalindrome("%Ab%",cmp));

        assertTrue(palindrome.isPalindrome("AbaB",cmp));
        assertFalse(palindrome.isPalindrome("AbbB",cmp));

    }
}
