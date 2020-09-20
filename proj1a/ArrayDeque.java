/**
 * @program: proj1a
 * @description:
 * @author: Lingze_Waldinsamkeit
 * @create: 2020-09-17 16:40
 **/
public class ArrayDeque< T > {

    private T[] items;
    private int nextFirst;
    private int nextLast;
    private int START_SIZE = 8;
//    private int REMOVAL_SIZE=

    public ArrayDeque() {
        items=(T []) new Object[START_SIZE];
        nextFirst = items.length - 1;
        nextLast = 0;
    }

    private void resize(int capacity) {
//        T[] new_items=(T []) new Object[capacity];
//        System.arraycopy(items,0,new_items,0,items.length);
//        int last_nextFirst=nextFirst;
//        nextFirst=capacity-items.length+nextLast;
//        System.arraycopy(items,last_nextFirst,new_items,nextFirst,items.length-nextLast);
//        items=new_items;
        int size = this.size();
        T[] new_items=(T []) new Object[capacity];
        if (nextFirst<nextLast){
            System.arraycopy(items,nextFirst + 1,new_items,0,nextLast - nextFirst - 1);
        }
        else {
            System.arraycopy(items,nextFirst + 1,new_items,0,items.length - nextFirst - 1);
            System.arraycopy(items,0,new_items,items.length - nextFirst - 2,nextLast);
        }
        items = new_items;
        nextFirst = items.length - 1;
        nextLast = size;
    }

    public void addFirst(T item) {
        if(nextLast == nextFirst){
            int c = items.length*2;
            resize(c);
        }
        items[nextFirst] = item;
        nextFirst = (nextFirst-1+items.length) % items.length;
    }

    public void addLast(T item) {
        if (nextLast == nextFirst) {
            int c = items.length*2;
            resize(c);
        }
        items[nextLast] = item;
        nextLast = (nextLast+1)%items.length;
    }

    public boolean isEmpty() {
        if((nextLast-nextFirst+items.length)%items.length == 1)
            return true;
        else
            return false;
    }

    public int size() {
        if(nextFirst >= nextLast) return nextLast+ items.length-nextFirst-1;
        else return nextLast-nextFirst-1;
    }

    public void printDeque() {
        int i = nextFirst + 1;
        for(;i!=nextLast;i++){
            if (i >= items.length) i = i % items.length;
            System.out.print(items[i]);
            System.out.print(" ");
        }
    }

    public T removeFirst() {
        if (this.isEmpty()) {
            return null;
        }
        nextFirst = (nextFirst+1) % items.length;
        if(this.size()<items.length/2-2 && items.length>START_SIZE){
            this.resize(items.length/2);
        }
        return items[nextFirst];
    }

    public T removeLast() {
        if (this.isEmpty()) {
            return null;
        }
        nextLast=(nextLast-1+items.length)%items.length;
        if (this.size()<items.length/2-2 && items.length>START_SIZE) {
            this.resize(items.length/2);
        }
        return items[nextLast];
    }

    public T get(int index) {
        int i = (nextFirst+index)%items.length;
        return items[i];
    }

//    public static void main(String [] args){
//        System.out.print(-1%8);
//    }

}
