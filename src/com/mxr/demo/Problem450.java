package com.mxr.demo;

public class Problem450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val < key) {
            root.right = deleteNode(root.right, key);
            return root;
        }
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
            return root;
        }
        if (root.left == null && root.right == null) {
            return null;
        }
        if (root.left == null) {
            return root.right;
        }
        if (root.right == null) {
            return root.left;
        }
        TreeNode subRoot = getSubRootMin(root.right);
        subRoot.right = clearSubRootMin(root.right, subRoot);
        subRoot.left = root.left;
        return subRoot;
    }

    private TreeNode getSubRootMin(TreeNode root) {
        if (root.left == null) {
            return root;
        }
        return getSubRootMin(root.left);
    }

    private TreeNode clearSubRootMin(TreeNode root, TreeNode target) {
        if (root == null) {
            return null;
        }
        if (root.left == null) {
            if (root.right != null) {
                return root.right;
            } else {
                return null;
            }
        }
        root.left = clearSubRootMin(root.left, target);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = TreeGenerator.generate(new Integer[]{5, 3, 6, 2, 4, null, 7});
        TreeNode node = (new Problem450()).deleteNode(root, 5);
        System.out.println();
    }
}
