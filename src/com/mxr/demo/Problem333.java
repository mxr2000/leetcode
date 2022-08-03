package com.mxr.demo;

public class Problem333 {
    private int result = 0;

    public int largestBSTSubtree(TreeNode root) {
        dfs(root);
        return result;
    }

    private int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[] {0, 0, 0};
        }
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        if (left == null || right == null) {
            return null;
        }
        if ((left[2] != 0 && left[1] >= root.val) || (right[2] != 0 && right[0] <= root.val)) {
            return null;
        }
        int size = 1 + left[2] + right[2];
        result = Math.max(result, size);
        return new int[] {left[2] == 0 ? root.val : left[0], right[2] == 0 ? root.val : right[1], size};
    }

    public static void main(String[] args) {
        TreeNode root = TreeGenerator.generate(new Integer[] {4,2,7,2,3,5,null,2,null,null,null,null,null,1});
        System.out.println((new Problem333()).largestBSTSubtree(root));
    }
}
