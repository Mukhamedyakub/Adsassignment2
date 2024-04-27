import java.util.NoSuchElementException;

/**
 * A generic queue implementation using a linked list to manage elements.
 * This queue adheres to the First In, First Out (FIFO) principle.
 *
 * @param <T> the type of elements held in this queue
 */
public class MyLinkedQueue<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    /**
     * Inner static class representing a node in the linked list.
     * Each node stores a reference to an element and the next node in the queue.
     */
    private static class Node<T> {
        T element;
        Node<T> next;

        Node(T element, Node<T> next) {
            this.element = element;
            this.next = next;
        }
    }

    /**
     * Constructor to initialize an empty queue.
     */
    public MyLinkedQueue() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * Enqueues an item to the back of the queue.
     *
     * @param item the item to be added to the queue
     */
    public void enqueue(T item) {
        Node<T> newNode = new Node<>(item, null);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    /**
     * Dequeues the item at the front of the queue and returns it.
     *
     * @return the item at the front of the queue
     * @throws NoSuchElementException if the queue is empty
     */
    public T dequeue() {
        if (head == null) {
            throw new NoSuchElementException("Queue is empty.");
        }
        T item = head.element;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        return item;
    }

    /**
     * Returns the item at the front of the queue without removing it.
     *
     * @return the item at the front of the queue
     * @throws NoSuchElementException if the queue is empty
     */
    public T peek() {
        if (head == null) {
            throw new NoSuchElementException("Queue is empty.");
        }
        return head.element;
    }

    /**
     * Returns the number of elements in the queue.
     *
     * @return the size of the queue
     */
    public int size() {
        return size;
    }

    /**
     * Checks if the queue is empty.
     *
     * @return true if the queue has no elements, false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }
}
