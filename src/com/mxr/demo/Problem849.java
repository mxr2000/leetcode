package com.mxr.demo;

public class Problem849 {
    public int maxDistToClosest(int[] seats) {
        int left = 0, right = 0;
        int result = 0;
        while (right < seats.length) {
            while (left < right && seats[left] == 1) {
                ++left;
            }
            if (seats[left] == 0 && seats[right] == 0) {
                int length = 0;
                if (left == 0) {
                    length = right + 1;
                } else if (right == seats.length - 1) {
                    length = seats.length - left;
                } else {
                    length = right - left + 1;
                    if (length % 2 == 0) {
                        length = length / 2;
                    } else {
                        length = length / 2 + 1;
                    }
                }
                result = Math.max(result, length);
            } else {
                left = right;
            }
            ++right;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] seats = {0, 1, 1, 1, 0, 0, 1, 0, 0};
        System.out.println((new Problem849()).maxDistToClosest(seats));
    }
}
