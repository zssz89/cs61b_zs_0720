public class ArrayDeque <S> implements Deque<S> {
    private S[] array;
    private int nextFirst;
    private int nextLast;
    private int size;

    /*constructor, starting with array size 8*/
    public ArrayDeque(){
        array = (S[]) new Object[8];
        size = 0;
        nextFirst = 0;
        nextLast = 1;
    }
    @Override
    public int size() {
        return size;
    }

    /*the front pointer should loop back around to the end of the array (so the new front item in the deque will be the last item in the underlying array).  */
    @Override
    public void addFirst(S item){
        array[nextFirst] = item;
        if(nextFirst == 0) {
            nextFirst = array.length - 1;
        }else{
            nextFirst --;
        }
        if(size == array.length) {
            resize(2 * size);
        }
        size ++;
    }
    @Override
    public void addLast(S item){
        array[nextLast] = item;
        nextLast = (nextLast + 1) % (array.length);
        size ++;
        if(size == array.length) {
            resize(2 * size);
        }
        size ++;
    }
    @Override
    public S removeFirst(){
        if(isSparse()){
            downsize();
        }
        nextFirst = (nextFirst + 1) % (array.length);
        S toRemove = array[nextFirst];
        array[nextFirst] = null;
        if(!isEmpty()){
            size--;
        }
        return toRemove;
    }
    @Override
    public S removeLast(){
        if(isSparse()){
            downsize();
        }
        nextLast = (nextLast - 1 + array.length) % (array.length);
        S toRemove = array[nextFirst];
        array[nextFirst] = null;
        if(!isEmpty()){
            size--;
        }
        return toRemove;
    }
    @Override
    public S get(int index){
        if(index >= size){
            return null;
        }
        int startp = (nextFirst + 1) % (array.length);
        return array[(startp + index)%(array.length)];
    }
    @Override
    public void printDeque(){
        for(int i = (nextFirst + 1) % (array.length); i != nextLast; i = (i + 1) % (array.length)){
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    @Override
    public boolean isEmpty(){
        return size == 0;
    }


    private boolean isSparse(){
        return array.length >= 16 && size< (array.length/4);
    }
    private void downsize(){
        resize(array.length/2);
    }

    public void resize(int newCap){
        S[] newArray = (S[]) new Object[newCap];
        System.arraycopy(array,0,newArray,0,size );
        array = newArray;
        nextFirst = array.length - 1;
        nextLast = size;
    }

}
