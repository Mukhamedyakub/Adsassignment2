import java.util.NoSuchElementException;

public class MyArrayQueue<T> {
    // The underlying list to store elements of the queue
    private MyArrayList<T> list;

    /**
     * Constructor initializes the queue.
     * It creates an instance of MyArrayList to use as the internal storage for the queue.
     */
    public MyArrayQueue() {
        list = new MyArrayList<>();
    }

    /**
     * Adds an item to the back of the queue.
     *
     * @param item the item to add to the queue
     */
    public void enqueue(T item) {
        list.addLast(item);
    }

    /**
     * Removes and returns the item at the front of the queue.
     *
     * @return the item at the front of the queue
     * @throws NoSuchElementException if the queue is empty
     */
    public T dequeue() {
        if (list.isEmpty()) {
            throw new NoSuchElementException("Queue is empty.");
        }
        return list.removeFirst();
    }

    /**
     * Retrieves, but does not remove, the head of this queue.
     *
     * @return the head of the queue
     * @throws NoSuchElementException if the queue is empty
     */
    public T peek() {
        if (list.isEmpty()) {
            throw new NoSuchElementException("Queue is empty.");
        }
        return list.getFirst();
    }

    /**
     * Checks if the queue is empty.
     *
     * @return true if the queue contains no elements, false otherwise
     */
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * Returns the number of elements in this queue.
     *
     * @return the number of elements in this queue
     */
    public int size() {
        return list.size();
    }
}