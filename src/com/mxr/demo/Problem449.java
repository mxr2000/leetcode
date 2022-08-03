package com.mxr.demo;

import java.util.Arrays;
import java.util.List;

public class Problem449 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        return root.val + "," +
                serialize(root.left) +
                serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if ("".equals(data)) {
            return null;
        }
        String[] parts = data.split(",");
        if (parts.length == 0) {
            return null;
        }
        List<Integer> values = Arrays.stream(parts).map(Integer::parseInt).toList();
        return deserialize(values, 0, values.size());
    }

    private TreeNode deserialize(List<Integer> values, int from, int to) {
        if (to <= from) {
            return null;
        }
        TreeNode root = new TreeNode();
        root.val = values.get(from);
        int mid = from + 1;
        for (; mid < to; mid++) {
            if (values.get(mid) > root.val) {
                break;
            }
        }
        root.left = deserialize(values, from + 1, mid);
        root.right = deserialize(values, mid, to);
        return root;
    }

    public static void main(String[] args) {
        Problem449 problem449 = new Problem449();
        /*TreeNode root = TreeGenerator.generate(new Integer[] {2, 1, 3});

        String str = problem449.serialize(root);
        System.out.println(str);
        TreeNode node = problem449.deserialize(str);
        System.out.println(root);*/

        System.out.println(problem449.deserialize(problem449.serialize(null)));
    }
}
