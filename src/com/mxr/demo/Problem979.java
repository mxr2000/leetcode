package com.mxr.demo;

public class Problem979 {
    private int result = 0;

    public int distributeCoins(TreeNode root) {
        dfs(root);
        return result;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = distributeCoins(root.left);
        int right = distributeCoins(root.right);
        result += Math.abs(left);
        result += Math.abs(right);
        return left + right + root.val - 1;
    }
}
