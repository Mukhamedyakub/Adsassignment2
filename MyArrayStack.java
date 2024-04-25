import java.util.NoSuchElementException;

// MyStack class definition with a generic type T
public class MyArrayStack<T> {
    // Private member variable to hold the stack elements using MyArrayList
    private MyArrayList<T> list;

    // Constructor that initializes the stack by creating an instance of MyArrayList
    public MyArrayStack() {
        list = new MyArrayList<>();
    }

    // Method to add an item to the top of the stack
    public void push(T item) {
        // Adds the item to the end of the list which represents the top of the stack
        list.addLast(item);
    }
    
    // Method to remove and return the top item from the stack
    public T pop() {
        // Checks if the stack is empty before attempting to remove an item
        if (list.isEmpty()) {
            // Throws NoSuchElementException if there are no items to pop
            throw new NoSuchElementException("Stack is empty.");
        }
        // Removes the last item of the list which is the top of the stack
        return list.removeLast();
    }

    // Method to retrieve, without removing, the top item of the stack
    public T peek() {
        // Checks if the stack is empty before attempting to peek at the top item
        if (list.isEmpty()) {
            // Throws NoSuchElementException if there are no items to peek
            throw new NoSuchElementException("Stack is empty.");
        }
        // Returns the last item of the list without removing, which is the top of the stack
        return list.getLast();
    }

    // Method to check if the stack is empty
    public boolean isEmpty() {
        // Returns true if the stack has no elements, otherwise false
        return list.isEmpty();
    }

    // Method to get the number of items in the stack
    public int size() {
        // Returns the number of elements in the list, which corresponds to the stack's size
        return list.size();
    }
}

