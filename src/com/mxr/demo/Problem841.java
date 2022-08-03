package com.mxr.demo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem841 {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> visited = new HashSet<>();
        visit(visited, 0, rooms);
        return visited.size() == rooms.size();
    }
    private void visit(Set<Integer> visited, int index, List<List<Integer>> rooms) {
        visited.add(index);
        for (int key : rooms.get(index)) {
            if (visited.contains(key)) {
                continue;
            }
            visit(visited, key, rooms);
        }
    }
}
