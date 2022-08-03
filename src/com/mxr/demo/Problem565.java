package com.mxr.demo;

public class Problem565 {
    public int arrayNesting(int[] nums) {
        int n = nums.length;
        boolean[] visited = new boolean[n];
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            int length = 1;
            int cur = nums[i];
            while (cur != i) {
                ++length;
                visited[cur] = true;
                cur = nums[cur];
            }
            result = Math.max(result, length);
        }


        return result;
    }

    public static void main(String[] args) {
        int[] nums = {5, 4, 0, 3, 1, 6, 2};
        System.out.println((new Problem565()).arrayNesting(nums));
    }
}
