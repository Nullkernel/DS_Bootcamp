class Node{
    int data;
    Node left;
    Node right;
    public Node(int key){
        data = key;
        left = right = null;
    }
}
class binarytree{
    Node root = null;
    void inorder_traversal(Node node){
        if(node != null){
            inorder_traversal(node.left);
            System.out.print(node.data + " ");
            inorder_traversal(node.right);
        }
    }
    void pre_order_traversal(Node node){
        if(node != null){
            System.out.print(node.data + " ");
            pre_order_traversal(node.left);
            pre_order_traversal(node.right);
        }
    }
    void post_order_traversal(Node node){
        if(node != null){
            post_order_traversal(node.left);
            post_order_traversal(node.right);
            System.out.print(node.data + " ");
        }        
    }
}
public class BinaryTree{
    public static void main(String[] args){
        binarytree tree = new binarytree();
        tree.root = new Node(27);
        tree.root.left = new Node(12);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(44);
        tree.root.left.right = new Node(17);
        tree.root.right.left = new Node(56);
        System.out.println("Inorder traversal : ");
        tree.inorder_traversal(tree.root);
        System.out.println("\nPreorder traversal : ");
        tree.pre_order_traversal(tree.root);
        System.out.println("\nPostorder traversal : ");
        tree.post_order_traversal(tree.root);
    }
}
