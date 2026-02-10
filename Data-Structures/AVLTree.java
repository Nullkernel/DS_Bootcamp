import java.util.*;
public class Main{
    class Node {
        int data;
        int height;
        Node left;
        int right;
        Node(int data) {
            this.data = data;
            height = 1;
        }
    }
    static class AVL{
        Node root;
        // ---------- UTILITIES ----------
        int height(Node n) {
            return n == null ? 0 : n.height;
        }
        int getBalance(Node n) {
            return n == null ? 0 : height(n.left) - height(n.right);
        }
        void updateHeight(Node n) {
            n.height = 1 + Math.max(height(n.left), height(n.right));
        }
        // ---------- ROTATIONS ----------
        Node rightRotate(Node y) {
            Node x = y.left;
            Node t2 = x.right;
            x.right = y;
            y.left = t2;
            updateHeight(y);
            updateHeight(x);
            return x;
        }
        Node leftRotate(Node x) {
            Node y = x.right;
            Node t2 = y.left;
            y.left = x;
            x.right = t2;
            updateHeight(x);
            updateHeight(y);
            return y;
        }
        // ---------- INSERT (ITERATIVE) ----------
        public void insert(int key) {
            if (root == null) {
                root = new Node(key);
                return;
            }
            Stack<Node> stack = new Stack<>();
            Node cur = root;
            while (cur != null) {
                stack.push(cur);
                if (key < cur.data) {
                    if (cur.left == null) {
                        cur.left = new Node(key);
                        stack.push(cur.left);
                        break;
                    }
                    cur = cur.left;
                } else if (key > cur.data) {
                    if (cur.right == null) {
                        cur.right = new Node(key);
                        stack.push(cur.right);
                        break;
                    }
                    cur = cur.right;
                } else return; // no duplicates
            }
            rebalance(stack);
        }
        // ---------- DELETE (ITERATIVE) ----------
        public void delete(int key) {
            if (root == null) return;
            Stack<Node> stack = new Stack<>();
            Node cur = root, parent = null;
            while (cur != null && cur.data != key) {
                stack.push(cur);
                parent = cur;
                cur = key < cur.data ? cur.left : cur.right;
            }
            if (cur == null) return;
            if (cur.left != null && cur.right != null) {
                stack.push(cur);
                Node succParent = cur;
                Node succ = cur.right;
                while (succ.left != null) {
                    stack.push(succ);
                    succParent = succ;
                    succ = succ.left;
                }
                cur.data = succ.data;
                parent = succParent;
                cur = succ;
            }
            Node child = (cur.left != null) ? cur.left : cur.right;
            if (parent == null)
                root = child;
            else if (parent.left == cur)
                parent.left = child;
            else
                parent.right = child;

            rebalance(stack);
        }
        // ---------- REBALANCE ----------
        void rebalance(Stack<Node> stack) {
            while (!stack.isEmpty()) {
                Node node = stack.pop();
                updateHeight(node);
                int balance = getBalance(node);
                if (balance > 1) {
                    if (getBalance(node.left) < 0)
                        node.left = leftRotate(node.left);
                    node = rightRotate(node);
                }
                else if (balance < -1) {
                    if (getBalance(node.right) > 0)
                        node.right = rightRotate(node.right);
                    node = leftRotate(node);
                }
                if (stack.isEmpty()) {
                    root = node;
                } else {
                    Node parent = stack.peek();
                    if (parent.left == null || parent.left.data == node.data)
                        parent.left = node;
                    else
                        parent.right = node;
                }
            }
        }
        // ---------- TRAVERSALS ----------
        public void inorder() {
            inorder(root);
            System.out.println();
        }

        void inorder(Node n) {
            if (n == null) return;
            inorder(n.left);
            System.out.print(n.data + " ");
            inorder(n.right);
        }
        public void levelOrder() {
            if (root == null) return;
            Queue<Node> q = new ArrayDeque<>();
            q.add(root);
            while (!q.isEmpty()) {
                Node n = q.poll();
                System.out.print(n.data + " ");
                if (n.left != null) q.add(n.left);
                if (n.right != null) q.add(n.right);
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AVL tree = new AVL();
        int ch;
        do {
            System.out.println("\n----- AVL Search Tree Operations Menu -----");
            System.out.println("1. Insert ");
            System.out.println("2. Delete ");
            System.out.println("3. Inorder ");
            System.out.println("4. LevelOrder");
            System.out.println("5. Exit");
            System.out.print("Choice: ");
            ch = sc.nextInt();
            switch (ch) {
                case 1 -> tree.insert(sc.nextInt());
                case 2 -> tree.delete(sc.nextInt());
                case 3 -> tree.inorder();
                case 4 -> tree.levelOrder();
                case 5 -> break;
            }
        } while (ch != 5);
        sc.close();
    }
}