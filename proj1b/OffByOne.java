/**
 * @program: proj1b
 * @description:
 * @author: Lingze_Waldinsamkeit
 * @create: 2020-09-23 22:41
 **/
public class OffByOne implements CharacterComparator {

    @Override
    public boolean equalChars(char x, char y) {
        if ( x - y == 1 || y - x== 1) {
            return true;
        }
        else {
            return false;
        }

    }
}
