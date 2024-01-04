package lesson_7_linkedlist;

public class CustomLinkedList {

    private Node first;

    private class Node {
        String data;
        Node next;

        public Node(String data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public void pushToHead(String element) {
        Node node = new Node(element, first);
        first = node;
    }

    public void pushToTail(String element) {
        if (first == null) {
            first = new Node(element, null);
        } else {
            Node current = first;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new Node(element, null);
        }
    }

    public void pushToIndex(String element, int index) {
        if (index == 0) {
            pushToHead(element);
            return;
        }
        Node previous = first;
        for (int i = 1; i <= index - 1; i++) {
            if (previous == null) throw new RuntimeException("Index is out of bounds");
            previous = previous.next;
        }
        if (previous == null) throw new RuntimeException("Index is out of bounds");
        Node newNode = new Node(element, previous.next);
        previous.next = newNode;
    }

    public String get(int index) {
        Node current = first;
        for (int i = 1; i <= index; i++) {
            if (current == null) throw new RuntimeException("Index is out of bounds");
            current = current.next;
        }
        if (current == null) throw new RuntimeException("Index is out of bounds");
        return current.data;
    }

    public void print() {
        Node current = first;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    public void removeLast() {
        if (first == null) throw new RuntimeException("LinkedList is empty");

        Node current = first;
        Node previous = null;
        while (current.next != null) {
            previous = current;
            current = current.next;
        }
        previous.next = null;
    }

    public void remove(int index) {
        if (index < 0 || first == null) {
            throw new RuntimeException("Wrong index provided");
        }

        if (index == 0) {
            first = first.next;
            return;
        }

        Node current = first;
        Node previous = null;
        int currentIndex = 0;

        while (current != null && currentIndex < index) {
            previous = current;
            current = current.next;
            currentIndex++;
        }


        if (current == null) {
            throw new RuntimeException("Wrong index provided");
        }

        previous.next = current.next;
    }

    /*
    * public int size() {
        int count = 0;
        Node current = first;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
    *
    *
    * public void RemoteFirst(){
        if (first==null) return;
        if(first.next==null){ first=null}
        else first=first.next;
    }

    }*/

    public static void main(String[] args) {
        CustomLinkedList linkedList = new CustomLinkedList();
//        linkedList.pushToHead("A");
//        linkedList.pushToHead("B");
//        linkedList.pushToHead("C");
//        linkedList.pushToHead("D");
//        linkedList.print();
        linkedList.pushToTail("A");
        linkedList.pushToTail("B");
        linkedList.pushToTail("C");
        linkedList.pushToTail("D");
//        linkedList.print();
//
//        System.out.println(linkedList.get(0));
//        System.out.println(linkedList.get(1));
//        System.out.println(linkedList.get(2));
//        System.out.println(linkedList.get(3));

        linkedList.pushToIndex("E", 4);
        linkedList.print();

        System.out.println("========");
        linkedList.removeLast();
        linkedList.print();

        System.out.println("========");
        linkedList.remove(3);
        linkedList.print();
    }
}
