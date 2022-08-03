package com.mxr.demo;

import java.util.ArrayList;
import java.util.List;

public class Problem1161 {
    public int maxLevelSum(TreeNode root) {
        int level = 0;
        int result = 0;
        int max = Integer.MIN_VALUE;
        List<TreeNode> row = new ArrayList<>();
        row.add(root);
        while (!row.isEmpty()) {
            ++level;
            List<TreeNode> newRow = new ArrayList<>();
            int sum = 0;
            for (TreeNode node : row) {
                sum += node.val;
                if (node.left != null) {
                    newRow.add(node.left);
                }
                if (node.right != null) {
                    newRow.add(node.right);
                }
            }
            if (sum > max) {
                max = sum;
                result = level;
            }
            row = newRow;
        }
        return result;
    }
}
