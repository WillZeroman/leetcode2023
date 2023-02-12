package io.github.willzeroman;

public class EvaluateTree {
    public boolean evaluateTree(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root.val == 1 ? true : false;
        }
        boolean leftValue = evaluateTree(root.left);
        boolean rightValue = evaluateTree(root.right);
        if (root.val == 2) {
            return leftValue || rightValue;
        } else {
            return leftValue && rightValue;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        root.val = 2;
        root.left = new TreeNode(1);
        root.right = new TreeNode(0);
        System.out.println(new EvaluateTree().evaluateTree(root));
    }
}
