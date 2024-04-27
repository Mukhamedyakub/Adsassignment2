public class Main {
    public static void main(String[] args) {
        // Demonstrating ArrayList-based implementations
        System.out.println("****** ArrayList-based Implementations ******");

        // Stack Example using ArrayList
        System.out.println("\n--- ArrayList Stack Example ---");
        MyArrayStack<String> arrayListStack = new MyArrayStack<>();
        arrayListStack.push("Apple");
        arrayListStack.push("Banana");
        arrayListStack.push("Cherry");

        System.out.println("Current top (Peek): " + arrayListStack.peek());
        System.out.println("Popping elements from the stack...");
        while (!arrayListStack.isEmpty()) {
            System.out.println("Popped: " + arrayListStack.pop());
        }
        System.out.println("Is the stack empty? " + arrayListStack.isEmpty());

        // Queue Example using ArrayList
        System.out.println("\n--- ArrayList Queue Example ---");
        MyArrayQueue<String> arrayListQueue = new MyArrayQueue<>();
        arrayListQueue.enqueue("Monday");
        arrayListQueue.enqueue("Tuesday");
        arrayListQueue.enqueue("Wednesday");

        System.out.println("First element (Peek): " + arrayListQueue.peek());
        System.out.println("Dequeuing elements...");
        while (!arrayListQueue.isEmpty()) {
            System.out.println("Dequeued: " + arrayListQueue.dequeue());
        }
        System.out.println("Is the queue empty? " + arrayListQueue.isEmpty());

        // MinHeap Example using ArrayList
        System.out.println("\n--- ArrayList MinHeap Example ---");
        MyArrayMinHeap<Integer> arrayListMinHeap = new MyArrayMinHeap<>();
        arrayListMinHeap.insert(10);
        arrayListMinHeap.insert(5);
        arrayListMinHeap.insert(15);

        System.out.println("Minimum element (Get Min): " + arrayListMinHeap.getMin());
        System.out.println("Removing elements from MinHeap...");
        while (!arrayListMinHeap.empty()) {
            System.out.println("Extracted Min: " + arrayListMinHeap.extractMin());
        }
        System.out.println("Is the MinHeap empty? " + arrayListMinHeap.empty());

        // Demonstrating LinkedList-based implementations
        System.out.println("\n****** LinkedList-based Implementations ******");

        // Stack Example using LinkedList
        System.out.println("\n--- LinkedList Stack Example ---");
        MyLinkedStack<String> linkedListStack = new MyLinkedStack<>();
        linkedListStack.push("Apple");
        linkedListStack.push("Banana");
        linkedListStack.push("Cherry");

        System.out.println("Current top (Peek): " + linkedListStack.peek());
        System.out.println("Popping elements from the stack...");
        while (!linkedListStack.isEmpty()) {
            System.out.println("Popped: " + linkedListStack.pop());
        }
        System.out.println("Is the stack empty? " + linkedListStack.isEmpty());

        // Queue Example using LinkedList
        System.out.println("\n--- LinkedList Queue Example ---");
        MyLinkedQueue<String> linkedListQueue = new MyLinkedQueue<>();
        linkedListQueue.enqueue("Monday");
        linkedListQueue.enqueue("Tuesday");
        linkedListQueue.enqueue("Wednesday");

        System.out.println("First element (Peek): " + linkedListQueue.peek());
        System.out.println("Dequeuing elements...");
        while (!linkedListQueue.isEmpty()) {
            System.out.println("Dequeued: " + linkedListQueue.dequeue());
        }
        System.out.println("Is the queue empty? " + linkedListQueue.isEmpty());

        System.out.println("\n--- LinkedList MinHeap Example ---");
        MyLinkedMinHeap<Integer> linkedListMinHeap = new MyLinkedMinHeap<>();

        // Insert elements into the MinHeap
        System.out.println("Inserting elements into MinHeap:");
        int[] numbers = {10, 5, 15, 3, 8, 20, 2};
        for (int number : numbers) {
            linkedListMinHeap.add(number);
            System.out.println("Inserted: " + number);
        }
        // Display the minimum element without removing it
//        System.out.println("\nCurrent Minimum (Peek): " + linkedListMinHeap.getMin());

        // Extracting elements from the MinHeap
        System.out.println("\nExtracting all elements from MinHeap in sorted order:");
        while (!linkedListMinHeap.isEmpty()) {
            System.out.println("Extracted Min: " + linkedListMinHeap.extractMin());
        }

        // Check if the MinHeap is empty after removals
        System.out.println("\nIs the MinHeap empty? " + linkedListMinHeap.isEmpty());
    }
}
