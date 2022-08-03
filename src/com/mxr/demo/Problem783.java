package com.mxr.demo;

public class Problem783 {
    private int result = Integer.MAX_VALUE;

    public int minDiffInBST(TreeNode root) {
        if (root != null) {
            dfs(root);
        }
        return result;
    }

    private int[] dfs(TreeNode root) {
        int min = root.val, max = root.val;
        if (root.left != null) {
            int[] left = dfs(root.left);
            result = Math.min(result, root.val - left[1]);
            min = left[0];
        }
        if (root.right != null) {
            int[] right = dfs(root.right);
            result = Math.min(result, right[0] - root.val);
            max = right[1];
        }
        return new int[]{min, max};
    }

    public static void main(String[] args) {
        TreeNode root = TreeGenerator.generate(new Integer[]{4, 2, 6, 1, 3});
        System.out.println((new Problem783()).minDiffInBST(root));
    }
}
