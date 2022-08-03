package com.mxr.demo;

public class Problem111 {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        if (root.left == null) {
            return 1 + minDepth(root.right);
        } else if (root.right == null) {
            return 1 +  minDepth(root.left);
        }
        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }

    public static void main(String[] args) {
        TreeNode root = TreeGenerator.generate(new Integer[]{2,null,3,null,4,null,5,null,6});
        System.out.println((new Problem111()).minDepth(root));
    }
}
