import java.util.LinkedList;
import java.util.Stack;

public class BinaryTree {
    Node root;

    BinaryTree(int val) {
        this.root = new Node(val);
    }

    BinaryTree() {
        root = null;
    }

    static void BFS(Node root) {
        LinkedList<Node> queue = new LinkedList<>();

        queue.add(root);
        while(!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.println(current.val);

            if (current.left != null) {
                queue.add(current.left);
            }

            if (current.right != null) {
                queue.add(current.right);
            }
        }
    }
    static void DFS(Node root) {
        Stack<Node> stack = new Stack<>();

        Node current = root;
        while (!stack.isEmpty() || current != null) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            System.out.println(current.val);
            current = current.right;
        }
    }

    static void BFSIterative(Node root) {
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(root);
        while( !queue.isEmpty() ) {
            Node current = queue.poll();
            System.out.println(current.val);
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
    }
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.println("BFS.....");
        BFSIterative(tree.root);

        System.out.println("DFS....");
        DFS(tree.root);
    }
}

class Node {
    int val;
    Node left, right;
    Node (int value) {
        this.val = value;
        this.left = this.right= null;
    }
}
