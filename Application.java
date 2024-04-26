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
        