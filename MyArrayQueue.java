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
        // Utilizes the addLast method of MyArrayList to add the item at the end of the list,
        // which represents the back of the queue.
        list.addLast(item);
    }
