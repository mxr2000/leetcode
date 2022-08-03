package com.mxr.demo;

public class Problem1973 {
    private int result = 0;
    public int equalToDescendants(TreeNode root) {
        dfs(root);
        return result;
    }

    private int dfs(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        if (left + right == root.val) {
            ++result;
        }
        return root.val + left + right;
    }
}
