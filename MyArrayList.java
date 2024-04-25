import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyArrayList<T> implements MyList<T> {
    // Array to hold the list's elements
    private Object[] elements;
    // The current number of elements in the list
    private int size;

    // Constructor initializes the list with an initial capacity
    public MyArrayList() {
        elements = new Object[10];
        size = 0;
    }

    // Ensure enough space in the array to add more elements
    private void ensureCapacity() {
        // If the current size equals the length of the array, increase capacity
        if (size >= elements.length) {
            // Double the size of the array when expanding
            Object[] newElements = new Object[size * 2];
            // Copy existing elements into the new array
            System.arraycopy(elements, 0, newElements, 0, size);
            elements = newElements;
        }
    }

    // Add an element to the end of the list
    @Override
    public void add(T item) {
        ensureCapacity();  // Check and increase capacity if necessary
        elements[size++] = item;  // Add the item and increment the size
    }

    // Get an element at a specific index
    @SuppressWarnings("unchecked")
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return (T) elements[index];
    }

    // Set an element at a specific index
    public void set(int index, T item) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        elements[index] = item;
    }

    // Add an element at a specific index
    public void add(int index, T item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        ensureCapacity();  // Make sure there's enough space
        // Shift elements to the right to make space for the new element
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = item;
        size++; // number of actual elements in array
    }

    // Add an element at the start of the list
    public void addFirst(T item) {
        add(0, item);
    }

    // Add an element at the end of the list
    public void addLast(T item) {
        add(size, item);
    }

    // Get the first element of the list
    public T getFirst() {
        return get(0);
    }

    // Get the last element of the list
    public T getLast() {
        return get(size - 1);
    }

    // Remove an element at a specific index
    public T remove(int index) {
        T item = get(index);
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            // Shift elements to the left to fill the gap
            System.arraycopy(elements, index + 1, elements, index, numMoved);
        }
        elements[--size] = null; // Clear to let GC do its work and decrement size
        return item;
    }

    // Remove the first element of the list
    public T removeFirst() {
        return remove(0);
    }

    // Remove the last element of the list
    public T removeLast() {
        return remove(size - 1);
    }

    // Clear the list
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    // Return the number of elements in the list
    public int size() {
        return size;
    }

    // Check if the list is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Find the index of the first occurrence of an object
    public int indexOf(Object object) {
        for (int i = 0; i < size; i++)
            if (object.equals(elements[i]))
                return i;
        return -1;
    }

    // Find the index of the last occurrence of an object
    public int lastIndexOf(Object object) {
        for (int i = size - 1; i >= 0; i--)
            if (object.equals(elements[i]))
                return i;
        return -1;
    }

    // Check if the list contains a certain object
    public boolean exists(Object object) {
        return indexOf(object) >= 0;
    }

    // Convert the list to an array
    public Object[] toArray() {
        return Arrays.copyOf(elements, size);
    }

    // Sort the list using a simple bubble sort algorithm
    public void sort() {
        boolean sorted;
        do {
            sorted = true;
            for (int i = 0; i < size - 1; i++) {
                Comparable<T> ci = (Comparable<T>) elements[i];
                if (ci.compareTo((T) elements[i + 1]) > 0) {
                    Object temp = elements[i];
                    elements[i] = elements[i + 1];
                    elements[i + 1] = temp;
                    sorted = false;
                }
            }
        } while (!sorted);
    }

    // Provide an iterator for the MyArrayList
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < size;
            }

            @Override
            @SuppressWarnings("unchecked")
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (T) elements[currentIndex++];
            }
        };
    }
}

/*************** Stack *******************/

