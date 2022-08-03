package com.mxr.demo;

public class Problem114 {
    TreeNode current;
    TreeNode newRoot;
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        process(root);
        root.left = null;
        root.right = newRoot.right;
    }
    public void process(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        if (current == null) {
            newRoot = current = new TreeNode(root.val);
        } else {
            current = current.right = new TreeNode(root.val);
        }
        process(root.left);
        process(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = TreeGenerator.generate(new Integer[]{1,2,5,3,4,null,6});
        (new Problem114()).flatten(root);
        System.out.println();
    }
}
