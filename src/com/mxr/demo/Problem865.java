package com.mxr.demo;

public class Problem865 {
    private TreeNode result = null;
    private int minUpDepth = Integer.MAX_VALUE;

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        int maxDepth = getDepth(root);
        dfs(root, 0, maxDepth);
        return result;
    }

    private int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(getDepth(root.left), getDepth(root.right));
    }

    private boolean dfs(TreeNode root, int upDepth, int targetDepth) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            if (upDepth + 1 == targetDepth) {
                if (upDepth < minUpDepth) {
                    minUpDepth = upDepth;
                    result = root;
                }
                return true;
            }
            return false;
        }
        boolean leftRet = dfs(root.left, upDepth + 1, targetDepth);
        boolean rightRet = dfs(root.right, upDepth + 1, targetDepth);
        boolean ret = leftRet && rightRet;
        if (ret && upDepth < minUpDepth) {
            minUpDepth = upDepth;
            result = root;
        }
        return ret;
    }

    public static void main(String[] args) {
        TreeNode root = TreeGenerator.generate(new Integer[]{0, 1, 3, null, 2});
        TreeNode result = (new Problem865()).subtreeWithAllDeepest(root);
        System.out.println(result.val);
    }
}
