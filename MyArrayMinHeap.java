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
    private void heapify(int index) {
        int left = leftChildOf(index); // Get left child index
        int right = rightChildOf(index); // Get right child index
        int smallest = index;

        // Determine the smallest of the start, left, and right nodes
        if (left < elements.size() && elements.get(left).compareTo(elements.get(smallest)) < 0) {
            smallest = left;
        }
        if (right < elements.size() && elements.get(right).compareTo(elements.get(smallest)) < 0) {
            smallest = right;
        }
        if (smallest != index) {
            swap(index, smallest); // Swap if the smallest is not the start index
            heapify(smallest); // Recursively heapify the affected subtree
        }
    }

    /**
     * Moves an element upwards in the heap until the heap property is restored.
     *
     * index the index of the element to move up
     */
    private void traverseUp(int index) {
        while (index != 0 && elements.get(parentOf(index)).compareTo(elements.get(index)) > 0) {
            swap(index, parentOf(index)); // Swap with parent if the current node is smaller than the parent
            index = parentOf(index); // Move up to the parent's index
        }
    }

    // Utility methods for computing the positions of parent and children in the array-based heap

    private int leftChildOf(int index) {
        return 2 * index + 1; // Index of the left child
    }

    private int rightChildOf(int index) {
        return 2 * index + 2; // Index of the right child
    }

    private int parentOf(int index) {
        return (index - 1) / 2; // Index of the parent
    }

    /**
     * Swaps two elements in the underlying MyArrayList by their indices.
     *
     * index1 the index of the first element to swap
     * index2 the index of the second element to swap
     */
    private void swap(int index1, int index2) {
        T temp = elements.get(index1); // Temporary storage for the first element
        elements.set(index1, elements.get(index2)); // Swap first with second
        elements.set(index2, temp); // Set second with stored first
    }
}