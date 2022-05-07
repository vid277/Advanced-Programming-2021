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
     * @param value the value to add to the end of the list
     */
    @Override
    public void enqueue(T value) {
        list.addLast(value);
    }

    /**
     * Removes the first value in the list
     */
    @Override
    public void dequeue() {
        list.removeFirst();
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


