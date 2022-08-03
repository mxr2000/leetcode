package com.mxr.demo;

import java.util.*;

public class Problem508 {
    private Map<Integer, Integer> map = new HashMap<>();

    public int[] findFrequentTreeSum(TreeNode root) {
        dfs(root);
        List<Integer> list = new ArrayList<>();
        int maxSize = 0;
        for (int sum : map.keySet()) {
            int cnt = map.get(sum);
            if (cnt > maxSize) {
                maxSize = cnt;
                list.clear();
                list.add(sum);
            } else if (cnt == maxSize) {
                list.add(sum);
            }
        }
        return list.stream().mapToInt(a -> a).toArray();
    }

    private Integer dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = root.val + dfs(root.left) + dfs(root.right);
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        return sum;
    }
}
