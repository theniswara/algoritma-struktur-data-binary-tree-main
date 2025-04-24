# Penjelasan

## file `main.java`

```java
// Menampilkan traversal postorder
        // Postorder = kiri → kanan → induk (urutan dari bawah ke atas)
        System.out.println("Postorder traversal:");
        bst.postorder();  // Output: 20 40 30 60 80 70 50
```

## file `BinarySearchTree.java`

```java
 // Fungsi untuk traversal postorder (kiri - kanan - induk)
    public void postorder() {
        postorderRec(root);
        System.out.println();
    }

    // Fungsi rekursif postorder
    private void postorderRec(Node root) {
        if (root != null) {
            postorderRec(root.left);            // Kunjungi kiri
            postorderRec(root.right);           // Kunjungi kanan
            System.out.print(root.key + " ");   // Cetak node ini
        }
    }
```
