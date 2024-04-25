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
    
