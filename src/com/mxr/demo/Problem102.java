package com.mxr.demo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();
        if (root == null) {
            return results;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean isLeft = true;
        while (!queue.isEmpty()) {
            List<Integer> result = new ArrayList<>();
            int cnt = queue.size();
            for (int i = 0; i < cnt; i++) {
                TreeNode node = queue.poll();
                result.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            results.add(result);
        }

        return results;
    }

    public static void main(String[] args) {
        TreeNode node = TreeGenerator.generate(new Integer[]{});
        System.out.println((new Problem102()).levelOrder(node));
    }
    static void print(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.println(node.val);
        print(node.left);
        print(node.right);
    }
}
