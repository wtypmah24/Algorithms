package lesson_6_stack_queue;

import java.util.EmptyStackException;

public class SpecialStack {
    private final int[] data;
    private final int[] minStack;
    private int count;

    public SpecialStack(int capacity) {
        data = new int[capacity];
        minStack = new int[capacity];
        this.count = 0;
    }

    public void push(int element) {
        if (count >= data.length) throw new RuntimeException("Stack is full");

        data[count] = element;

        if (count == 0 || element < minStack[count - 1]) {
            minStack[count] = element;
        } else {
            minStack[count] = minStack[count - 1];
        }

        count++;
    }

    public int pop() {
        if (count == 0) throw new EmptyStackException();

        minStack[count - 1] = 0;

        return data[--count];
    }

    public int peek() {
        if (count == 0) throw new EmptyStackException();
        return data[count - 1];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int size() {
        return count;
    }

    public int getMin() {
        if (count == 0) throw new EmptyStackException();
        return minStack[count - 1];
    }

    public static void main(String[] args) {
        SpecialStack stack = new SpecialStack(5);
        stack.push(10);
        stack.push(100);
        stack.push(1);
        stack.push(-1);
        stack.push(-4);
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());
        System.out.println(stack.size());
    }
}
