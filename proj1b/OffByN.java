/**
 * @program: proj1b
 * @description:
 * @author: Lingze_Waldinsamkeit
 * @create: 2020-09-23 22:41
 **/
public class OffByN implements CharacterComparator {
    private int N;
    public OffByN(int N){
        this.N = N;
    }

    @Override
    public boolean equalChars(char x, char y) {
        return x - y == this.N || y - x== this.N;

    }
}
