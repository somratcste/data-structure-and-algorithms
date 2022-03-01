package binaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://www.geeksforgeeks.org/deletion-binary-tree/
 */

/**
 * Algorithm
 * 1. Starting at the root, find the deepest and rightmost node in binary tree and node which we want to delete.
 * 2. Replace the deepest rightmost node’s data with the node to be deleted.
 * 3. Then delete the deepest rightmost node.
 */
public class BTDeletion {

    static class Node {
        int key;
        Node left, right;
        Node (int key) {
            this.key =  key;
            left = null;
            right = null;
        }
    }

    static Node root;
    static Node temp = root;

    // Inorder traversal of a binary tree
    static void inorder(Node temp) {
        if (temp == null) return;
        inorder(temp.left);
        System.out.print(temp.key + " ");
        inorder(temp.right);
    }

    // function to delete deepest element in binary tree
    static void deleteDeepest (Node root, Node delNode) {
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);

        // do level order traversal until last node
        while (!q.isEmpty()) {
            temp = q.peek();
            q.remove();
            if (temp == delNode) {
                temp = null;
                return;
            }
            if (temp.right != null) {
                if (temp.right == delNode) {
                    temp.right = null;
                    return;
                } else {
                    q.add(temp.right);
                }
            }

            if (temp.left != null) {
                if (temp.left == delNode) {
                    temp.left = null;
                    return;
                } else {
                    q.add(temp.left);
                }
            }
        }
    }

    // function to delete given element in binary tree
    static void delete (Node root, int key) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            if (root.key == key) {
                root = null;
                return;
            } else {
                return;
            }
        }

        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        Node temp = null, keyNode = null;

        // do level order traversal until we find key and last node
        while (!q.isEmpty()) {
            temp = q.peek();
            q.remove();
            if (temp.key == key) {
                keyNode = temp;
            }
            if (temp.left != null) {
                q.add(temp.left);
            }
            if (temp.right != null) {
                q.add(temp.right);
            }
        }
        // now temp will be the rightmost deepest tree
        // KeyNode will be the node we want to delete
        if (keyNode != null) {
            int x = temp.key;
            deleteDeepest(root, temp);
            keyNode.key = x;
        }
    }

    public static void main(String[] args) {
        root = new Node(10);
        root.left = new Node(11);
        root.left.left = new Node(7);
        root.left.right = new Node(12);
        root.right = new Node(9);
        root.right.left = new Node(15);
        root.right.right = new Node(8);

        System.out.print("Inorder traversal before deletion: ");
        inorder(root);

        int key = 11;
        delete(root, key);
        System.out.print("\nInorder traversal after deletion: ");
        inorder(root);
    }
}
