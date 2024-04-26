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
    public T getMin() {
        if (empty()) throw new NoSuchElementException("Heap is empty"); // Check if empty before accessing
        return elements.get(0); // The root element is always at index 0
    }

    /**
     * Inserts a new item into the heap.
     *
     * item the item to be added to the heap
     */
    public void insert(T item) {
        elements.add(item); // Add the item at the end of the list
        traverseUp(elements.size() - 1); // Restore the heap order from the added item upwards
    }

    /**
     * Removes and returns the minimum element from the heap.
     *
     * return the removed smallest element
     * throws NoSuchElementException if the heap is empty
     */
    public T extractMin() {
        if (empty()) throw new NoSuchElementException("Heap is empty"); // Ensure the heap is not empty
        T min = elements.get(0); // The root element, which is the smallest
        T lastItem = elements.remove(elements.size() - 1); // Remove the last item
        if (!empty()) {
            elements.set(0, lastItem); // Replace the root with the last item
            heapify(0); // Restore heap order from the root down
        }
        return min;
    }

    /**
     * Restores the heap property starting from a given index and moving downwards.
     *
     * index the starting index to begin heapify
     */
