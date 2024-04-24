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

    /**
     * Removes and returns the item at the front of the queue.
     *
     * @return the item at the front of the queue
     * @throws NoSuchElementException if the queue is empty
     */
    public T dequeue() {
        // Before removing the first item, checks if the queue is empty to avoid errors.
        // Throws NoSuchElementException if no elements can be dequeued.
        if (list.isEmpty()) {
            throw new NoSuchElementException("Queue is empty.");
        }
        // Removes and returns the first element of the list, which is the front of the queue.
        return list.removeFirst();
    }

    /**
     * Retrieves, but does not remove, the head of this queue.
     *
     * @return the head of the queue
     * @throws NoSuchElementException if the queue is empty
     */
    public T peek() {
        // Checks if the queue is empty before attempting to peek to prevent errors.
        if (list.isEmpty()) {
            throw new NoSuchElementException("Queue is empty.");
        }
        // Returns the first element without removing it, which is the front of the queue.
        return list.getFirst();
    }