//// MyStack class definition with a generic type T
//public class MyArrayStack<T> {
//    // Private member variable to hold the stack elements using MyArrayList
//    private MyArrayList<T> list;
//
//    // Constructor that initializes the stack by creating an instance of MyArrayList
//    public MyArrayStack() {
//        list = new MyArrayList<>();
//    }
//
//    // Method to add an item to the top of the stack
//    public void push(T item) {
//        // Adds the item to the end of the list which represents the top of the stack
//        list.addLast(item);
//    }
//
//    // Method to remove and return the top item from the stack
//    public T pop() {
//        // Checks if the stack is empty before attempting to remove an item
//        if (list.isEmpty()) {
//            // Throws NoSuchElementException if there are no items to pop
//            throw new NoSuchElementException("Stack is empty.");
//        }
//        // Removes the last item of the list which is the top of the stack
//        return list.removeLast();
//    }
//
//    // Method to retrieve, without removing, the top item of the stack
//    public T peek() {
//        // Checks if the stack is empty before attempting to peek at the top item
//        if (list.isEmpty()) {
//            // Throws NoSuchElementException if there are no items to peek
//            throw new NoSuchElementException("Stack is empty.");
//        }
//        // Returns the last item of the list without removing, which is the top of the stack
//        return list.getLast();
//    }
//
//    // Method to check if the stack is empty
//    public boolean isEmpty() {
//        // Returns true if the stack has no elements, otherwise false
//        return list.isEmpty();
//    }
//
//    // Method to get the number of items in the stack
//    public int size() {
//        // Returns the number of elements in the list, which corresponds to the stack's size
//        return list.size();
//    }
//}

/*************** Queue *******************/

/**
 * Class representing a generic queue data structure.
 * Uses MyArrayList to store the elements, providing FIFO (First-In-First-Out) queue behavior.
 *
 * @param <T> the type of elements held in this queue
 */
//public class MyArrayQueue<T> {
//    // The underlying list to store elements of the queue
//    private MyArrayList<T> list;
//
//    /**
//     * Constructor initializes the queue.
//     * It creates an instance of MyArrayList to use as the internal storage for the queue.
//     */
//    public MyArrayQueue() {
//        list = new MyArrayList<>();
//    }
//
//    /**
//     * Adds an item to the back of the queue.
//     *
//     * @param item the item to add to the queue
//     */
//    public void enqueue(T item) {
//        // Utilizes the addLast method of MyArrayList to add the item at the end of the list,
//        // which represents the back of the queue.
//        list.addLast(item);
//    }
//
//    /**
//     * Removes and returns the item at the front of the queue.
//     *
//     * @return the item at the front of the queue
//     * @throws NoSuchElementException if the queue is empty
//     */
//    public T dequeue() {
//        // Before removing the first item, checks if the queue is empty to avoid errors.
//        // Throws NoSuchElementException if no elements can be dequeued.
//        if (list.isEmpty()) {
//            throw new NoSuchElementException("Queue is empty.");
//        }
//        // Removes and returns the first element of the list, which is the front of the queue.
//        return list.removeFirst();
//    }
//
//    /**
//     * Retrieves, but does not remove, the head of this queue.
//     *
//     * @return the head of the queue
//     * @throws NoSuchElementException if the queue is empty
//     */
//    public T peek() {
//        // Checks if the queue is empty before attempting to peek to prevent errors.
//        if (list.isEmpty()) {
//            throw new NoSuchElementException("Queue is empty.");
//        }
//        // Returns the first element without removing it, which is the front of the queue.
//        return list.getFirst();
//    }
//
//    /**
//     * Checks if the queue is empty.
//     *
//     * @return true if the queue contains no elements, false otherwise
//     */
//    public boolean isEmpty() {
//        // Delegates the call to isEmpty of MyArrayList.
//        return list.isEmpty();
//    }
//
//    /**
//     * Returns the number of elements in this queue.
//     *
//     * @return the number of elements in this queue
//     */
//    public int size() {
//        // Returns the count of elements in the list, which represents the size of the queue.
//        return list.size();
//    }
//}

/*************** MinHeap *******************/

