import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList <T> implements MyList<T> {
    // Define the head and tail nodes of the linked list, and keep track of the size
    private Node<T> head; // Head node of the linked list
    private Node<T> tail; // Tail node of the linked list
    private int size; // Size of the linked list

    // Inner static class representing a node in the linked list
    private static class Node<T> {
        T element; // Data stored in the node
        Node<T> next; // Reference to the next node
        Node<T> prev; // Reference to the previous node

        // Constructor to initialize node with an element, next, and previous references
        Node(T element, Node<T> next, Node<T> prev) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
    }

    // Constructor to initialize an empty linked list
    public MyLinkedList() {
        head = null; // Initialize head to null
        tail = null; // Initialize tail to null
        size = 0; // Initialize size to 0
    }

    // Add an item to the end of the linked list
    public void add(T item) {
        addLast(item); // Delegate to addLast method to add at the end
    }

    // Set the element at the specified index to the given item
    public void set(int index, T item) {
        Node<T> node = getNode(index); // Get the node at the specified index
        if (node != null) {
            node.element = item; // Set the element of the node to the given item
        } else {
            throw new IndexOutOfBoundsException(); // Throw exception if index is invalid
        }
    }

