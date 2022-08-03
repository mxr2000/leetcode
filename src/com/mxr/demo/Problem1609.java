package com.mxr.demo;

import java.util.ArrayList;
import java.util.List;

public class Problem1609 {
    public boolean isEvenOddTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean shouldIncrease = true;
        List<TreeNode> row = new ArrayList<>();
        row.add(root);
        while (!row.isEmpty()) {
            List<TreeNode> newRow = new ArrayList<>();
            for (int i = 0; i < row.size(); i++) {
                TreeNode node = row.get(i);
                if (shouldIncrease && node.val % 2 == 0) {
                    return false;
                }
                if (!shouldIncrease && node.val % 2 == 1) {
                    return false;
                }
                if (shouldIncrease && i > 0 && node.val <= row.get(i - 1).val) {
                    return false;
                }
                if (!shouldIncrease && i < row.size() - 1 && node.val <= row.get(i + 1).val) {
                    return false;
                }
                if (node.left != null) {
                    newRow.add(node.left);
                }
                if (node.right != null) {
                    newRow.add(node.right);
                }
            }

            row = newRow;
            shouldIncrease = !shouldIncrease;
        }
        return true;
    }
}
