package com.mxr.demo;

public class Problem549 {
    private int result;

    public int longestConsecutive(TreeNode root) {
        dfs(root);
        return result;
    }

    private int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[]{-4000, 0, 0};
        }
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        int length = 1 + (right[0] == root.val + 1 ? right[2] : 0) + (left[0] == root.val - 1 ? left[1] : 0); // ->
        length = Math.max(length, 1 + (right[0] == root.val - 1 ? right[1] : 0) + (left[0] == root.val + 1 ? left[2] : 0)); // <-
        result = Math.max(result, length);
        int inc = 1 + Math.max(left[0] == root.val - 1 ? left[1] : 0, right[0] == root.val - 1 ? right[1] : 0);
        int dec = 1 + Math.max(left[0] == root.val + 1 ? left[2] : 0, right[0] == root.val + 1 ? right[2] : 0);
        return new int[]{root.val, inc, dec};
    }

    public static void main(String[] args) {
        TreeNode root = TreeGenerator.generate(new Integer[]{2, null, 3, 4, null, 1});
        System.out.println((new Problem549()).longestConsecutive(root));
    }
}
