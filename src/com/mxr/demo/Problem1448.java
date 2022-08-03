package com.mxr.demo;

public class Problem1448 {
    public int goodNodes(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE);
    }

    private int dfs(TreeNode root, int num) {
        if (root == null) {
            return 0;
        }
        int result = 0;
        if (root.val >= num) {
            ++result;
        }
        result += dfs(root.left, Math.max(root.val, num));
        result += dfs(root.right, Math.max(root.val, num));
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = TreeGenerator.generate(new Integer[]{3, 3, null, 4, 2});
        System.out.println((new Problem1448()).goodNodes(root));
    }
}
