package com.mxr.demo;

import java.util.*;

public class Problem82 {
    public ListNode deleteDuplicates(ListNode head) {
        List<Integer> nums = new ArrayList<>();
        Map<Integer, Integer> visited = new HashMap<>();
        dfs(nums, visited, head);
        ListNode newHead = null, newTail = null;
        for (int num : nums) {
            if (visited.get(num) > 1) {
                continue;
            }
            if (newHead == null) {
                newHead = newTail = new ListNode(num);
            } else {
                newTail.next = new ListNode(num);
                newTail = newTail.next;
            }
        }

        return newHead;
    }

    private void dfs(List<Integer> list, Map<Integer, Integer> visited, ListNode head) {
        if (head == null) {
            return;
        }
        visited.put(head.val, visited.getOrDefault(head.val, 0) + 1);
        list.add(head.val);
        dfs(list, visited, head.next);
    }
}
