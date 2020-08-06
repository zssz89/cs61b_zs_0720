/** Linked list version of Deque. */

public class LinkedListDeque <S> implements Deque<S> {
    /**Node class**/
    private class Node {
        public Node prev;
        public Node next;
        public S item;

        public Node (S i, Node p, Node n) {
            prev = p;
            next = n;
            item = i;
        }
    }

    private Node sentinel;
    private int size;

    /**Constructor **/
    public LinkedListDeque(){
        sentinel = new Node(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }
    @Override
    public boolean isEmpty(){
        return size == 0;
    }
    @Override
    public int size(){
        return size;
    }
    @Override
    public void addFirst(S item) {
        Node firstnode = new Node(item, sentinel, sentinel.next);
        sentinel.next.prev = firstnode;
        sentinel.next = firstnode;
        size += 1;

    }
    @Override
    public void addLast(S item){
        Node lastnode = new Node(item, sentinel.prev, sentinel);
        sentinel.prev.next = lastnode;
        sentinel.prev = lastnode;
        size +=1;
    }
    @Override
    public S removeFirst(){
        S removeditem = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        if(!isEmpty()){
            size -=1;
        }
        return removeditem;
    }
    @Override
    public S removeLast(){
        S removeditem = sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        if(!isEmpty()){
            size -=1;
        }
        return removeditem;
    }
    @Override
    public S get(int index){
        Node toGet = sentinel.next;
        for (int i =0; i < index; i++){
            toGet = toGet.next;
        }
        return toGet.item;
    }

    private   S getRecursiveHelper(int index, Node current){
        if (index == 0){
            return current.item;
        }
        return getRecursiveHelper(index-1, current.next);
    }

    public S getRecursive(int index){
        return getRecursiveHelper(index, sentinel.next);
    }

    @Override
    public void printDeque(){
        Node toPrint = sentinel.next;
        for (int i = 0; i < size; i++){
            System.out.print(toPrint.item + " ");
            toPrint = toPrint.next;
        }
        System.out.println();
    }



}