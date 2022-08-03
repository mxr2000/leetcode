package com.mxr.demo;

import java.util.ArrayList;
import java.util.List;

public class Problem1302 {
    public int deepestLeavesSum(TreeNode root) {
        List<TreeNode> row = new ArrayList<>();
        row.add(root);
        int sum = 0;
        while (!row.isEmpty()) {
            List<TreeNode> newRow = new ArrayList<>();
            sum = 0;
            for (TreeNode node : row) {
                sum += node.val;
                if (node.left != null) {
                    newRow.add(node.left);
                }
                if (node.right != null) {
                    newRow.add(node.right);
                }
            }
            row = newRow;
        }
        return sum;
    }

    public static void main(String[] args) {
        TreeNode root = TreeGenerator.generate(new Integer[]{1, 2, 3, 4, 5, null, 6, 7, null, null, null, null, 8});
        System.out.println((new Problem1302()).deepestLeavesSum(root));
    }
}
