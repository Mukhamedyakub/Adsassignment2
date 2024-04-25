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
    public MyLinkedStack() {
        this.top = null; // Initialize the top of the stack as null
        this.size = 0;   // Initialize the size of the stack as 0
    }

    /**
     * Pushes an item onto the top of the stack.
     *
     * @param item the item to be pushed onto the stack
     */
    public void push(T item) {
        // Create a new node with the item, making it the new top of the stack
        // The new node points to the previous top node
        top = new Node<>(item, top);
        size++; // Increment the size of the stack
    }

    /**
     * Removes the item at the top of the stack and returns it.
     *
     * @return the item at the top of the stack
     * @throws NoSuchElementException if the stack is empty
     */
    public T pop() {
        if (top == null) { // Check if the stack is empty
            throw new NoSuchElementException("Stack is empty.");
        }
        T item = top.element; // Get the item from the top of the stack
        top = top.next; // Remove the top node by moving the top reference to the next node
        size--; // Decrement the size of the stack
        return item; // Return the removed item
    }

    /**
     * Returns the item at the top of the stack without removing it.
     *
     * @return the item at the top of the stack
     * @throws NoSuchElementException if the stack is empty
     */
    public T peek() {
        if (top == null) { // Check if the stack is empty
            throw new NoSuchElementException("Stack is empty.");
        }
        return top.element; // Return the item from the top of the stack
    }

    /**
     * Returns the number of elements in the stack.
     *
     * @return the size of the stack
     */
    public int size() {
        return size; // Return the size of the stack
    }

    /**
     * Checks if the stack is empty.
     *
     * @return true if the stack has no elements, false otherwise
     */
    public boolean isEmpty() {
        return top == null; // Return true if the top is null, indicating the stack is empty
    }
}
