package blind75;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ValidateBST {
      static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
    public static void main(String[] args) {

    }

    static void inorderTraversal(TreeNode root)
    {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            System.out.println(list);
        }

        Stack<TreeNode> stack = new Stack<>();
        while ( root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            list.add(root.val);
            root = root.right;
        }
        System.out.println(list);
    }
}
