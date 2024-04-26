import java.util.NoSuchElementException;

/**
 * A generic queue implementation using a linked list to manage elements.
 * This queue adheres to the First In, First Out (FIFO) principle.
 *
 * @param <T> the type of elements held in this queue
 */
public class MyLinkedQueue<T> {
    private Node<T> head; // Head node of the queue, where elements are dequeued from
    private Node<T> tail; // Tail node of the queue, where elements are enqueued
    private int size; // Number of elements in the queue

    /**
     * Inner static class representing a node in the linked list.
     * Each node stores a reference to an element and the next node in the queue.
     */
    private static class Node<T> {
        T element; // The element stored in this node
        Node<T> next; // Reference to the next node in the queue

        // Constructor to initialize the node with an element and the next node reference
        Node(T element, Node<T> next) {
            this.element = element;
            this.next = next;
        }
    }

    /**
     * Constructor to initialize an empty queue.
     */
    public MyLinkedQueue() {
        this.head = null; // Initialize the head of the queue as null
        this.tail = null; // Initialize the tail of the queue as null
        this.size = 0;   // Initialize the size of the queue as 0
    }

    /**
     * Enqueues an item to the back of the queue.
     *
     * @param item the item to be added to the queue
     */
    public void enqueue(T item) {
        Node<T> newNode = new Node<>(item, null); // Create a new node for the item
        if (tail == null) {
            head = tail = newNode; // If the queue is empty, head and tail point to the new node
        } else {
            tail.next = newNode; // Link the new node at the end of the queue
            tail = newNode; // Update the tail to the new node
        }
        size++; // Increment the size of the queue
    }

    /**
     * Dequeues the item at the front of the queue and returns it.
     *
     * @return the item at the front of the queue
     * @throws NoSuchElementException if the queue is empty
     */
    public T dequeue() {
        if (head == null) { // Check if the queue is empty
            throw new NoSuchElementException("Queue is empty.");
        }
        T item = head.element; // Retrieve the element from the head node
        head = head.next; // Move the head to the next node in the queue
        if (head == null) {
            tail = null; // If the queue is now empty, tail must also be null
        }
        size--; // Decrement the size of the queue
        return item; // Return the dequeued item
    }

    /**
     * Returns the item at the front of the queue without removing it.
     *
     * @return the item at the front of the queue
     * @throws NoSuchElementException if the queue is empty
     */
    public T peek() {
        if (head == null) { // Check if the queue is empty
            throw new NoSuchElementException("Queue is empty.");
        }
        return head.element; // Return the element from the head node
    }

    /**
     * Returns the number of elements in the queue.
     *
     * @return the size of the queue
     */
    public int size() {
        return size; // Return the size of the queue
    }

    /**
     * Checks if the queue is empty.
     *
     * @return true if the queue has no elements, false otherwise
     */
    public boolean isEmpty() {
        return size == 0; // Return true if the size is 0, indicating the queue is empty
    }
}
