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

    // Ensure that the swap method checks that the indices are valid and within the size of the list
    private void swap(int index1, int index2) {
        if (index1 >= 0 && index1 < list.size() && index2 >= 0 && index2 < list.size()) {
            T temp = list.get(index1);
            list.set(index1, list.get(index2));
            list.set(index2, temp);
        }
    }





//    /**
//     * Extracts and returns the minimum element from the heap, which is always at the root,
//     * in this case, the beginning of the list.
//     *
//     * @return the smallest element in the heap
//     * @throws NoSuchElementException if the heap is empty
//     */
//    public T extractMin() {
//        if (isEmpty()) {
//            throw new NoSuchElementException("Heap is empty."); // Ensure there are elements to extract
//        }
//        T min = list.getFirst(); // The minimum element is always at the front
//        T last = list.removeLast(); // Remove the last element to replace the root
//        if (!isEmpty()) {
//            list.set(0, last); // Place the last element at the root
//            heapify(0); // Restore the min heap property from the root downwards
//        }
//        return min; // Return the minimum element
//    }
//
//    /**
//     * Restores the min heap property from a given index downwards.
//     *
//     * @param index the index from where to begin the heapify process
//     */
//    private void heapify(int index) {
//        int left = leftChildOf(index); // Index of the left child
//        int right = rightChildOf(index); // Index of the right child
//        int smallest = index; // Assume the current node is the smallest
//
//        // Check if left child exists and is smaller than the current smallest
//        if (left < list.size() && list.get(left).compareTo(list.get(smallest)) < 0) {
//            smallest = left;
//        }
//        // Check if right child exists and is smaller than the current smallest
//        if (right < list.size() && list.get(right).compareTo(list.get(smallest)) < 0) {
//            smallest = right;
//        }
//        // If the smallest is not the current node, swap and continue heapifying
//        if (smallest != index) {
//            swap(index, smallest);
//            heapify(smallest);
//        }
//    }
//
//    /**
//     * Swaps elements at two indices in the linked list.
//     *
//     * @param index1 the index of the first element
//     * @param index2 the index of the second element
//     */
//    private void swap(int index1, int index2) {
//        T temp = list.get(index1); // Temporary store the first element
//        list.set(index1, list.get(index2)); // Set first element to the second
//        list.set(index2, temp); // Set second element to the temporary stored first
//    }


