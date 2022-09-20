package blind75;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
Given the root of a binary tree, invert the tree, and return its root.
Example: Input: root = [4,2,7,1,3,6,9]
Output: [4,7,2,9,6,3,1]
 */
public class InvertBinaryTree {
    public static void main(String[] args) {
        BinaryTree root = new BinaryTree(4);
        root.left = new BinaryTree(2);
        root.right = new BinaryTree(7);
        root.left.left = new BinaryTree(1);
        root.left.right = new BinaryTree(3);

        root.right.right = new BinaryTree(9);
        root.right.left = new BinaryTree(6);
        System.out.println();
        BFS(root);
        invertTree(root);
        BFS(root);
    }
    static class BinaryTree {

        int val;
        BinaryTree left;
        BinaryTree right;
        BinaryTree() {

        }
        BinaryTree(int val) {
            this.val = val;
            left = null;
            right = null;
        }

        BinaryTree(int val, BinaryTree left, BinaryTree right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static void BFS(BinaryTree root) {
        Queue<BinaryTree> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            BinaryTree current = queue.poll();
            System.out.println(current.val);

            if( current.left != null) {
                queue.add(current.left);
            }

            if( current.right != null) {
                queue.add(current.right);
            }
        }
    }

    static BinaryTree invertTree(BinaryTree root) {
        if (root == null) {
            return null;
        }

        final Queue<BinaryTree> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            final BinaryTree node = queue.poll();
            final BinaryTree left = node.left;
            node.left = node.right;
            node.right = left;

            if (node.left != null) {
                queue.add(node.left);
            }

            if (node.right != null) {
                queue.add(node.right);
            }
        }

        return root;
    }
}
