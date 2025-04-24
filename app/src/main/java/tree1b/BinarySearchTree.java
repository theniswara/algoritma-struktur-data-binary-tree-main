package tree1b;

public class BinarySearchTree {
    // Node class for the tree
    class Node {
        int key;
        Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }

    // Root of BST
    Node root;

    // Constructor
    public BinarySearchTree() {
        root = null;
    }

    // Insert a new key
    public void insert(int key) {
        root = insertRec(root, key);
    }

    // Recursive insert function
    private Node insertRec(Node root, int key) {
        // If the tree is empty, return a new node
        if (root == null) {
            root = new Node(key);
            return root;
        }

        // Otherwise, recur down the tree
        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);

        // Return the unchanged node pointer
        return root;
    }

    // Inorder traversal
    public void inorder() {
        inorderRec(root);
        System.out.println();
    }

    // Recursive inorder traversal function
    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }

    // Postorder traversal: left, right, root
    public void postorder() {
        postorderRec(root);
        System.out.println();
    }

    private void postorderRec(Node root) {
        if (root != null) {
            postorderRec(root.left); // 1. Go left
            postorderRec(root.right); // 2. Go right
            System.out.print(root.key + " "); // 3. Print after children
        }
    }

    public boolean search(int key) {
        return searchRec(root, key);
    }

    // Recursive search function
    private boolean searchRec(Node root, int key) {
        // Base Cases: root is null or key is present at root
        if (root == null)
            return false;
        if (root.key == key)
            return true;

        // Key is greater than root's key
        if (root.key > key)
            return searchRec(root.left, key);

        // Key is less than root's key
        return searchRec(root.right, key);
    }

    // Delete a key
    public void delete(int key) {
        root = deleteRec(root, key);
    }

    // Recursive delete function
    private Node deleteRec(Node root, int key) {
        // Base case: If the tree is empty
        if (root == null)
            return root;

        // Otherwise, recur down the tree
        if (key < root.key)
            root.left = deleteRec(root.left, key);
        else if (key > root.key)
            root.right = deleteRec(root.right, key);
        else {
            // Node with only one child or no child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // Node with two children: Get the inorder successor
            root.key = minValue(root.right);

            // Delete the inorder successor
            root.right = deleteRec(root.right, root.key);
        }

        return root;
    }

    private int minValue(Node root) {
        int minv = root.key;
        while (root.left != null) {
            minv = root.left.key;
            root = root.left;
        }
        return minv;
    }
}