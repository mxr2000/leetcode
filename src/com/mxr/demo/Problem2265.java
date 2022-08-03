package com.mxr.demo;

public class Problem2265 {
    public int averageOfSubtree(TreeNode root) {
        return dfs(root)[2];
    }

    private int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0, 0};
        }
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        int sum = left[0] + right[0] + root.val;
        int cnt = left[1] + right[1] + 1;
        int result = left[2] + right[2];
        int average = sum / cnt;
        if (root.val == average) {
            ++result;
        }
        return new int[]{sum, cnt, result};
    }

    public static void main(String[] args) {
        TreeNode root = TreeGenerator.generate(new Integer[]{4, 8, 5, 0, 1, null, 6});
        System.out.println((new Problem2265()).averageOfSubtree(root));
    }
}
