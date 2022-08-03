package com.mxr.demo;

public class Problem250 {
    private int result = 0;

    public int countUnivalSubtrees(TreeNode root) {
        isUnivalue(root);
        return result;
    }

    private boolean isUnivalue(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean left = isUnivalue(root.left);
        boolean right = isUnivalue(root.right);
        if (left && right) {
            if (root.left != null && root.left.val != root.val) {
                return false;
            }
            if (root.right != null && root.right.val != root.val) {
                return false;
            }
            ++result;
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode root = TreeGenerator.generate(new Integer[]{5, 1, 5, 5, 5, null, 5});
        System.out.println((new Problem250()).countUnivalSubtrees(root));
    }
}
