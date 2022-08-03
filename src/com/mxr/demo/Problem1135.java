package com.mxr.demo;

import java.util.*;

public class Problem1135 {
    static class Tree {
        Set<Integer> nodes = new HashSet<>();
        int sum = 0;
    }
    public int minimumCost(int n, int[][] connections) {
        Arrays.sort(connections, (c1, c2) -> {
            Integer i1 = c1[2];
            Integer i2 = c2[2];
            return i1.compareTo(i2);
        });
        Set<Tree> trees = new HashSet<>();
        for (int[] con : connections) {
            Tree tree1 = null;
            Tree tree2 = null;
            for (Tree tree : trees) {
                if (tree.nodes.contains(con[0])) {
                    tree1 = tree;
                }
                if (tree.nodes.contains(con[1])) {
                    tree2 = tree;
                }
            }
            if (tree1 == null && tree2 == null) {
                Tree tree = new Tree();
                tree.nodes.add(con[0]);
                tree.nodes.add(con[1]);
                tree.sum += con[2];
                trees.add(tree);
            } else if (tree1 == tree2) {
                continue;
            } else if (tree1 != null && tree2 != null) {
                trees.remove(tree2);
                tree1.nodes.addAll(tree2.nodes);
                tree1.sum += tree2.sum;
                tree1.sum += con[2];
            } else if (tree1 != null) {
                tree1.nodes.add(con[1]);
                tree1.sum += con[2];
            } else if (tree2 != null) {
                tree2.nodes.add(con[0]);
                tree2.sum += con[2];
            }
        }
        if (trees.size() == 1) {
            Tree tree = trees.iterator().next();
            if (tree.nodes.size() == n) {
                return tree.sum;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] connections =
                {{2,1,87129},{3,1,14707},{4,2,34505},{5,1,71766},{6,5,2615},{7,2,37352}};
        System.out.println((new Problem1135()).minimumCost(7, connections));
        System.out.println();
    }
}
