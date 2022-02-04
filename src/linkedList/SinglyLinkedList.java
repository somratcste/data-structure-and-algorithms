package linkedList;

/**
 * https://www.geeksforgeeks.org/linked-list-set-1-introduction/
 * https://www.geeksforgeeks.org/linked-list-set-2-inserting-a-node/
 * https://www.geeksforgeeks.org/linked-list-set-3-deleting-node/
 * https://www.geeksforgeeks.org/delete-a-linked-list-node-at-a-given-position/
 */
public class SinglyLinkedList {
    Node head;
    static class Node {
        int data;
        Node next;
        Node (int data) {
            this.data = data;
            next = null;
        }
    }

    // insert a node front of the list
    public void push(int data) {
        Node node = new Node(data);
        node.next = head;
        head = node;
    }

    // insert a node after given prev_node
    public void insertAfter(Node prevNode, int data) {
        if (prevNode == null) {
            System.out.println("prev node cannot be null");
            return;
        }
        Node node = new Node(data);
        node.next = prevNode.next;
        prevNode.next = node;
    }

    // append new node at the end
    public void append(int data) {
        Node node  = new Node(data);
        if (head == null) {
            head = node;
            return;
        }
        node.next = null;
        Node last = head;
        while (last.next != null) {
            last = last.next;
        }
        last.next = node;
        return;
    }

    public void traverse() {
        Node n = head;
        while (n!= null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
    }

    // delete first occurrence of key(data) in linked list
    public void deleteNode(int data) {
        Node temp = head, prev = null;
        // If head node itself holds the key to be deleted
        if (temp != null && temp.data == data) {
            head = temp.next;
            return;
        }

        // Search for the key to be deleted, keep track of
        // the previous node as we need to change temp.next
        while (temp != null && temp.data != data) {
            prev = temp;
            temp = temp.next;
        }

        // If key was not present in linked list
        if (temp == null) return;

        // Unlink the node from linked list
        prev.next = temp.next;
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        // 6->null
        list.append(6);
        // 7->6->null
        list.push(7);
        // 1->7->6->null
        list.push(1);
        // 1->7->6->4->null
        list.append(4);
        // insert 8 after 7 lis.head.next
        // 1->7->8->6->4->null
        list.insertAfter(list.head.next, 8);

        list.traverse();

        // 1->8->6->4->null
        list.deleteNode(7);
        System.out.println("\nAfter Delete 7");
        list.traverse();
    }
}
