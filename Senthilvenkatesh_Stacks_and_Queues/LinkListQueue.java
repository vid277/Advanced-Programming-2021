import java.util.LinkedList;

/**
 * This class provides the utility methods to perform various functions of a queue
 * @param <T> The type of queue that has to be created
 */
public class LinkListQueue <T> implements Queue<T>{

    public LinkedList<T> list;

    public LinkListQueue(){
        list = new LinkedList<T>();
    }

    @Override
    public void enqueue(T value) {
        list.addLast(value);
    }

    @Override
    public void dequeue() {
        list.removeFirst();
    }

    public T peek() {
        return list.getFirst();
    }

    @Override
    public boolean isEmpty() {
        return list.size() == 0;
    }

    @Override
    public int size() {
        return list.size();
    }
}


