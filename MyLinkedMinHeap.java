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


