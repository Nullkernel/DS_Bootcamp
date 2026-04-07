// Manual tree traversal demo:
// This example builds a tree by wiring nodes manually and prints DFS traversals.
class ManualTraversalTree {
    private static class TraversalNode {
        int data;
        TraversalNode left;
        TraversalNode right;

        TraversalNode(int key) {
            data = key;
            left = right = null;
        }
    }

    TraversalNode root = null;

    void buildSampleTree() {
        root = new TraversalNode(27);
        root.left = new TraversalNode(12);
        root.right = new TraversalNode(3);
        root.left.left = new TraversalNode(44);
        root.left.right = new TraversalNode(17);
        root.right.left = new TraversalNode(56);
    }

    void inorderTraversal(TraversalNode node) {
        if (node != null) {
            inorderTraversal(node.left);
            System.out.print(node.data + " ");
            inorderTraversal(node.right);
        }
    }

    void preOrderTraversal(TraversalNode node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preOrderTraversal(node.left);
            preOrderTraversal(node.right);
        }
    }

    void postOrderTraversal(TraversalNode node) {
        if (node != null) {
            postOrderTraversal(node.left);
            postOrderTraversal(node.right);
            System.out.print(node.data + " ");
        }
    }
}

public class BinaryTree {
    public static void main(String[] args) {
        ManualTraversalTree tree = new ManualTraversalTree();

        // Manually building a sample tree for traversal demonstration.
        tree.buildSampleTree();

        System.out.println("Inorder traversal:");
        tree.inorderTraversal(tree.root);

        System.out.println("\nPreorder traversal:");
        tree.preOrderTraversal(tree.root);

        System.out.println("\nPostorder traversal:");
        tree.postOrderTraversal(tree.root);
    }
}
