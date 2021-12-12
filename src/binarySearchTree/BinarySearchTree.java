package binarySearchTree;

/**
 * https://www.geeksforgeeks.org/binary-search-tree-set-1-search-and-insertion/
 * https://www.geeksforgeeks.org/binary-search-tree-set-2-delete/
 * Inorder (Left, Root, Right) : 4 2 5 1 3
 * Preorder (Root, Left, Right) : 1 2 4 5 3
 * Postorder (Left, Right, Root) : 4 5 2 3 1
 */
public class BinarySearchTree {

    /**
     * Class containing left and right child of current node
     * and key value.
     */
    class Node {
        int key;
        Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }

    // root of BST
    Node root;

    // constructor
    BinarySearchTree () {
        root = null;
    }

    // this method mainly calls insertRec()
    void insert(int key) {
        root = insertRec(root, key);
    }

    // a recursive function to insert a new key in BST
    Node insertRec(Node root, int key) {
        // if the tree is empty return a new node
        if (root == null) {
            root = new Node(key);
            return root;
        }

        // otherwise, recur down the tree
        if (key < root.key) {
            root.left = insertRec(root.left, key);
        } else {
            root.right = insertRec(root.right, key);
        }
        // return the (unchanged) node pointer
        return root;
    }

    // this method mainly calls InorderRec()
    void inorder() {
        inorderRec(root);
    }

    // a utility function to do inorder traversal of BST
    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.println(root.key);
            inorderRec(root.right);
        }
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
         /* Let us create following BST
              50
           /     \
          30      70
         /  \    /  \
       20   40  60   80 */
        tree.insert(50);
        tree.insert(20);
        tree.insert(30);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);


        // print inorder traversal of the BST
        tree.inorder();
    }
}
