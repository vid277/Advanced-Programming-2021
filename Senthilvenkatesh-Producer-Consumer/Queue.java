/**
 * This is the interface to implement a queue
 * @param <T> the type of elements that the queue has to hold
 * @author Vidyoot Senthilvenkatesh
 * @date 5/7/2022
 */
public interface Queue<T> {
    void enqueue(T value) throws InterruptedException;
    T dequeue() throws InterruptedException;
    T peek();
    boolean isEmpty();
    int size();
}

