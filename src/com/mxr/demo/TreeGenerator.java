package com.mxr.demo;

import java.util.LinkedList;
import java.util.Queue;

public class TreeGenerator {
    public static TreeNode generate(Integer[] values) {
        if (values.length == 0) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(values[0]);
        queue.offer(root);
        int index = 1;
        while (index < values.length) {
            while (!queue.isEmpty()) {
                if (index >= values.length) {
                    break;
                }
                TreeNode node = queue.poll();
                if (values[index] != null) {
                    node.left = new TreeNode(values[index]);
                    queue.offer(node.left);
                }
                index++;
                if (index >= values.length) {
                    break;
                }
                if (values[index] != null) {
                    node.right = new TreeNode(values[index]);
                    queue.offer(node.right);
                }
                index++;
            }
        }
        return root;
    }

}
