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

    // Add an item at the specified index
    public void add(int index, T item) {
        if (index == size) {
            addLast(item); // If index is at the end, delegate to addLast method
        } else {
            Node<T> current = getNode(index); // Get the node at the specified index
            Node<T> newNode = new Node<>(item, current, current.prev); // Create a new node
            if (current.prev != null) {
                current.prev.next = newNode; // Adjust references for the new node
            } else {
                head = newNode; // Update head if adding at the beginning
            }
            current.prev = newNode; // Update previous reference of the current node
            size++; // Increment size
        }
    }

    // Add an item to the beginning of the linked list
    public void addFirst(T item) {
        Node<T> newNode = new Node<>(item, head, null); // Create a new node
        if (head != null) {
            head.prev = newNode; // Adjust references for the new node
        } else {
            tail = newNode; // Update tail if adding to an empty list
        }
        head = newNode; // Update head
        size++; // Increment size
    }

    // Add an item to the end of the linked list
    public void addLast(T item) {
        Node<T> newNode = new Node<>(item, null, tail); // Create a new node
        if (tail != null) {
            tail.next = newNode; // Adjust references for the new node
        } else {
            head = newNode; // Update head if adding to an empty list
        }
        tail = newNode; // Update tail
        size++; // Increment size
    }

    // Get the element at the specified index
    public T get(int index) {
        Node<T> node = getNode(index); // Get the node at the specified index
        if (node != null) {
            return node.element; // Return the element of the node
        } else {
            throw new IndexOutOfBoundsException(); // Throw exception if index is invalid
        }
    }

    // Get the first element of the linked list
    public T getFirst() {
        if (head == null) {
            throw new NoSuchElementException(); // Throw exception if the list is empty
        }
        return head.element; // Return the element of the head node
    }

    // Get the last element of the linked list
    public T getLast() {
        if (tail == null) {
            throw new NoSuchElementException(); // Throw exception if the list is empty
        }
        return tail.element; // Return the element of the tail node
    }

    // Remove the item at the specified index
    public T remove(int index) {
        Node<T> node = getNode(index); // Get the node at the specified index
        if (node != null) {
            if (node.prev != null) {
                node.prev.next = node.next; // Adjust references to remove the node
            } else {
                head = node.next; // Update head if removing the first node
            }
            if (node.next != null) {
                node.next.prev = node.prev; // Adjust references to remove the node
            } else {
                tail = node.prev; // Update tail if removing the last node
            }
            size--; // Decrement size
            return node.element; // Return the removed element
        } else {
            throw new IndexOutOfBoundsException(); // Throw exception if index is invalid
        }
    }

