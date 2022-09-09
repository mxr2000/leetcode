package com.mxr.demo;

public class Problem110 {
    public boolean isBalanced(TreeNode root) {
        return traverse(root) != -1;
    }

    private int traverse(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = traverse(root.left);
        int right = traverse(root.right);
        return (left == -1 || right == -1 || Math.abs(left - right) > 1) ? -1 : (1 + Math.max(left, right));
    }
}
