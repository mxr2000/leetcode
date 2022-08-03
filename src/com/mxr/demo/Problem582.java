package com.mxr.demo;

import java.util.*;

public class Problem582 {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        List<Integer> result = new ArrayList<>();

        Map<Integer, Integer> pidMap = new HashMap<>();
        Map<Integer, Integer> ppidMap = new HashMap<>();
        for (int i = 0; i < pid.size(); ++i) {
            pidMap.put(pid.get(i), i);
        }
        for (int i = 0; i < ppid.size(); ++i) {
            ppidMap.put(ppid.get(i), i);
        }
        Set<Integer> deleted = new HashSet<>();
        deleted.add(kill);


        return result;
    }
}
