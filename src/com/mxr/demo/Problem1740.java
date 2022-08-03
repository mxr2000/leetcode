package com.mxr.demo;

public class Problem1740 {
    private int result = 0;

    public int findDistance(TreeNode root, int p, int q) {
        dfs(root, p, q);
        return result;
    }

    private int dfs(TreeNode root, int p, int q) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left, p, q);
        int right = dfs(root.right, p, q);
        if (root.val == q || root.val == p) {
            if (left != 0 || right != 0) {
                result = Math.max(left, right);
            } else {
                return 1;
            }
        }
        if (left != 0 && right != 0) {
            result = left + right;
        }
        int ret = Math.max(left, right);
        return ret == 0 ? 0 : ret + 1;
    }

    public static void main(String[] args) {
        TreeNode root = TreeGenerator.generate(new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4});
        System.out.println((new Problem1740()).findDistance(root, 5, 0));
    }
}
