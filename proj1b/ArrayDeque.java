
/**
 * @program: proj1a
 * @description:
 * @author: Lingze_Waldinsamkeit
 * @create: 2020-09-17 16:40
 **/
public class ArrayDeque<T> implements Deque<T> {

    private T[] items;
    private int nextFirst;
    private int nextLast;
    private int START_SIZE = 8;
//    private int REMOVAL_SIZE=

    public ArrayDeque() {
        items = (T []) new Object[START_SIZE];
        nextFirst = items.length - 1;
        nextLast = 0;
    }

    private void resize(int capacity) {
//        T[] new_items=(T []) new Object[capacity];

        int size = this.size();
        T[] new_items = (T []) new Object[capacity];
        if (nextFirst<nextLast){
            System.arraycopy(items,nextFirst + 1, new_items, 0, nextLast - nextFirst - 1);
            items = new_items;
            nextFirst = items.length - 1;
            nextLast = size;
        }
        else {
            System.arraycopy(items, 0, new_items, 0, nextLast);
            int last_nextFirst = nextFirst;
            nextFirst = capacity - (items.length - nextFirst);
            System.arraycopy(items, last_nextFirst, new_items, nextFirst,items.length - last_nextFirst);
            items = new_items;
        }

    }

    @Override
    public void addFirst(T item) {
        if(nextLast == nextFirst){
            int c = items.length * 2;
            resize(c);
        }
        items[nextFirst] = item;
        nextFirst = (nextFirst-1+items.length) % items.length;
    }

    @Override
    public void addLast(T item) {
        if (nextLast == nextFirst) {
            int c = items.length * 2;
            resize(c);
        }
        items[nextLast] = item;
        nextLast = (nextLast + 1) % items.length;
    }

    @Override
    public boolean isEmpty() {
        if((nextLast - nextFirst + items.length) % items.length == 1)
            return true;
        else
            return false;
    }

    @Override
    public int size() {
        if(nextFirst >= nextLast) return nextLast + items.length - nextFirst - 1;
        else return nextLast - nextFirst - 1;
    }

    @Override
    public void printDeque() {
        int i = nextFirst + 1;
        for(; i!=nextLast; i++){
            if (i >= items.length) i = i % items.length;
            System.out.print(items[i]);
            System.out.print(" ");
        }
    }

    @Override
    public T removeFirst() {
        if (this.isEmpty()) {
            return null;
        }
        nextFirst = (nextFirst+1) % items.length;
        T ans = items[nextFirst];
        if(this.size() < items.length / 2 - 2 && items.length / 2 >= START_SIZE) {
            this.resize(items.length / 2);
        }
        return ans;
    }

    @Override
    public T removeLast() {
        if (this.isEmpty()) {
            return null;
        }
        nextLast = (nextLast - 1 + items.length) % items.length;
        T ans = items[nextLast];
        if (this.size() < items.length / 2 - 2 && items.length / 2 >= START_SIZE) {
            this.resize(items.length / 2);
        }
        return ans;
    }

    @Override
    public T get(int index) {
        if(index < this.size() && index >= 0) {
            int i = (nextFirst + index + 1) % items.length;
            return items[i];
        }
        else {
            return null;
        }
    }

//    public static void main(String [] args){
//        System.out.print(-1%8);
//    }

}
