package com.mxr.demo;

public class Problem124 {
    private static long MIN = -1000 * 3 * 10000;
    private long result = MIN;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return (int) result;
    }

    private long dfs(TreeNode root) {
        if (root == null) {
            return MIN;
        }
        long left = dfs(root.left);
        long right = dfs(root.right);
        long max = Math.max(root.val, root.val + Math.max(0, left) + Math.max(0, right));
        result = Math.max(result, max);
        return Math.max(root.val, Math.max(root.val + left, root.val + right));
    }

    public static void main(String[] args) {
        TreeNode root = TreeGenerator.generate(new Integer[]{-2, -1});
        System.out.println((new Problem124()).maxPathSum(root));
    }
}
