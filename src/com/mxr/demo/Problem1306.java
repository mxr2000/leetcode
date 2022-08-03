package com.mxr.demo;

import java.util.LinkedList;
import java.util.Queue;

public class Problem1306 {
    public boolean canReach(int[] arr, int start) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[arr.length];
        visited[start] = true;
        queue.add(start);
        while (!queue.isEmpty()) {
            int p = queue.poll();
            if (arr[p] == 0) {
                return true;
            }
            int newP = p + arr[p];
            if (newP < arr.length && !visited[newP]) {
                queue.offer(newP);
                visited[newP] = true;
            }
            newP = p - arr[p];
            if (newP >= 0 && !visited[newP]) {
                queue.offer(newP);
                visited[newP] = true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 3, 0, 3, 1, 2};
        System.out.println((new Problem1306()).canReach(arr, 5));
    }
}
