package com.mxr.demo;

public class Problem323 {
    public int countComponents(int n, int[][] edges) {
        int cnt = 0;
        int index = 0;
        int[] identities = new int[n];
        for (int i = 0; i < n; i++) {
            identities[i] = -1;
        }
        for (int[] edge : edges) {
            int i1 = edge[0];
            int i2 = edge[1];
            if (identities[i1] == -1 && identities[i2] == -1) {
                identities[i1] = index;
                identities[i2] = index;
                cnt++;
                index++;
            } else if (identities[i2] == -1) {
                identities[i2] = identities[i1];
            } else if (identities[i1] == -1) {
                identities[i1] = identities[i2];
            } else if (identities[i1] != identities[i2]) {
                int num = identities[i2];
                for (int i = 0; i < n; i++) {
                    if (identities[i] == num) {
                        identities[i] = identities[i1];
                    }
                }
                cnt--;
            }
        }
        for (int i = 0; i < n; i++) {
            if (identities[i] == -1) {
                cnt++;
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        int[][] edges = {
                {5, 6},
                {0, 2},
                {1, 7},
                {5, 9},
                {1, 8},
                {3, 4},
                {0, 6},
                {0, 7},
                {0, 3},
                {8, 9}

        };
        System.out.println((new Problem323()).countComponents(10, edges));
    }
}
