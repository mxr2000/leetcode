package com.mxr.demo;

import java.util.ArrayList;
import java.util.List;

public class Problem993 {
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) {
            return false;
        }
        List<TreeNode> row = new ArrayList<>();
        row.add(root);
        while (!row.isEmpty()) {
            List<TreeNode> newRow = new ArrayList<>();
            int cnt = 0;
            for (TreeNode node : row) {
                boolean same = false;
                if (node.left != null) {
                    if (node.left.val == x || node.left.val == y) {
                        ++cnt;
                        same = true;
                    }
                    newRow.add(node.left);
                }
                if (node.right != null) {
                    if (!same && (node.right.val == x || node.right.val == y)) {
                        ++cnt;
                    }
                    newRow.add(node.right);
                }
            }
            if (cnt == 2) {
                return true;
            }
            row = newRow;
        }
        return false;
    }
}
