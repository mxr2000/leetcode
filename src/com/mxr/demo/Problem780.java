package com.mxr.demo;

public class Problem780 {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        while (tx > sx && ty > sy) {
            if (tx > ty) {
                tx %= ty;
            } else {
                ty %= tx;
            }
        }
        return (sx == tx && ty >= sy && (ty - sy) % sx == 0) || (sy == ty && tx >= sx && (tx - sx) % sy == 0);
    }

    private boolean backtrack(int sx, int sy, int tx, int ty) {
        if (sx > tx || sy > ty) {
            return false;
        } else if (sx == tx && sy == ty) {
            return true;
        }
        return backtrack(sx + sy, sy, tx, ty) || backtrack(sx, sy + sx, tx, ty);
    }

    public static void main(String[] args) {
        System.out.println((new Problem780()).reachingPoints(1, 1, 3, 5));
    }
}
