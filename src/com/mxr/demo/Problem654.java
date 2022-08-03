package com.mxr.demo;

public class Problem654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTree(nums, 0, nums.length);
    }

    private TreeNode constructMaximumBinaryTree(int[] nums, int from, int to) {
        if (to <= from) {
            return null;
        }
        int max = nums[from];
        int index = from;
        for (int i = from; i < to; i++) {
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }
        TreeNode node = new TreeNode();
        node.val = max;
        node.left = constructMaximumBinaryTree(nums, from, index);
        node.right = constructMaximumBinaryTree(nums, index + 1, to);
        return node;
    }

    public static void main(String[] args) {
        System.out.println((new Problem654()).constructMaximumBinaryTree(new int[]{3, 2, 1, 6, 0, 5}));
    }

}
