/**
 * An interface defining the operations for a generic list structure. This interface
 * extends {@link Iterable}, allowing for iterating over its elements.
 *
 * @param <T> the type of elements in this list
 */
public interface MyList<T> extends Iterable<T> {

    /**
     * Adds an item to the end of the list.
     *
     * @param item the item to be added
     */
    void add(T item);

    /**
     * Sets the element at the specified position in this list.
     *
     * @param index index of the element to replace
     * @param item element to be stored at the specified position
     */
    void set(int index, T item);

    /**
     * Inserts the specified element at the specified position in this list.
     *
     * @param index index at which the specified element is to be inserted
     * @param item element to be inserted
     */
    void add(int index, T item);

    /**
     * Inserts the specified element at the beginning of this list.
     *
     * @param item the element to be added
     */
    void addFirst(T item);

    /**
     * Appends the specified element to the end of this list.
     *
     * @param item the element to be added
     */
    void addLast(T item);

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index index of the element to return
     * @return the element at the specified position in this list
     */
    T get(int index);

    /**
     * Returns the first element in this list.
     *
     * @return the first element in this list
     */
    T getFirst();

    /**
     * Returns the last element in this list.
     *
     * @return the last element in this list
     */
    T getLast();

    /**
     * Removes the element at the specified position in this list.
     *
     * @param index the index of the element to be removed
     * @return the element previously at the specified position
     */
    T remove(int index);

    /**
     * Removes and returns the first element from this list.
     *
     * @return the first element from this list
     */
    T removeFirst();

    /**
     * Removes and returns the last element from this list.
     *
     * @return the last element from this list
     */
    T removeLast();

    /**
     * Sorts this list according to the order induced by the natural ordering of its elements.
     */
    void sort();

    /**
     * Returns the index of the first occurrence of the specified element in this list,
     * or -1 if this list does not contain the element.
     *
     * @param object element to search for
     * @return the index of the first occurrence of the specified element in
     *         this list, or -1 if this list does not contain the element
     */
    int indexOf(Object object);

    /**
     * Returns the index of the last occurrence of the specified element in this list,
     * or -1 if this list does not contain the element.
     *
     * @param object element to search for
     * @return the index of the last occurrence of the specified element in
     *         this list, or -1 if this list does not contain the element
     */
    int lastIndexOf(Object object);

    /**
     * Returns {@code true} if this list contains the specified element.
     *
     * @param object element whose presence in this list is to be tested
     * @return {@code true} if this list contains the specified element
     */
    boolean exists(Object object);

    /**
     * Returns an array containing all of the elements in this list in proper sequence.
     *
     * @return an array containing all of the elements in this list in proper sequence
     */
    Object[] toArray();

    /**
     * Removes all of the elements from this list. The list will be empty after this call returns.
     */
    void clear();

    /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements in this list
     */
    int size();
}
