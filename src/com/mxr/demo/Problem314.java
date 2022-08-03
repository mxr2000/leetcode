package com.mxr.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem314 {

    public List<List<Integer>> verticalOrder(TreeNode root) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<Object[]> row = new ArrayList<>();
        if (root != null) {
            row.add(new Object[]{0, root});
        }
        while (!row.isEmpty()) {
            List<Object[]> newRow = new ArrayList<>();
            for (Object[] objs : row) {
                int col = (Integer) objs[0];
                TreeNode node = (TreeNode) objs[1];
                if (!map.containsKey(col)) {
                    map.put(col, new ArrayList<>());
                }
                map.get(col).add(node.val);
                if (node.left != null) {
                    newRow.add(new Object[]{col - 1, node.left});
                }
                if (node.right != null) {
                    newRow.add(new Object[]{col + 1, node.right});
                }
            }
            row = newRow;
        }
        return map.keySet().stream().sorted().map(map::get).toList();
    }

    public static void main(String[] args) {
        TreeNode root = TreeGenerator.generate(new Integer[]{3, 9, 8, 4, 0, 1, 7});
        System.out.println((new Problem314()).verticalOrder(root));
    }
}
