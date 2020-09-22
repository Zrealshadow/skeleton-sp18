import org.junit.Test;
import sun.plugin2.os.windows.FLASHWINFO;

import static org.junit.Assert.*;
/**
 * @program: lab3
 * @description:
 * @author: Lingze_Waldinsamkeit
 * @create: 2020-09-22 22:04
 **/
public class FlikTest {
    @Test
    public void TestissameNumber(){
        Integer A = 1;
        Integer B = 2;
        Integer C = 1;
        assertFalse(Flik.isSameNumber(A,B));
        assertTrue(Flik.isSameNumber(A,C));

        Integer AA = 129;
        Integer BB = 129;
        assertTrue(Flik.isSameNumber(AA,BB));
    }
}
