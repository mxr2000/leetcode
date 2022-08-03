package com.mxr.demo;

public class Problem1430 {
    public boolean isValidSequence(TreeNode root, int[] arr) {
        return dfs(root, arr, 0);
    }

    private boolean dfs(TreeNode root, int[] arr, int index) {
        if (index == arr.length - 1 && root != null && root.left == null && root.right == null && root.val == arr[index]) {
            return true;
        }
        if (root == null || index >= arr.length) {
            return false;
        }
        return root.val == arr[index] && (dfs(root.left, arr, index + 1) || dfs(root.right, arr, index + 1));
    }

    public static void main(String[] args) {
        TreeNode root = TreeGenerator.generate(new Integer[]{0, 1, 0, 0, 1, 0, null, null, 1, 0, 0});
        int[] arr = {0, 1, 0, 1};
        System.out.println((new Problem1430()).isValidSequence(root, arr));
    }
}
