public interface Deque <S> {
    void addFirst(S item);
    void addLast(S item);
    int size();
    void printDeque();
    S removeFirst();
    S removeLast();
    S get(int index);
    default boolean isEmpty() {
        return size() == 0;
    }
}
