package tree1b;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        // Insert values
        bst.insert(50);
        bst.insert(30);
        bst.insert(20);
        bst.insert(40);
        bst.insert(70);
        bst.insert(60);
        bst.insert(80);

        // Print inorder traversal
        System.out.println("Inorder traversal:");
        bst.inorder();

        // Print postorder traversal
        System.out.println("Postorder traversal:");
        bst.postorder();

        // Search for values
        System.out.println("Is 20 in the tree? " + bst.search(20));
        System.out.println("Is 100 in the tree? " + bst.search(100));

        // Delete a value and print again
        System.out.println("\nAfter deleting 20:");
        bst.delete(20);
        bst.inorder();

        // After deleting 20:
        System.out.println("\nAfter deleting 20:");
        bst.delete(20);
        System.out.print("Inorder:   ");
        bst.inorder();
        System.out.print("Postorder: ");
        bst.postorder();

        // After deleting 30:
        System.out.println("\nAfter deleting 30:");
        bst.delete(30);
        System.out.print("Inorder:   ");
        bst.inorder();
        System.out.print("Postorder: ");
        bst.postorder();

        // After deleting 50 (root):
        System.out.println("\nAfter deleting 50 (root):");
        bst.delete(50);
        System.out.print("Inorder:   ");
        bst.inorder();
        System.out.print("Postorder: ");
        bst.postorder();
    }
}