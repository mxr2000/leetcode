package com.mxr.demo;

public class Problem109 {
    public TreeNode sortedListToBST(ListNode head) {
        return head == null ? null : dfs(head, null);
    }

    private TreeNode dfs(ListNode from, ListNode to) {
        if (from == null) {
            return null;
        }
        ListNode fast = from;
        ListNode slow = from;
        while (fast != to && fast.next != to) {
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode root = new TreeNode(from.val);
        root.left = dfs(from, slow);
        root.right = dfs(slow, to);
        return root;
    }


}
