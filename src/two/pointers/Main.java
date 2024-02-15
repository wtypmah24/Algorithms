package two.pointers;

public class Main {
    public static void main(String[] args) {

        Node node5 = new Node("E", null);
        Node node4 = new Node("D", node5);
        Node node3 = new Node("C", node4);
        Node node2 = new Node("B", node3);
        Node node1 = new Node("A", node2);

        int n = 2;
        Node first = node1;
        Node second = node1;

        for (int i = 0; i< n; i++){
            second = second.next;
        }

        while (second != null){
            first = first.next;
            second = second.next;
        }

        System.out.println(first);

    }

    static class Node {
        String data;

        Node next;

        public Node(String data, Node next) {
            this.data = data;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data='" + data + "}";
        }
    }

}
