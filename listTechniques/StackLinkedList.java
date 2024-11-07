package listTechniques;

import java.util.LinkedList;

public class StackLinkedList {
	
	/*
	 * 
	 * For Simplicity and Performance:
Use ArrayList if you are only performing stack operations at the end of the list and prefer lower memory overhead with better cache performance.

For Flexibility:
Use LinkedList if you need to perform operations at both ends or require a doubly-linked list structure.

For Modern and Versatile Stack Implementation:
Use Deque with ArrayDeque for a stack-like implementation that offers excellent performance and a clear API.
	 */
    private LinkedList<Integer> list;

    /** Initialize your data structure here. */
    public StackLinkedList() {
        list = new LinkedList<>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        list.addFirst(x);
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return list.removeFirst();
    }
    
    /** Get the top element. */
    public int top() {
        return list.getFirst();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return list.isEmpty();
    }

    public static void main(String[] args) {
        StackLinkedList stack = new StackLinkedList();

        // Push elements onto the stack
        stack.push(10);
        stack.push(20);
        stack.push(30);

        // Get the top element
        System.out.println("Top element: " + stack.top()); // Should print 30

        // Pop elements from the stack
        System.out.println("Popped element: " + stack.pop()); // Should print 30
        System.out.println("Popped element: " + stack.pop()); // Should print 20

        // Get the top element again
        System.out.println("Top element: " + stack.top()); // Should print 10

        // Check if the stack is empty
        System.out.println("Is the stack empty? " + stack.empty()); // Should print false

        // Pop the last element
        System.out.println("Popped element: " + stack.pop()); // Should print 10

        // Check if the stack is empty now
        System.out.println("Is the stack empty? " + stack.empty()); // Should print true
    }
}
