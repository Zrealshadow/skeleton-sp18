/**
 * @program: proj1a
 * @description:
 * @author: Lingze_Waldinsamkeit
 * @create: 2020-09-17 15:18
 **/
public class LinkedListDeque<T> {
    private int size;

    private class OwnNode <T>{
        public T item;
        public OwnNode<T> next;
        public OwnNode<T> pri;
        public OwnNode(T v,OwnNode n,OwnNode p){
            item=v;
            next=n;
            pri=p;
        }
    }

    private OwnNode<T> sentinal;

    public LinkedListDeque(){
        sentinal= new OwnNode<>(null,null,null);
        sentinal.next=sentinal;
        sentinal.pri=sentinal;
        size=0;
    }
    public LinkedListDeque(T x){
        sentinal = new OwnNode<>(null,sentinal,sentinal);
        OwnNode<T> tmp= new OwnNode<>(x,sentinal.next,sentinal);
        sentinal.next=tmp;
        sentinal.pri=tmp;
    }

    public void addFirst(T item){
        OwnNode<T> tmp=new OwnNode<>(item,sentinal.next,sentinal);
        sentinal.next.pri=tmp;
        sentinal.next=tmp;
        size++;
    }

    public void addLast(T item){
        OwnNode<T> tmp=new OwnNode<>(item,sentinal,sentinal.pri);
        sentinal.pri.next=tmp;
        sentinal.pri=tmp;
        size++;
    }

    public boolean isEmpty(){
        if(size==0)return true;
        else return false;
    }

    public T removeFirst(){
        OwnNode<T> tmp=sentinal.next;
        tmp.next.pri=sentinal;
        sentinal.next=tmp.next;
        size--;
        return tmp.item;
    }

    public T removeLast(){
        OwnNode<T> tmp=sentinal.pri;
        tmp.pri.next=sentinal;
        sentinal.pri=tmp.pri;
        size--;
        return  tmp.item;

    }

    public T get(int index){
        int i=0;
        OwnNode<T> p=sentinal;
        while(i<=index){
            p=p.next;
            i++;
        }
        return p.item;
    }

    public void printDeque(){
        OwnNode<T> p=sentinal;
        while(p.next!=sentinal){
            System.out.print(p.next.item);
            System.out.print(" ");
            p=p.next;
        }
    }

    public int size(){
        return size;
    }

    private T getRecursive_helper(OwnNode<T> x, int index){
        if(index==0){
            return x.item;
        }
        return getRecursive_helper(x.next,index-1);
    }

    public T getRecursive(int index){
        OwnNode<T> p=sentinal.next;
        return getRecursive_helper(p,index);
    }
}
