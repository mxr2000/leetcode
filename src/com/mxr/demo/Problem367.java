package com.mxr.demo;

public class Problem367 {
    public boolean isPerfectSquare(int num) {
        long from = 1;
        long to = num;
        while (to >= from) {
            if (to == from + 1) {
                return num == to * to || num == from * from;
            }
            long mid = (from + to) / 2;
            if (num == mid * mid) {
                return true;
            } else if (num > mid * mid) {
                from = mid;
            } else {
                to = mid;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println((new Problem367()).isPerfectSquare(2147483647));
    }
}
