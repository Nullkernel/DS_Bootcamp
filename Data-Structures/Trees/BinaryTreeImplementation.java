// Full binary search tree implementation with insert, search, and delete.
// Delete handles all cases explicitly:
// 1) leaf node, 2) node with one child, 3) node with two children.
public class BinaryTreeImplementation {
    private static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    private Node root;

    public void insert(int value) {
        root = insertRecursive(root, value);
    }

    private Node insertRecursive(Node node, int value) {
        if (node == null) {
            return new Node(value);
        }
        if (value < node.data) {
            node.left = insertRecursive(node.left, value);
        } else if (value > node.data) {
            node.right = insertRecursive(node.right, value);
        }
        // Duplicate values are ignored to keep keys unique.
        return node;
    }

    public boolean search(int value) {
        Node current = root;
        while (current != null) {
            if (value == current.data) {
                return true;
            }
            current = (value < current.data) ? current.left : current.right;
        }
        return false;
    }

    public void delete(int value) {
        root = deleteRecursive(root, value);
    }

    private Node deleteRecursive(Node node, int value) {
        if (node == null) {
            return null;
        }

        if (value < node.data) {
            node.left = deleteRecursive(node.left, value);
        } else if (value > node.data) {
            node.right = deleteRecursive(node.right, value);
        } else {
            // Case 1: leaf node.
            if (node.left == null && node.right == null) {
                return null;
            }

            // Case 2: one child.
            if (node.left == null) {
                return node.right;
            }
            if (node.right == null) {
                return node.left;
            }

            // Case 3: two children.
            // Replace with inorder successor (smallest in right subtree), then delete successor.
            Node successor = findMinNode(node.right);
            node.data = successor.data;
            node.right = deleteRecursive(node.right, successor.data);
        }

        return node;
    }

    private Node findMinNode(Node node) {
        Node current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    public void inorderTraversal() {
        inorderRecursive(root);
        System.out.println();
    }

    private void inorderRecursive(Node node) {
        if (node == null) {
            return;
        }
        inorderRecursive(node.left);
        System.out.print(node.data + " ");
        inorderRecursive(node.right);
    }

    public static void main(String[] args) {
        BinaryTreeImplementation tree = new BinaryTreeImplementation();

        int[] values = {50, 30, 70, 20, 40, 60, 80, 65};
        for (int value : values) {
            tree.insert(value);
        }

        System.out.print("Initial inorder: ");
        tree.inorderTraversal();

        System.out.println("Search 40: " + tree.search(40));
        System.out.println("Search 99: " + tree.search(99));

        tree.delete(20); // leaf
        tree.delete(60); // one child
        tree.delete(70); // two children

        System.out.print("Inorder after deletes: ");
        tree.inorderTraversal();
    }
}
