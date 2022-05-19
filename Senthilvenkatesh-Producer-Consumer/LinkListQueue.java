import java.util.LinkedList;

/**
 * This class provides the utility methods to perform various functions of a queue
 * @param <T> The type of queue that has to be created
 * @author Vidyoot Senthilvenkatesh
 * @date 5/7/2022
 */
public class LinkListQueue <T> implements Queue<T>{

    //The list to be created
    //Utilizes the java linked list library
    public LinkedList<T> list;

    /**
     * Instantiates a new linked list to perform the queue operations on
     */
    public LinkListQueue(){
        list = new LinkedList<T>();
    }

    /**
     * Adds a value on to the tail of the list
     * If the size of the list is greater than 10, the thread waits
     * else, the thread notifies all the other threads.
     * @param value the value to add to the end of the list
     */
    @Override
    public synchronized void enqueue(T value) throws InterruptedException {
        while (list.size() >= 10) {
            System.out.println("Producer is waiting");
            wait();
        }
        list.addLast(value);
        notifyAll();
    }

    /**
     * Removes the first value in the list
     * If the list is empty, the thread waits, else, the thread wakes up all the other threads and
     * removes the first item in the list.
     * @return the item that was last removed
     */
    @Override
    public synchronized T dequeue() throws InterruptedException {
        while (list.isEmpty()) {
            System.out.println("Consumer is waiting");
            wait();
        }
        T returnItem = list.removeFirst();
        notifyAll();
        return returnItem;
    }

    /**
     * Does not remove, but rather returns the first element of the list
     * @return the first element of the list
     */
    public T peek() {
        return list.getFirst();
    }

    /**
     * Checks whether the list is empty or not
     * @return true when the list is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return list.size() == 0;
    }

    /**
     * Returns the size of the list
     * @return the size of the list
     */
    @Override
    public int size() {
        return list.size();
    }
}


