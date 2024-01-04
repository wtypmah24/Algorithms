package HW_061223;

import lesson_7_linkedlist.CustomLinkedList;

public class CustomLinkedStack {


    private static class Node {
        Node previous;
        String data;

        public Node(String data, CustomLinkedStack.Node previous) {
            this.data = data;
            this.previous = previous;
        }
    }

    private Node last;
    private int count;

    public void push(String element) {
        Node newNode = new Node(element, last);
        last = newNode;
        count++;
    }

    public String pop() {
        if (isEmpty()) throw new RuntimeException("Stack is empty");
        String data = last.data;
        last = last.previous;
        count--;
        return data;
    }

    public String peek() {
        if (isEmpty()) throw new RuntimeException("Stack is empty");
        return last.data;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int size() {
        return count;
    }

    public int search(String element) {

        Node current = last;
        int index = 1;
        while (current != null){
            if (current.data.equals(element)){
                return index;
            }
            current = current.previous;
            index++;
        }
        return -1;
    }

    public static void main(String[] args) {
        CustomLinkedStack stack = new CustomLinkedStack();
        stack.push("A");
        stack.push("B");
        stack.push("C");
        stack.push("D");
        stack.push("E");
        stack.push("F");
        stack.push("G");

        System.out.println(stack.peek());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());

        System.out.println(stack.search("C"));
    }
}
