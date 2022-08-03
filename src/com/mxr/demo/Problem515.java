package com.mxr.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Problem515 {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        if (root == null) {
            return results;
        }
        List<TreeNode> row = new ArrayList<>();
        row.add(root);
        while (!row.isEmpty()) {
            Optional<Integer> max = row.stream().map(n -> n.val).reduce((a, b) -> Integer.max(a, b));
            results.add(max.get());
            List<TreeNode> newRow = new ArrayList<>();
            for (TreeNode node : row) {
                if (node.left != null) {
                    newRow.add(node.left);
                }
                if (node.right != null) {
                    newRow.add(node.right);
                }
            }
            row = newRow;
        }
        return results;
    }

    public static void main(String[] args) {
        TreeNode root = TreeGenerator.generate(new Integer[]{1, 2, 3});
        System.out.println((new Problem515()).largestValues(root));
    }
}
