package com.mxr.demo;

public class Problem1120 {
    private double result = 0;
    public double maximumAverageSubtree(TreeNode root) {
        dfs(root);
        return result;
    }

    private int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[] {0, 0};
        }
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        int sum = root.val + left[0] + right[0];
        int cnt = 1 + left[1] + right[1];
        result = Math.max(result, (1.0 * sum) / cnt);
        return new int[] {sum, cnt};
    }
}
