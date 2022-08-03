package com.mxr.demo;

public class Problem889 {
    private int preIndex, postIndex;
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        TreeNode root = new TreeNode(preorder[preIndex++]);
        if (root.val != postorder[postIndex]) {
            root.left = constructFromPrePost(preorder, postorder);
        }
        if (root.val != postorder[postIndex]) {
            root.right = constructFromPrePost(preorder, postorder);
        }
        postIndex++;
        return root;
    }


    public static void main(String[] args) {
        int[] preorder = {1,2,4,5,3,6,7}, postorder = {4,5,2,6,7,3,1};
        TreeNode root = (new Problem889()).constructFromPrePost(preorder, postorder);
        System.out.println(root.val);
    }
}
