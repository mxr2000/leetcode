package com.mxr.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Problem297 {
    static class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder builder = new StringBuilder();
            List<TreeNode> row = new ArrayList<>();
            if (root != null) {
                row.add(root);
            }
            while (!row.isEmpty()) {
                List<TreeNode> newRow = new ArrayList<>();
                for (TreeNode node : row) {
                    if (node == null) {
                        builder.append("; ");
                        continue;
                    }
                    builder.append(node.val).append(" ");
                    newRow.add(node.left);
                    newRow.add(node.right);
                }
                row = newRow;
            }
            return builder.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            List<TreeNode> row = new ArrayList<>();
            List<TreeNode> newRow = new ArrayList<>();
            String[] parts = data.split(" ");
            if (parts.length == 0 || "".equals(parts[0])) {
                return null;
            }
            TreeNode root = new TreeNode();
            row.add(root);
            root.val = Integer.parseInt(parts[0]);
            int index = 0;
            for (int i = 1; i < parts.length; i++) {
                String part = parts[i];
                if (!";".equals(part)) {
                    int num = Integer.parseInt(part);
                    TreeNode parent = row.get(index / 2);
                    TreeNode child = new TreeNode();
                    child.val = num;
                    if (index % 2 == 0) {
                        parent.left = child;
                    } else {
                        parent.right = child;
                    }
                    newRow.add(child);
                }
                ++index;
                if (index == row.size() * 2) {
                    row.clear();
                    List<TreeNode> temp = row;
                    row = newRow;
                    index = 0;
                    newRow = temp;
                }
            }

            return root;
        }

        public static void main(String[] args) {
            TreeNode root = TreeGenerator.generate(new Integer[]{1, 2, 3, null, null, 4, 5});
            Codec codec = new Codec();
            String s = codec.serialize(root);
            System.out.println(s);
            System.out.println(codec.deserialize(s));
        }

    }
}
