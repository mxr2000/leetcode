package com.mxr.demo;

import java.util.LinkedList;
import java.util.Queue;

public class CBTInserter {
    Queue<TreeNode> queue = new LinkedList<>();
    TreeNode top = null;
    public CBTInserter(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> temp = new LinkedList<>();
        temp.add(root);
        while (!temp.isEmpty()) {
            TreeNode node = temp.poll();
            insert(node.val);
            if (node.left != null) {
                temp.add(node.left);
            }
            if (node.right != null) {
                temp.add(node.right);
            }
        }
    }

    public int insert(int val) {
        if (top == null) {
            top = new TreeNode(val);
            queue.offer(top);
            return 0;
        }
        TreeNode node = new TreeNode(val);
        TreeNode parent = queue.peek();
        if (parent.left == null) {
            parent.left = node;
        } else {
            parent.right = node;
            queue.poll();
        }
        queue.add(node);
        return parent.val;
    }

    public TreeNode get_root() {
        return top;
    }

    public static void main(String[] args) {
        CBTInserter inserter = new CBTInserter(TreeGenerator.generate(new Integer[] {1, 2}));
        inserter.insert(3);
        inserter.insert(4);
        TreeNode root = inserter.get_root();
        System.out.println(root.val);
    }
}
