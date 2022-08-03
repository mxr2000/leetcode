package com.mxr.demo;

public class Problem1022 {
    public int sumRootToLeaf(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int sum) {
        sum = sum * 2 + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        }
        return (root.left == null ? 0 : dfs(root.left, sum)) + (root.right == null ? 0 : dfs(root.right, sum));
    }

    public static void main(String[] args) {
        TreeNode root = TreeGenerator.generate(new Integer[] {1, 0, 1, 0, 1, 0, 1});
        System.out.println((new Problem1022()).sumRootToLeaf(root));
    }
}
