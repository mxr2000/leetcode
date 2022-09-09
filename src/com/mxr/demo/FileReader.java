package com.mxr.demo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FileReader {
    public void read() {
        List<String> result = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("a")));
            for (String line : reader.lines().toList()) {
                String[] parts = line.split(" ");
                int n = parts.length;
                if ("200".equals(parts[n - 2]) && "\"GET".equals(parts[n - 5])) {
                    result.add(parts[n - 4].split("/")[1]);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
