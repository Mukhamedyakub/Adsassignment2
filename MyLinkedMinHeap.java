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

    public T extractMin() {
        if (isEmpty()) {
            throw new NoSuchElementException("Heap is empty.");
        }
        T min = list.getFirst();  // The minimum element is always at the front.
        if (list.size() == 1) {
            return list.removeFirst();  // If only one element, remove and return it directly.
        }

        // Replace the root with the last element
        T last = list.removeLast();  // Remove the last element
        list.set(0, last);  // Place the last element at the root

        // Only call heapify if the list is not empty after removing the last
        if (!isEmpty()) {
            heapify(0);  // Restore the min heap property from the root downwards
        }
        return min;  // Return the minimum element
    }

    private void heapify(int index) {
        int left = leftChildOf(index);  // Index of the left child
        int right = rightChildOf(index);  // Index of the right child
        int smallest = index;  // Start with the current index as the smallest

        // Check if left child is smaller than current smallest
        if (left < list.size() && list.get(left).compareTo(list.get(smallest)) < 0) {
            smallest = left;
        }

        // Check if right child is smaller than current smallest
        if (right < list.size() && list.get(right).compareTo(list.get(smallest)) < 0) {
            smallest = right;
        }

        // If the smallest is not the current index, swap and continue heapifying
        if (smallest != index) {
            swap(index, smallest);
            heapify(smallest);  // Recursively heapify at the new position of the smallest
        }
    }

