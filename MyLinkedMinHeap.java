import java.util.NoSuchElementException;

/**
 * A MinHeap implementation using a doubly linked list to manage elements.
 * This is conceptually similar to a binary heap but uses a linear data structure.
 * Operations such as insertion and extraction have a higher time complexity compared to array-based heaps.
 *
 * @param <T> the type of elements held in this heap, must implement Comparable<T>
 */
public class MyLinkedMinHeap<T extends Comparable<T>> {
    private MyLinkedList<T> list;

    /**
     * Constructor initializes an empty min heap.
     */
    public MyLinkedMinHeap() {
        this.list = new MyLinkedList<>();
    }
    /**
     * Adds an element to the heap. This implementation places the new element at the end
     * and then ensures the heap property by "bubbling up" the element as necessary.
     *
     * @param item the item to be added to the heap
     */
    public void add(T item) {
        if (isEmpty()) {
            list.addFirst(item);
        } else {
            list.addLast(item);
            int childIndex = list.size() - 1;
            int parentIndex = parentOf(childIndex);

            while (childIndex > 0 && list.get(parentIndex).compareTo(list.get(childIndex)) > 0) {
                swap(parentIndex, childIndex);
                childIndex = parentIndex;
                parentIndex = parentOf(childIndex);
            }
        }
    }

    /**
     * Restores the heap property starting from a given index and moving downwards.
     * It compares the current node with its children and swaps with the smallest if needed,
     * recursively ensuring the smallest element moves up the heap structure.
     *
     * @param index the index from where the heap property needs to be restored
     */
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

    /**
     * Swaps two elements in the list at specified indices.
     *
     * @param index1 the index of the first element to swap
     * @param index2 the index of the second element to swap
     */
    private void swap(int index1, int index2) {
        if (index1 >= 0 && index1 < list.size() && index2 >= 0 && index2 < list.size()) {
            T temp = list.get(index1);
            list.set(index1, list.get(index2));
            list.set(index2, temp);
        }
    }

    /**
     * Extracts and returns the minimum element from the heap. The minimum element
     * is always at the root of the heap, which is the first element of the list.
     * After removal, the last element is placed at the root and the heap property is restored.
     *
     * @return the smallest element from the heap
     * @throws NoSuchElementException if the heap is empty
     */
    public T extractMin() {
        if (isEmpty()) {
            throw new NoSuchElementException("Heap is empty.");
        }
        if (list.size() == 1) {
            return list.removeFirst();
        }
        T min = list.getFirst();


        T last = list.removeLast();
        list.set(0, last);

        if (!isEmpty()) {
            heapify(0);
        }
        return min;
    }

    /**
     * Calculates the index of the left child for a given parent index.
     *
     * @param index the index of the parent
     * @return the index of the left child
     */
    private int leftChildOf(int index) {
        return (2 * index) + 1;
    }

    /**
     * Calculates the index of the right child for a given parent index.
     *
     * @param index the index of the parent
     * @return the index of the right child
     */
    private int rightChildOf(int index) {
        return (2 * index) + 2;
    }

    /**
     * Calculates the index of the parent for a given child index.
     *
     * @param index the index of the child
     * @return the index of the parent
     */
    private int parentOf(int index) {
        return (index - 1) / 2;
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


