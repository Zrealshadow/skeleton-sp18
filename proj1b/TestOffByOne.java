import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {

    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.
//    Uncomment this class once you've created your CharacterComparator interface and OffByOne class. **/
    @Test
    public void TestOffByOne(){
        assertTrue(offByOne.equalChars('c','b'));
        assertTrue(offByOne.equalChars('c','d'));
        assertTrue(offByOne.equalChars('&','%'));
        assertFalse(offByOne.equalChars('c','c'));
        assertFalse(offByOne.equalChars('&','K'));
        assertTrue(offByOne.equalChars('K','L'));
        assertTrue(offByOne.equalChars('M','N'));
        assertFalse(offByOne.equalChars(' ','I'));
    }
}
