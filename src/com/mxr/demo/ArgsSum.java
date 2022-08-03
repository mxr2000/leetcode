package com.mxr.demo;

import java.util.Arrays;

public class ArgsSum {
    public static void main(String[] args) {
        System.out.println(Arrays.stream(args).map(Integer::parseInt).reduce(Integer::sum).orElse(0));
    }
}

