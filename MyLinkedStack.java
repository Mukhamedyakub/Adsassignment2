import java.util.NoSuchElementException;

/**
 * A generic stack implementation using a linked list as the underlying storage mechanism.
 * This stack follows the Last In, First Out (LIFO) principle.
 *
 * @param <T> the type of elements held in this stack.
 */
public class MyLinkedStack<T> {
    private Node<T> top;
    private int size;

    /**
     * Represents a node in a linked list structure. Each node contains a generic element
     * and a reference to the next node in the list. This class is typically used to construct
     * data structures like stacks or queues where elements are linked sequentially.
     *
     * @param <T> The type of the element stored in the node.
     */
    private static class Node<T> {
        /**
         * The element contained in this node.
         */
        T element;

        /**
         * The reference to the next node in the list.
         */
        Node<T> next;

        /**
         * Constructs a new node with the specified element and next node reference.
         *
         * @param element The element to store in this node.
         * @param next The next node in the list.
         */
        Node(T element, Node<T> next) {
            this.element = element;
            this.next = next;
        }
    }

    /**
     * Constructor to initialize an empty stack.
     */
    public MyLinkedStack() {
        this.top = null;
        this.size = 0;
    }

    /**
     * Pushes an item onto the top of the stack.
     *
     * @param item the item to be pushed onto the stack
     */
    public void push(T item) {
        top = new Node<>(item, top);
        size++;
    }

    /**
     * Removes the item at the top of the stack and returns it.
     *
     * @return the item at the top of the stack
     * @throws NoSuchElementException if the stack is empty
     */
    public T pop() {
        if (top == null) {
            throw new NoSuchElementException("Stack is empty.");
        }
        T item = top.element;
        top = top.next;
        size--;
        return item;
    }

    /**
     * Returns the item at the top of the stack without removing it.
     *
     * @return the item at the top of the stack
     * @throws NoSuchElementException if the stack is empty
     */
    public T peek() {
        if (top == null) {
            throw new NoSuchElementException("Stack is empty.");
        }
        return top.element;
    }

    /**
     * Returns the number of elements in the stack.
     *
     * @return the size of the stack
     */
    public int size() {
        return size;
    }

    /**
     * Checks if the stack is empty.
     *
     * @return true if the stack has no elements, false otherwise
     */
    public boolean isEmpty() {
        return top == null;
    }
}
