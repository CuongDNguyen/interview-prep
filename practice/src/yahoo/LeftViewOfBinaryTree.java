package yahoo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LeftViewOfBinaryTree {
    public static void main(String[] args) {

        TreeNode example1 = createTree1();
//        System.out.println("###Tree1###");
//        System.out.println("###DFS###");
//        example1.DFS(example1);
//        System.out.println("###BFS###");
//        example1.BFS(example1);
//        System.out.println("###Right View Of Tree###");
//        example1.printRightSideTree(example1);
//        System.out.println("###Left View of Tree###");
//        example1.printLeftSideTree(example1);

        TreeNode example2 = createTree2();
        System.out.println("###Tree2###");
        System.out.println("###DFS###");
        example2.DFS(example2);
        System.out.println("###BFS###");
        example2.BFS(example2);
        System.out.println("###Right View Of Tree###");
        example2.printRightSideTree(example2);
        System.out.println("###Left View of Tree###");
        example2.printLeftSideTree(example2);
    }
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
        static TreeNode addLeftRightChildren(TreeNode current, Integer left, Integer right) {
            if (left != null) {
                current.left = new TreeNode(left);
            } else {
                current.left = null;
            }

            if (right != null) {
                current.right = new TreeNode(right);
            } else {
                current.right = null;
            }

            return current;
        }

        static void DFS(TreeNode tree) {
            if (tree == null ) {
                return;
            }
            System.out.println(tree.val);
            DFS(tree.left);
            DFS(tree.right);
        }

        static void BFS(TreeNode tree) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(tree);

            while (!queue.isEmpty()) {
                TreeNode current = queue.poll();
                System.out.println(current.val);

                if (current.left != null) {
                    queue.add(current.left);
                }

                if (current.right != null) {
                    queue.add(current.right);
                }
            }
        }

        static void printRightSideTree(TreeNode tree) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(tree);
            while (!queue.isEmpty()) {
                int n = queue.size();
                for (int i = 0; i < n; i++) {
                    TreeNode currentNode = queue.poll();

                    if (i == n - 1) {
                        System.out.println(currentNode.val);
                    }

                    if (currentNode.left != null) {
                        queue.add(currentNode.left);
                    }

                    if (currentNode.right != null) {
                        queue.add(currentNode.right);
                    }
                }
            }
        }

        static void printLeftSideTree(TreeNode tree) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(tree);
            while (!queue.isEmpty()) {
                int n = queue.size();
                for (int i = 1; i <= n; i++) {
                    TreeNode currentNode = queue.poll();

                    if (i == 1) {
                        System.out.println(currentNode.val);
                    }

                    if (currentNode.left != null) {
                        queue.add(currentNode.left);
                    }

                    if (currentNode.right != null) {
                        queue.add(currentNode.right);
                    }
                }
            }
        }
    }

    /*
    4
   5  2
     3 1
    6 7
     */
    static TreeNode createTree1 () {
        TreeNode tree = new TreeNode(4, new TreeNode(5), new TreeNode(2));
        tree.right = TreeNode.addLeftRightChildren(tree.right, 3, 1);
        tree.right.left = TreeNode.addLeftRightChildren(tree.right.left, 6, 7);
        return tree;
    }

    static TreeNode createTree2() {
        TreeNode tree = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        tree.left = TreeNode.addLeftRightChildren(tree.left, 4, 5);
        tree.right = TreeNode.addLeftRightChildren(tree.right, 6, 7);
        tree.right.right = TreeNode.addLeftRightChildren(tree.right.right, null, 8);
        return tree;
    }
}
