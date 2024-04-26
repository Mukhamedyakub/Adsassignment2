public class Application {
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


