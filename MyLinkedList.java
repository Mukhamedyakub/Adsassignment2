import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A custom implementation of a doubly linked list.
 *
 * @param <T> the type of elements held in this list
 */
public class MyLinkedList<T> implements MyList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    /**
     * A node within the doubly linked list which holds a data element
     * and references to both the next and previous nodes in the list.
     */
    private static class Node<T> {
        T element;
        Node<T> next;
        Node<T> prev;

        /**
         * Constructs a new node with specified data, next node, and previous node.
         *
         * @param element the data element stored in this node
         * @param next the next node in the linked list
         * @param prev the previous node in the linked list
         */
        Node(T element, Node<T> next, Node<T> prev) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
    }

    /**
     * Constructs an empty linked list.
     */
    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Appends the specified element to the end of this list.
     *
     * @param item element to be appended to this list
     */
    public void add(T item) {
        addLast(item);
    }

    /**
     * Replaces the element at the specified position in this list with the specified element.
     *
     * @param index index of the element to replace
     * @param item element to be stored at the specified position
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public void set(int index, T item) {
        Node<T> node = getNode(index);
        if (node != null) {
            node.element = item;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * Inserts the specified element at the specified position in this list.
     *
     * @param index index at which the specified element is to be inserted
     * @param item element to be inserted
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public void add(int index, T item) {
        if (index == size) {
            addLast(item);
        } else {
            Node<T> current = getNode(index);
            Node<T> newNode = new Node<>(item, current, current.prev);
            if (current.prev != null) {
                current.prev.next = newNode;
            } else {
                head = newNode;
            }
            current.prev = newNode;
            size++;
        }
    }

    /**
     * Inserts the specified element at the beginning of this list.
     *
     * @param item element to be inserted at the beginning of this list
     */
    public void addFirst(T item) {
        Node<T> newNode = new Node<>(item, head, null);
        if (head != null) {
            head.prev = newNode;
        } else {
            tail = newNode;
        }
        head = newNode;
        size++;
    }

    /**
     * Appends the specified element to the end of this list.
     *
     * @param item element to be appended to this list
     */
    public void addLast(T item) {
        Node<T> newNode = new Node<>(item, null, tail);
        if (tail != null) {
            tail.next = newNode;
        } else {
            head = newNode;
        }
        tail = newNode;
        size++;
    }

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public T get(int index) {
        Node<T> node = getNode(index);
        if (node != null) {
            return node.element;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * Returns the first element in this list.
     *
     * @return the first element in this list
     * @throws NoSuchElementException if this list is empty
     */
    public T getFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        return head.element;
    }

    /**
     * Returns the last element in this list.
     *
     * @return the last element in this list
     * @throws NoSuchElementException if this list is empty
     */
    public T getLast() {
        if (tail == null) {
            throw new NoSuchElementException();
        }
        return tail.element;
    }

    /**
     * Removes the element at the specified position in this list.
     *
     * @param index the index of the element to be removed
     * @return the element that was removed from the list
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public T remove(int index) {
        Node<T> node = getNode(index);
        if (node != null) {
            if (node.prev != null) {
                node.prev.next = node.next;
            } else {
                head = node.next;
            }
            if (node.next != null) {
                node.next.prev = node.prev;
            } else {
                tail = node.prev;
            }
            size--;
            return node.element;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * Removes and returns the first element from this list.
     *
     * @return the first element from this list
     * @throws NoSuchElementException if this list is empty
     */
    public T removeFirst() {
        T removed_element = null;

        if (head != null) {
            removed_element = remove(0);
        } else {
            throw new NoSuchElementException();
        }
        return removed_element;
    }

    /**
     * Removes and returns the last element from this list.
     *
     * @return the last element from this list
     * @throws NoSuchElementException if this list is empty
     */
    public T removeLast() {
        T removed_element = null;
        if (tail != null) {
            removed_element = remove(size - 1);
        } else {
            throw new NoSuchElementException();
        }
        return removed_element;
    }

    /**
     * Sorts the elements of the list in ascending order.
     * Currently, this method does not implement any sorting logic
     * and serves as a placeholder for future implementations.
     */
    @Override
    public void sort() {

    }

    /**
     * Returns the index of the first occurrence of the specified element
     * in this list, or -1 if this list does not contain the element.
     *
     * @param object the element to search for
     * @return the index of the first occurrence of the specified element in
     *         this list, or -1 if this list does not contain the element
     */
    public int indexOf(Object object) {
        int index = 0;
        for (Node<T> x = head; x != null; x = x.next, index++) {
            if (object.equals(x.element)) {
                return index;
            }
        }
        return -1;
    }

    /**
     * Returns the index of the last occurrence of the specified element
     * in this list, or -1 if this list does not contain the element.
     *
     * @param object the element to search for
     * @return the index of the last occurrence of the specified element in
     *         this list, or -1 if this list does not contain the element
     */
    public int lastIndexOf(Object object) {
        int index = size;
        for (Node<T> x = tail; x != null; x = x.prev, index--) {
            if (object.equals(x.element)) {
                return index;
            }
        }
        return -1;
    }

    /**
     * Returns true if this list contains the specified element.
     *
     * @param object element whose presence in this list is to be tested
     * @return {@code true} if this list contains the specified element
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
        Object[] array = new Object[size];
        int i = 0;
        for (Node<T> x = head; x != null; x = x.next) {
            array[i++] = x.element;
        }
        return array;
    }

    /**
     * Removes all of the elements from this list.
     * The list will be empty after this call returns.
     */
    public void clear() {
        head = null;
        tail = null;
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
     * Returns {@code true} if this list contains no elements.
     *
     * @return {@code true} if this list contains no elements
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns a node at a specific index.
     *
     * @param index the index of the node to return
     * @return the node at the specified index
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    private Node<T> getNode(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> x;
        if (index < (size >> 1)) {
            x = head;
            for (int i = 0; i < index; i++) {
                x = x.next;
            }
        } else {
            x = tail;
            for (int i = size - 1; i > index; i--) {
                x = x.prev;
            }
        }
        return x;
    }

    /**
     * Returns an iterator over the elements in this list in proper sequence.
     *
     * @return an Iterator over the elements in this list in proper sequence
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> next = head;

            @Override
            public boolean hasNext() {
                return next != null;
            }

            @Override
            public T next() {
                if (!hasNext()) throw new NoSuchElementException();
                T element = next.element;
                next = next.next;
                return element;
            }
        };
    }
}
