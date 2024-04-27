import java.util.NoSuchElementException;

/**
 * A MinHeap implementation using MyArrayList to store elements generically.
 * This data structure provides efficient access to the smallest item at any time.
 *
 * @param <T> the type of elements in the heap, must be Comparable to determine ordering
 */
public class MyArrayMinHeap<T extends Comparable<T>> {
    private MyArrayList<T> elements;

    /**
     * Constructor initializes the MinHeap.
     */
    public MyArrayMinHeap() {
        elements = new MyArrayList<>();
    }

    /**
     * Checks if the heap is empty.
     *
     * return true if the heap has no elements, false otherwise
     */
    public boolean empty() {
        return elements.isEmpty();
    }

    /**
     * Returns the number of elements currently in the heap.
     *
     * return the size of the heap
     */
    public int size() {
        return elements.size();
    }

    /**
     * Retrieves the smallest element from the heap without removing it.
     *
     * return the smallest element of the heap
     * throws NoSuchElementException if the heap is empty
     */
    public T getMin() {
        if (empty()) throw new NoSuchElementException("Heap is empty");
        return elements.get(0);
    }

    /**
     * Inserts a new item into the heap.
     *
     * item the item to be added to the heap
     */
    public void insert(T item) {
        elements.add(item);
        traverseUp(elements.size() - 1);
    }

    /**
     * Removes and returns the minimum element from the heap.
     *
     * return the removed smallest element
     * throws NoSuchElementException if the heap is empty
     */
    public T extractMin() {
        if (empty()) throw new NoSuchElementException("Heap is empty");
        T min = elements.get(0);
        T lastItem = elements.remove(elements.size() - 1);
        if (!empty()) {
            elements.set(0, lastItem);
            heapify(0);
        }
        return min;
    }

    /**
     * Restores the heap property starting from a given index and moving downwards.
     *
     * index the starting index to begin heapify
     */
    private void heapify(int index) {
        int left = leftChildOf(index);
        int right = rightChildOf(index);
        int smallest = index;

        if (left < elements.size() && elements.get(left).compareTo(elements.get(smallest)) < 0) {
            smallest = left;
        }
        if (right < elements.size() && elements.get(right).compareTo(elements.get(smallest)) < 0) {
            smallest = right;
        }
        if (smallest != index) {
            swap(index, smallest);
            heapify(smallest);
        }
    }

    /**
     * Moves an element upwards in the heap until the heap property is restored.
     *
     * index the index of the element to move up
     */
    private void traverseUp(int index) {
        while (index != 0 && elements.get(parentOf(index)).compareTo(elements.get(index)) > 0) {
            swap(index, parentOf(index));
            index = parentOf(index);
        }
    }

    /**
     * Calculates the index of the left child for a given node index in a heap.
     *
     * @param index the index of the parent node
     * @return the index of the left child node
     */
    private int leftChildOf(int index) {
        return 2 * index + 1;
    }

    /**
     * Calculates the index of the right child for a given node index in a heap.
     *
     * @param index the index of the parent node
     * @return the index of the right child node
     */
    private int rightChildOf(int index) {
        return 2 * index + 2;
    }

    /**
     * Calculates the index of the parent for a given node index in a heap.
     *
     * @param index the index of the child node
     * @return the index of the parent node
     */
    private int parentOf(int index) {
        return (index - 1) / 2;
    }

    /**
     * Swaps two elements in the underlying MyArrayList by their indices.
     *
     * index1 the index of the first element to swap
     * index2 the index of the second element to swap
     */
    private void swap(int index1, int index2) {
        T temp = elements.get(index1);
        elements.set(index1, elements.get(index2));
        elements.set(index2, temp);
    }
}