package com.mxr.demo;

public class Problem1372 {
    public int longestZigZag(TreeNode root) {
        return dfs(root)[2];
    }

    private int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[] {-1, -1, -1};
        }
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        int result = Math.max(Math.max(left[1], right[0]) + 1, Math.max(left[2], right[2]));
        return new int[] {left[1] + 1, right[0] + 1, result};
    }

    public static void main(String[] args) {
        TreeNode root = TreeGenerator.generate(new Integer[]{1, null, 1, 1, 1, null, null, 1, 1, null, 1, null, null, null, 1, null, 1});
        System.out.println((new Problem1372()).longestZigZag(root));
    }
}
