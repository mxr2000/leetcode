package com.mxr.demo;

public class Problem106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, postorder, 0, inorder.length, 0, postorder.length);
    }

    private TreeNode buildTree(int[] inorder, int[] postorder, int inFrom, int inTo, int postFrom, int postTo) {
        if (inTo <= inFrom) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postTo - 1]);
        int inMiddle = inFrom;
        while (inorder[inMiddle] != root.val) {
            ++inMiddle;
        }
        root.left = buildTree(inorder, postorder, inFrom, inMiddle, postFrom, postFrom + (inMiddle - inFrom));
        root.right = buildTree(inorder, postorder, inMiddle + 1, inTo, postFrom + (inMiddle - inFrom), postTo - 1);
        return root;
    }

    public static void main(String[] args) {
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};
        System.out.println((new Problem106()).buildTree(inorder, postorder));
    }
}
