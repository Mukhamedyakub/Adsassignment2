import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This class implements a simple ArrayList-like structure that manages a list of elements with dynamic resizing.
 * It provides basic functionalities like adding, removing, and accessing elements along with utilities
 * like sorting and converting to array.
 *
 * @param <T> The type of elements in this list
 */
public class MyArrayList<T> implements MyList<T> {
    private Object[] elements; // Array to store the list elements
    private int size;          // Current number of elements

    /**
     * Constructs an empty list with an initial capacity of ten.
     */
    public MyArrayList() {
        elements = new Object[10];
        size = 0;
    }

    /**
     * Ensures that the array has enough capacity to add more elements.
     * If not, the size of the array is doubled.
     */
    private void ensureCapacity() {
        if (size >= elements.length) {
            Object[] newElements = new Object[size * 2];
            System.arraycopy(elements, 0, newElements, 0, size);
            elements = newElements;
        }
    }

    /**
     * Adds an element to the end of this list.
     *
     * @param item the element to be added
     */
    @Override
    public void add(T item) {
        ensureCapacity();
        elements[size++] = item;
    }

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @SuppressWarnings("unchecked")
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return (T) elements[index];
    }

    /**
     * Replaces the element at the specified position in this list with the specified element.
     *
     * @param index index of the element to replace
     * @param item element to be stored at the specified position
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public void set(int index, T item) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        elements[index] = item;
    }

    /**
     * Inserts the specified element at the specified position in this list.
     * Shifts the element currently at that position (if any) and any subsequent elements to the right.
     *
     * @param index index at which the specified element is to be inserted
     * @param item element to be inserted
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public void add(int index, T item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        ensureCapacity();
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = item;
        size++;
    }

    /**
     * Adds an element to the beginning of this list.
     *
     * @param item the element to be added to the start of this list
     */
    public void addFirst(T item) {
        add(0, item);
    }

    /**
     * Adds an element to the end of this list.
     *
     * @param item the element to be added to the end of this list
     */
    public void addLast(T item) {
        add(size, item);
    }

    /**
     * Returns the first element in this list.
     *
     * @return the first element in this list
     * @throws NoSuchElementException if this list is empty
     */
    public T getFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return get(0);
    }

    /**
     * Returns the last element in this list.
     *
     * @return the last element in this list
     * @throws NoSuchElementException if this list is empty
     */
    public T getLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return get(size - 1);
    }

    /**
     * Removes the element at the specified position in this list.
     *
     * @param index the index of the element to be removed
     * @return the element that was removed from the list
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public T remove(int index) {
        T item = get(index);
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(elements, index + 1, elements, index, numMoved);
        }
        elements[--size] = null; // clear to let GC do its work
        return item;
    }

    /**
     * Removes the first element from this list.
     *
     * @return the first element from this list
     * @throws NoSuchElementException if this list is empty
     */
    public T removeFirst() {
        return remove(0);
    }

    /**
     * Removes the last element from this list.
     *
     * @return the last element from this list
     * @throws NoSuchElementException if this list is empty
     */
    public T removeLast() {
        return remove(size - 1);
    }

    /**
     * Removes all of the elements from this list.
     */
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements in this list
     */
    public int size() {
        return size;
    }

    /**
     * Returns true if this list contains no elements.
     *
     * @return true if this list contains no elements
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns the index of the first occurrence of the specified element
     * in this list, or -1 if this list does not contain the element.
     *
     * @param object element to search for
     * @return the index of the first occurrence of the specified element in
     *         this list, or -1 if this list does not contain the element
     */
    public int indexOf(Object object) {
        for (int i = 0; i < size; i++) {
            if (object.equals(elements[i])) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Returns the index of the last occurrence of the specified element
     * in this list, or -1 if this list does not contain the element.
     *
     * @param object element to search for
     * @return the index of the last occurrence of the specified element in
     *         this list, or -1 if this list does not contain the element
     */
    public int lastIndexOf(Object object) {
        for (int i = size - 1; i >= 0; i--) {
            if (object.equals(elements[i])) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Returns true if this list contains the specified element.
     *
     * @param object element whose presence in this list is to be tested
     * @return true if this list contains the specified element
     */
    public boolean exists(Object object) {
        return indexOf(object) >= 0;
    }

    /**
     * Returns an array containing all of the elements in this list in proper sequence (from first to last element).
     *
     * @return an array containing all of the elements in this list in proper sequence
     */
    public Object[] toArray() {
        return Arrays.copyOf(elements, size);
    }

    /**
     * Sorts this list according to the natural ordering of its elements.
     * All elements in the list must implement the Comparable interface.
     */
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

    /**
     * Returns an iterator over the elements in this list in proper sequence.
     *
     * @return an Iterator over the elements in this list in proper sequence
     */
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
