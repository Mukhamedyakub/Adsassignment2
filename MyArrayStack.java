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

    