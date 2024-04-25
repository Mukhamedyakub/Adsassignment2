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


