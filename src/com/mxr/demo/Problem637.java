package com.mxr.demo;

import java.util.ArrayList;
import java.util.List;

public class Problem637 {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        List<TreeNode> row = new ArrayList<>();
        row.add(root);
        while (!row.isEmpty()) {
            int cnt = 0;
            long sum = 0;
            List<TreeNode> newRow = new ArrayList<>();
            for (TreeNode node : row) {
                ++cnt;
                sum += node.val;
                if (node.left != null) {
                    newRow.add(node.left);
                }
                if (node.right != null) {
                    newRow.add(node.right);
                }
            }
            result.add(sum * 1.0 / cnt);
            row = newRow;
        }
        return result;
    }
}
