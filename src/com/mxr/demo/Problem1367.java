package com.mxr.demo;

public class Problem1367 {
    public boolean isSubPath(ListNode head, TreeNode root) {
        return dfs(head, head, root);
    }

    private boolean dfs(ListNode head, ListNode current, TreeNode root) {
        if (current == null) {
            return true;
        }
        if (root == null) {
            return false;
        }
        if (current.val == root.val) {
            if (dfs(head, current.next, root.left) || dfs(head, current.next, root.right)) {
                return true;
            }
        }

        return dfs(head, current, root.left) || dfs(head, current, root.right);
    }


}
