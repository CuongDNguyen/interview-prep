/*
Check Balanced: Implement a function to check if a binary tree is balanced. For the purposes of
this question, a balanced tree is defined to be a tree such that the heights of the two subtrees of any
node never differ by more than one.

Example:            8
                1       3
             2   5    4     7
          3   2
       5   7

 */

class CheckBalanceTree {
    public static void main(String[] args) {
        TreeNode util = new TreeNode(9);

        TreeNode root = util.makeTestTree();
        root.viewTree(root);
    }

    void checkBalanceTree(TreeNode root) {

    }
}

class TreeNode {
    int val;
    TreeNode leftChild;
    TreeNode rightChild;

    TreeNode(int val) {
        this.val = val;
        this.leftChild = null;
        this.rightChild = null;
    }

    TreeNode(int val, TreeNode leftChild, TreeNode rightChild) {
        this.val = val;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    TreeNode makeSubTree(int val, int left, int right) {
        TreeNode newTree = new TreeNode(val, new TreeNode(left), new TreeNode(right));
        return newTree;
    }

    TreeNode makeTestTree() {
        TreeNode root = new TreeNode(8, leftChild, rightChild);
        TreeNode leftChild = makeSubTree(1, 2, 5);
        TreeNode rightChild = makeSubTree(3, 4, 7);

        root.leftChild.leftChild = makeSubTree(3, 5, 7);
        root.leftChild.rightChild = new TreeNode(2);

        return root;
    }

    void viewTree(TreeNode root) {
        if (root == null) {
            return;
        }

        viewTree(root.leftChild);
        System.out.println(root.val);
        viewTree(root.rightChild);
    }
}
