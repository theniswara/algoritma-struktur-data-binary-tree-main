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
 package tree1b;

// Kelas utama untuk Binary Search Tree (BST)
public class BinarySearchTree {

    // =========================
    // Kelas internal Node
    // Setiap node menyimpan satu angka (key), dan punya anak kiri dan kanan
    class Node {
        int key;          // Angka yang disimpan di node ini
        Node left, right; // Pointer ke anak kiri dan kanan

        // Konstruktor Node: membuat node baru dengan angka yang diberikan
        public Node(int item) {
            key = item;
            left = right = null;
        }
    }

    // Akar (root) dari BST
    Node root;

    // Konstruktor BinarySearchTree: awalnya pohon kosong
    public BinarySearchTree() {
        root = null;
    }

    // =========================
    // Fungsi untuk menambahkan (insert) angka ke BST
    public void insert(int key) {
        root = insertRec(root, key); // Panggil fungsi rekursif
    }

    // Fungsi rekursif untuk menyisipkan angka ke posisi yang benar
    private Node insertRec(Node root, int key) {
        // Jika posisi kosong (null), buat node baru di sini
        if (root == null) {
            root = new Node(key);
            return root;
        }

        // Jika key lebih kecil, masukkan ke kiri
        if (key < root.key)
            root.left = insertRec(root.left, key);
        // Jika key lebih besar, masukkan ke kanan
        else if (key > root.key)
            root.right = insertRec(root.right, key);

        // Kembalikan node saat ini (tidak berubah)
        return root;
    }

    // =========================
    // Fungsi untuk traversal inorder (kiri - induk - kanan)
    public void inorder() {
        inorderRec(root);
        System.out.println();
    }

    // Fungsi rekursif untuk traversal inorder
    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);              // Kunjungi kiri
            System.out.print(root.key + " ");   // Cetak node ini
            inorderRec(root.right);             // Kunjungi kanan
        }
    }

    // =========================
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

    // =========================
    // Fungsi untuk mencari angka di BST
    public boolean search(int key) {
        return searchRec(root, key); // Panggil fungsi rekursif
    }

    // Fungsi rekursif pencarian
    private boolean searchRec(Node root, int key) {
        // Jika tidak ditemukan
        if (root == null)
            return false;
        // Jika ditemukan
        if (root.key == key)
            return true;

        // Jika key lebih kecil, cari di kiri
        if (root.key > key)
            return searchRec(root.left, key);

        // Jika key lebih besar, cari di kanan
        return searchRec(root.right, key);
    }

    // =========================
    // Fungsi untuk menghapus (delete) node dari BST
    public void delete(int key) {
        root = deleteRec(root, key); // Panggil fungsi rekursif
    }

    // Fungsi rekursif penghapusan
    private Node deleteRec(Node root, int key) {
        // Jika node kosong, langsung kembali
        if (root == null)
            return root;

        // Jika key lebih kecil, cari di kiri
        if (key < root.key)
            root.left = deleteRec(root.left, key);
        // Jika key lebih besar, cari di kanan
        else if (key > root.key)
            root.right = deleteRec(root.right, key);
        else {
            // Jika hanya punya 1 anak atau tidak punya anak
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // Jika punya 2 anak:
            // Ambil nilai terkecil dari sub-pohon kanan (inorder successor)
            root.key = minValue(root.right);

            // Hapus node pengganti yang dipakai tadi
            root.right = deleteRec(root.right, root.key);
        }

        return root;
    }

    // Fungsi untuk menemukan nilai terkecil dalam sebuah subtree
    private int minValue(Node root) {
        int minv = root.key;
        // Terus ke kiri sampai tidak ada anak kiri lagi
        while (root.left != null) {
            minv = root.left.key;
            root = root.left;
        }
        return minv;
    }
}

```
