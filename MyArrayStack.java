import java.util.NoSuchElementException;

/**
 * Represents a stack data structure using an array list implementation.
 * This class encapsulates a generic stack where elements are pushed to and popped from the end of the list.
 *
 * @param <T> the type of elements held in this stack
 */
public class MyArrayStack<T> {
    private MyArrayList<T> list;

    /**
     * Constructs an empty stack.
     */
    public MyArrayStack() {
        list = new MyArrayList<>();
    }

    /**
     * Adds an element to the top of the stack.
     *
     * @param item the element to be added to the stack
     */
    public void push(T item) {
        list.addLast(item);
    }

    /**
     * Removes the element at the top of the stack and returns it.
     *
     * @return the element at the top of the stack
     * @throws NoSuchElementException if the stack is empty
     */
    public T pop() {
        if (list.isEmpty()) {
            throw new NoSuchElementException("Stack is empty.");
        }
        return list.removeLast();
    }
    /**
     * Retrieves, but does not remove, the top element of this stack.
     *
     * @return the element at the top of the stack
     * @throws NoSuchElementException if the stack is empty
     */
    public T peek() {
        if (list.isEmpty()) {
            throw new NoSuchElementException("Stack is empty.");
        }
        return list.getLast();
    }

    /**
     * Returns {@code true} if this stack contains no elements.
     *
     * @return {@code true} if this stack is empty; {@code false} otherwise
     */
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * Returns the number of elements in this stack.
     *
     * @return the number of elements in this stack
     */
    public int size() {
        return list.size();
    }
}