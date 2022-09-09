package com.mxr.demo;

public class Problem108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return nums.length == 0 ? null : build(nums, 0, nums.length - 1);
    }

    private TreeNode build(int[] nums, int from, int to) {
        if (from > to) {
            return null;
        }
        int mid = (from + to) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = build(nums, from, mid - 1);
        node.right = build(nums, mid + 1, to);
        return node;
    }
}
