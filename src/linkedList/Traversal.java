package linkedList;

public class Traversal {
    static class Node {
        int data;
        Node next;

        Node( int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head;

    public static void main(String[] args) {
         Traversal list  = new Traversal();
         list.head = new Node(1);
         Node second = new Node(2);
         Node third = new Node(3);

         list.head.next = second;
         second.next = third;

         list.printList();
    }

    private void printList() {
        Node n = head;
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
    }
}