///**
// * A MinHeap implementation using MyArrayList to store elements generically.
// * This data structure provides efficient access to the smallest item at any time.
// *
// * @param <T> the type of elements in the heap, must be Comparable to determine ordering
// */
//public class MinHeapArray<T> {
//    private MyArrayList<T> elements; // The underlying list that stores heap elements
//
//    /**
//     * Constructor initializes the MinHeap.
//     */
//    public MinHeapArray() {
//        elements = new MyArrayList<>(); // Create a new empty MyArrayList
//    }
//
//    /**
//     * Checks if the heap is empty.
//     *
//     * return true if the heap has no elements, false otherwise
//     */
//    public boolean empty() {
//        return elements.isEmpty(); // Delegate to the isEmpty method of MyArrayList
//    }
//
//    /**
//     * Returns the number of elements currently in the heap.
//     *
//     * return the size of the heap
//     */
//    public int size() {
//        return elements.size(); // Delegate to the size method of MyArrayList
//    }
//
//    /**
//     * Retrieves the smallest element from the heap without removing it.
//     *
//     * return the smallest element of the heap
//     * throws NoSuchElementException if the heap is empty
//     */
//    public T getMin() {
//        if (empty()) throw new NoSuchElementException("Heap is empty"); // Check if empty before accessing
//        return elements.get(0); // The root element is always at index 0
//    }
//
//    /**
//     * Inserts a new item into the heap.
//     *
//     * item the item to be added to the heap
//     */
//    public void insert(T item) {
//        elements.add(item); // Add the item at the end of the list
//        traverseUp(elements.size() - 1); // Restore the heap order from the added item upwards
//    }
//
//    /**
//     * Removes and returns the minimum element from the heap.
//     *
//     * return the removed smallest element
//     * throws NoSuchElementException if the heap is empty
//     */
//    public T extractMin() {
//        if (empty()) throw new NoSuchElementException("Heap is empty"); // Ensure the heap is not empty
//        T min = elements.get(0); // The root element, which is the smallest
//        T lastItem = elements.remove(elements.size() - 1); // Remove the last item
//        if (!empty()) {
//            elements.set(0, lastItem); // Replace the root with the last item
//            heapify(0); // Restore heap order from the root down
//        }
//        return min;
//    }
//
//    /**
//     * Restores the heap property starting from a given index and moving downwards.
//     *
//     * index the starting index to begin heapify
//     */
//    private void heapify(int index) {
//        int left = leftChildOf(index); // Get left child index
//        int right = rightChildOf(index); // Get right child index
//        int smallest = index;
//
//        // Determine the smallest of the start, left, and right nodes
//        if (left < elements.size() && elements.get(left).compareTo(elements.get(smallest)) < 0) {
//            smallest = left;
//        }
//        if (right < elements.size() && elements.get(right).compareTo(elements.get(smallest)) < 0) {
//            smallest = right;
//        }
//        if (smallest != index) {
//            swap(index, smallest); // Swap if the smallest is not the start index
//            heapify(smallest); // Recursively heapify the affected subtree
//        }
//    }
//
//    /**
//     * Moves an element upwards in the heap until the heap property is restored.
//     *
//     * index the index of the element to move up
//     */
//    private void traverseUp(int index) {
//        while (index != 0 && elements.get(parentOf(index)).compareTo(elements.get(index)) > 0) {
//            swap(index, parentOf(index)); // Swap with parent if the current node is smaller than the parent
//            index = parentOf(index); // Move up to the parent's index
//        }
//    }
//
//    // Utility methods for computing the positions of parent and children in the array-based heap
//
//    private int leftChildOf(int index) {
//        return 2 * index + 1; // Index of the left child
//    }
//
//    private int rightChildOf(int index) {
//        return 2 * index + 2; // Index of the right child
//    }
//
//    private int parentOf(int index) {
//        return (index - 1) / 2; // Index of the parent
//    }
//
//    /**
//     * Swaps two elements in the underlying MyArrayList by their indices.
//     *
//     * index1 the index of the first element to swap
//     * index2 the index of the second element to swap
//     */
//    private void swap(int index1, int index2) {
//        T temp = elements.get(index1); // Temporary storage for the first element
//        elements.set(index1, elements.get(index2)); // Swap first with second
//        elements.set(index2, temp); // Set second with stored first
//    }
//}

