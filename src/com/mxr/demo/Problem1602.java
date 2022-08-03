package com.mxr.demo;

import java.util.ArrayList;
import java.util.List;

public class Problem1602 {

    public TreeNode findNearestRightNode(TreeNode root, TreeNode u) {
        if (root == null) {
            return null;
        }
        List<TreeNode> row = new ArrayList<>();
        row.add(root);
        while (!row.isEmpty()) {
            List<TreeNode> newRow = new ArrayList<>();
            for (int i = 0; i < row.size(); i++) {
                TreeNode node = row.get(i);
                if (node.val == u.val) {
                    return i == row.size() - 1 ? null : row.get(i + 1);
                }
                if (node.left != null) {
                    newRow.add(node.left);
                }
                if (node.right != null) {
                    newRow.add(node.right);
                }
            }
            row = newRow;
        }

        return null;
    }


}
