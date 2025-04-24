# Penjelasan

## file `main.java`

```java
package tree1b;

public class Main {
    public static void main(String[] args) {
        // Membuat objek BinarySearchTree (pohon BST kosong)
        BinarySearchTree bst = new BinarySearchTree();

        // Menambahkan nilai-nilai ke dalam pohon
        // Nilai-nilai ini akan membentuk struktur pohon BST secara otomatis
        bst.insert(50);
        bst.insert(30);
        bst.insert(20);
        bst.insert(40);
        bst.insert(70);
        bst.insert(60);
        bst.insert(80);

        // Menampilkan traversal inorder
        // Inorder = kiri → induk → kanan (hasilnya urutan dari kecil ke besar)
        System.out.println("Inorder traversal:");
        bst.inorder();  // Output: 20 30 40 50 60 70 80

        // Menampilkan traversal postorder
        // Postorder = kiri → kanan → induk (urutan dari bawah ke atas)
        System.out.println("Postorder traversal:");
        bst.postorder();  // Output: 20 40 30 60 80 70 50

        // Mencari apakah sebuah angka ada di dalam pohon
        // Akan mencetak "true" jika ada, dan "false" jika tidak ada
        System.out.println("Apakah 20 ada di dalam pohon? " + bst.search(20));   // true
        System.out.println("Apakah 100 ada di dalam pohon? " + bst.search(100)); // false

        // Menghapus nilai 20 dari pohon
        // Lalu mencetak kembali traversal inorder dan postorder
        System.out.println("\nSetelah menghapus 20:");
        bst.delete(20);
        System.out.print("Inorder:   ");
        bst.inorder();       // 30 40 50 60 70 80
        System.out.print("Postorder: ");
        bst.postorder();     // 40 30 60 80 70 50

        // Menghapus nilai 30 dari pohon
        System.out.println("\nSetelah menghapus 30:");
        bst.delete(30);
        System.out.print("Inorder:   ");
        bst.inorder();       // 40 50 60 70 80
        System.out.print("Postorder: ");
        bst.postorder();     // 40 60 80 70 50

        // Menghapus nilai 50 dari pohon (nilai akar/root)
        System.out.println("\nSetelah menghapus 50 (root):");
        bst.delete(50);
        System.out.print("Inorder:   ");
        bst.inorder();       // 40 60 70 80
        System.out.print("Postorder: ");
        bst.postorder();     // 60 80 70 40
    }
}

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
