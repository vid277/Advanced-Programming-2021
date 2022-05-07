public interface Queue<T> {
    public void enqueue(T value);
    public void dequeue();
    public T peek();
    public boolean isEmpty();
    public int size();
}
