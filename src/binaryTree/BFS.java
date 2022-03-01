package binaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://www.geeksforgeeks.org/level-order-tree-traversal/
 * level order traversal also known as a bfs for tree
 * time and space O(n)
 */

/**
 * Algorithm:
 * There are basically two functions in this method.
 * One is to print all nodes at a given level (printCurrentLevel), and other is to print level order traversal of the tree (printLevelorder).
 * printLevelorder makes use of printCurrentLevel to print nodes at all levels one by one starting from the root.
 */
public class BFS {
    static class Node {
        int data;
        Node left, right;

        public Node(int item)
        {
            data = item;
            left = null;
            right = null;
        }
    }

    /* Class to print Level Order Traversal */
    static class BinaryTree {

        Node root;
        void printLevelOrder()
        {
            Queue<Node> queue = new LinkedList<Node>();
            queue.add(root);
            while (!queue.isEmpty()) {

            /* poll() removes the present head. For more information on poll() visit */
                Node tempNode = queue.poll();
                System.out.print(tempNode.data + " ");

                /*Enqueue left child */
                if (tempNode.left != null) {
                    queue.add(tempNode.left);
                }

                /*Enqueue right child */
                if (tempNode.right != null) {
                    queue.add(tempNode.right);
                }
            }
        }

        public static void main(String args[]) {
            BinaryTree tree_level = new BinaryTree();
            tree_level.root = new Node(1);
            tree_level.root.left = new Node(2);
            tree_level.root.right = new Node(3);
            tree_level.root.left.left = new Node(4);
            tree_level.root.left.right = new Node(5);

            System.out.println("Level order traversal of binary tree is - ");
            tree_level.printLevelOrder();
        }
    }
}
