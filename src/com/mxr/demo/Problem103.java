package com.mxr.demo;

import java.util.ArrayList;
import java.util.List;

public class Problem103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();
        List<TreeNode> row = new ArrayList<>();
        boolean towardsRight = true;
        if (root != null) {
            row.add(root);
        }
        while (!row.isEmpty()) {
            List<TreeNode> newRow = new ArrayList<>();
            List<Integer> result = new ArrayList<>();
            for (TreeNode node : row) {
                if (node.left != null) {
                    newRow.add(node.left);
                }
                if (node.right != null) {
                    newRow.add(node.right);
                }
            }

            for (int i = 0; i < row.size(); i++) {
                int index = towardsRight ? i : (row.size() - i - 1);
                result.add(row.get(index).val);
            }
            results.add(result);
            towardsRight = !towardsRight;
            row = newRow;
        }
        return results;
    }

    public static void main(String[] args) {
        TreeNode root = TreeGenerator.generate(new Integer[]{3, 9, 20, null, null, 15, 7});
        System.out.println((new Problem103()).zigzagLevelOrder(root));
    }
}
