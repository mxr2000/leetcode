package com.mxr.demo;

public class Problem1026 {
    private int result = 0;

    public int maxAncestorDiff(TreeNode root) {
        if (root != null) {
            dfs(root);
        }
        return result;
    }

    private int[] dfs(TreeNode root) {
        int min = root.val, max = root.val;
        if (root.left != null) {
            int[] ret = dfs(root.left);
            min = Math.min(min, ret[0]);
            max = Math.max(max, ret[1]);
            result = Math.max(result, Math.max(Math.abs(root.val - min), Math.abs(max - root.val)));
        }
        if (root.right != null) {
            int[] ret = dfs(root.right);
            min = Math.min(min, ret[0]);
            max = Math.max(max, ret[1]);
            result = Math.max(result, Math.max(Math.abs(root.val - min), Math.abs(max - root.val)));
        }
        return new int[]{min, max};
    }

    public static void main(String[] args) {
        TreeNode root = TreeGenerator.generate(new Integer[]{8, 3, 10, 1, 6, null, 14, null, null, 4, 7, 13});
        System.out.println((new Problem1026()).maxAncestorDiff(root));
    }
}
