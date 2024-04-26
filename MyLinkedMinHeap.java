import java.util.NoSuchElementException;

/**
 * A MinHeap implementation using a doubly linked list to manage elements.
 * This is conceptually similar to a binary heap but uses a linear data structure.
 * Operations such as insertion and extraction have a higher time complexity compared to array-based heaps.
 *
 * @param <T> the type of elements held in this heap, must implement Comparable<T>
 */
public class MyLinkedMinHeap<T extends Comparable<T>> {
    private MyLinkedList<T> list; // Use MyLinkedList to hold heap elements

    /**
     * Constructor initializes an empty min heap.
     */
    public MyLinkedMinHeap() {
        this.list = new MyLinkedList<>(); // Create a new linked list for storing heap elements
    }
    /**
     * Adds an element to the heap. This implementation places the new element at the end
     * and then ensures the heap property by "bubbling up" the element as necessary.
     *
     * @param item the item to be added to the heap
     */
    public void add(T item) {
        if (isEmpty()) {
            list.addFirst(item); // Directly add to the list if it is currently empty
        } else {
            list.addLast(item); // Append the item to the end of the list
            int childIndex = list.size() - 1; // Get the index of the newly added item
            int parentIndex = parentOf(childIndex); // Calculate its parent index based on heap rules

            // Bubble up the newly added item to maintain the min heap property
            while (childIndex > 0 && list.get(parentIndex).compareTo(list.get(childIndex)) > 0) {
                swap(parentIndex, childIndex); // Swap if the parent is greater than the child
                childIndex = parentIndex; // Move up to the parent index
                parentIndex = parentOf(childIndex); // Calculate the new parent index
            }
        }
    }

    private void heapify(int index) {
        int left = leftChildOf(index);
        int right = rightChildOf(index);
        int smallest = index;

        if (left < list.size() && list.get(left) != null &&
                (list.get(smallest) == null || list.get(left).compareTo(list.get(smallest)) < 0)) {
            smallest = left;
        }

        if (right < list.size() && list.get(right) != null &&
                (list.get(smallest) == null || list.get(right).compareTo(list.get(smallest)) < 0)) {
            smallest = right;
        }

        if (smallest != index) {
            swap(index, smallest);
            heapify(smallest);
        }
    }

    private void swap(int index1, int index2) {
        if (index1 >= 0 && index1 < list.size() && index2 >= 0 && index2 < list.size()) {
            T temp = list.get(index1);
            list.set(index1, list.get(index2));
            list.set(index2, temp);
        }
    }


    public T extractMin() {
        if (isEmpty()) {
            throw new NoSuchElementException("Heap is empty.");
        }
        if (list.size() == 1) {
            return list.removeFirst();  // If only one element, remove and return it directly.
        }
        T min = list.getFirst();  // The minimum element is always at the front.

        // Replace the root with the last element
        T last = list.removeLast();  // Remove the last element
        list.set(0, last);  // Place the last element at the root

        // Only call heapify if the list is not empty after removing the last
        if (!isEmpty()) {
            heapify(0);  // Restore the min heap property from the root downwards
        }
        return min;  // Return the minimum element
    }

    /**
     * Calculates the index of the left child for a given parent index.
     *
     * @param index the index of the parent
     * @return the index of the left child
     */
    private int leftChildOf(int index) {
        return (2 * index) + 1; // Standard calculation for the left child in a heap
    }

    /**
     * Calculates the index of the right child for a given parent index.
     *
     * @param index the index of the parent
     * @return the index of the right child
     */
    private int rightChildOf(int index) {
        return (2 * index) + 2; // Standard calculation for the right child in a heap
    }

    /**
     * Calculates the index of the parent for a given child index.
     *
     * @param index the index of the child
     * @return the index of the parent
     */
    private int parentOf(int index) {
        return (index - 1) / 2; // Standard calculation for finding the parent in a heap
    }

    /**
     * Checks if the min heap is empty.
     *
     * @return true if the heap has no elements, false otherwise
     */
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * Returns the number of items in the min heap.
     *
     * @return the size of the heap
     */
    public int size() {
        return list.size();
    }
}


