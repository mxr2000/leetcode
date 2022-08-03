package com.mxr.demo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Problem797 {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> paths = new LinkedList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        dfs(paths, path, graph, 0);
        return paths;
    }
    private void dfs(List<List<Integer>> paths, List<Integer> path, int[][] graph, int current) {
        if (current == graph.length - 1) {
            System.out.println(path);
            paths.add(new ArrayList<>(path));
            return;
        }
        for (int neighbour : graph[current]) {
            if (path.contains(neighbour)) {
                continue;
            }
            path.add(neighbour);
            dfs(paths, path, graph, neighbour);
            path.remove((Integer) neighbour);
        }
    }

    public static void main(String[] args) {
        int[][] graph = {
                {4, 3, 1},
                {3, 2, 4},
                {3},
                {4},
                {}
        };
        System.out.println((new Problem797()).allPathsSourceTarget(graph));
    }
}
