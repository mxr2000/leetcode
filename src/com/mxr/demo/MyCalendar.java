package com.mxr.demo;

import java.util.ArrayList;
import java.util.List;

public class MyCalendar {
    private List<int[]> periods = new ArrayList<>();
    public MyCalendar() {

    }

    public boolean book(int start, int end) {
        for (int[] period : periods) {
            if (start >= period[0] && start < period[1]) {
                return false;
            }
            if (end > period[0] && end <= period[1]) {
                return false;
            }
        }
        int[] formerPeriod = null;
        int[] latterPeriod = null;
        List<int[]> newPeriods = new ArrayList<>();
        for (int i = 0; i < periods.size(); i++) {
            int[] period = periods.get(i);
            if (period[1] == start) {
                formerPeriod = period;
            } else if (period[0] == end){
                latterPeriod = period;
            } else {
                newPeriods.add(periods.get(i));
            }
        }

        int[] merged = new int[2];
        if (formerPeriod != null) {
            merged[0] = formerPeriod[0];
        } else {
            merged[0] = start;
        }
        if (latterPeriod != null) {
            merged[1] = latterPeriod[1];
        } else {
            merged[1] = end;
        }
        newPeriods.add(merged);

        periods = newPeriods;
        return true;
    }

    public static void main(String[] args) {
        MyCalendar myCalendar = new MyCalendar();
        System.out.println(myCalendar.book(10, 20));
        System.out.println(myCalendar.book(15, 25));
        System.out.println(myCalendar.book(20, 30));
    }
}
