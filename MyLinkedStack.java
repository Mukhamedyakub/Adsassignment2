import java.util.NoSuchElementException;

/**
 * A generic stack implementation using a linked list as the underlying storage mechanism.
 * This stack follows the Last In, First Out (LIFO) principle.
 *
 * @param <T> the type of elements held in this stack.
 */
public class MyLinkedStack<T> {
    private Node<T> top;  // The top node of the stack
    private int size;     // Number of elements in the stack

    /**
     * Inner static class representing a node in the stack.
     * Each node stores a reference to an element and the next node in the stack.
     */
    private static class Node<T> {
        T element;           // The element stored in this node
        Node<T> next;        // Reference to the next node in the stack

        // Constructor to initialize the node with an element and the next node reference
        Node(T element, Node<T> next) {
            this.element = element;
            this.next = next;
        }
    }

    /**
     * Constructor to initialize an empty stack.
     */
