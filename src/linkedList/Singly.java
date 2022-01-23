package linkedList;

public class Singly {
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
         Singly list  = new Singly();
         list.head = new Node(1);
         Node second = new Node(2);
         Node third = new Node(3);

         list.head.next = second;
         second.next = third;
         list.push(0);
         list.insertAfter(list.head.next,5);
         list.append(8);

         list.printList();
    }

    private void printList() {
        Node n = head;
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
    }

    // insert before
    public void push(int newData) {
        Node newNode = new Node(newData);
        newNode.next = head;
        head = newNode;
    }

    // insert after
    public void insertAfter(Node prevNode, int newData) {
        // check if the given node is null
        if(prevNode == null) {
            System.out.println("The given previous node cannot be null");
            return;
        }

        Node newNode = new Node(newData);
        newNode.next = prevNode.next;
        prevNode.next = newNode;
    }

    // append at the end
    public void append(int newData) {
        Node newNode = new Node(newData);

        // check linked list is empty
        if(head == null) {
            head = newNode;
            return;
        }

        // This new node is going to be the last node, so
        // make next of it as null
        newNode.next = null;

        // else traver till the last node
        Node last = head;
        while (last.next != null) {
            last = last.next;
        }

        // change the next of last node
        last.next = newNode;
        return;
    }
}
