package com.mxr.demo;

public class Problem814 {
    public TreeNode pruneTree(TreeNode root) {
        return dfs(root) ? null : root;
    }

    private boolean dfs(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean left = dfs(root.left);
        boolean right = dfs(root.right);
        if (left) {
            root.left = null;
        }
        if (right) {
            root.right = null;
        }
        return root.val == 0 && left && right;
    }
}
