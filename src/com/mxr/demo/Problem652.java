package com.mxr.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem652 {
    private final Map<TreeNode, String> dp = new HashMap<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> results = new ArrayList<>();
        postOrder(new HashMap<>(), results, root);
        return results;
    }

    private String postOrder(Map<String, Integer> map, List<TreeNode> results, TreeNode root) {
        if (root == null) {
            return "#";
        }
        if (dp.containsKey(root)) {
            return dp.get(root);
        }
        String val = root.val + " " + postOrder(map, results, root.left) + " " + postOrder(map, results, root.right);
        map.put(val, map.getOrDefault(val, 0) + 1);
        if (map.get(val) == 2) {
            results.add(root);
        }
        dp.put(root, val);
        return val;
    }

    public static void main(String[] args) {
        TreeNode root = TreeGenerator.generate(new Integer[]{1, 2, 3, 4, null, 2, 4, null, null, 4});
        System.out.println((new Problem652()).findDuplicateSubtrees(root));
    }
}
