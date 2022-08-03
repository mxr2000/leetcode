package com.mxr.demo;

public class Problem543 {

    int max = 0;
    private int process(TreeNode root) {
        int left = root.left == null ? 0 : 1 + process(root.left);
        int right = root.right == null ? 0 : 1 + process(root.right);
        max = Math.max(max, left + right);
        return Math.max(left, right);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        process(root);
        return max;
    }

    public static void main(String[] args) {
        TreeNode root = TreeGenerator.generate(new Integer[]{1, 2, 3, 4, 5});
        System.out.println((new Problem543()).diameterOfBinaryTree(root));
    }
}
