import java.util.NoSuchElementException;

/**
 * A MinHeap implementation using MyArrayList to store elements generically.
 * This data structure provides efficient access to the smallest item at any time.
 *
 * @param <T> the type of elements in the heap, must be Comparable to determine ordering
 */
public class MyArrayMinHeap<T extends Comparable<T>> {
    private MyArrayList<T> elements; // The underlying list that stores heap elements

    /**
     * Constructor initializes the MinHeap.
     */
    public MyArrayMinHeap() {
        elements = new MyArrayList<>(); // Create a new empty MyArrayList
    }

    /**
     * Checks if the heap is empty.
     *
     * return true if the heap has no elements, false otherwise
     */
    public boolean empty() {
        return elements.isEmpty(); // Delegate to the isEmpty method of MyArrayList
    }

    /**
     * Returns the number of elements currently in the heap.
     *
     * return the size of the heap
     */
    public int size() {
        return elements.size(); // Delegate to the size method of MyArrayList
    }

    /**
     * Retrieves the smallest element from the heap without removing it.
     *
     * return the smallest element of the heap
     * throws NoSuchElementException if the heap is empty
     */
