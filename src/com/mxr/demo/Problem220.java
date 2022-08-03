package com.mxr.demo;

import java.util.HashMap;
import java.util.Map;

public class Problem220 {
    private long getId(int num, int size) {
        return num < 0 ? (num % size == 0 ? num / size : num / size - 1) : num / size;
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int bucketSize = t + 1;
        Map<Long, Long> buckets = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            long bucketId = getId(num, bucketSize);
            if (buckets.containsKey(bucketId)) {
                return true;
            }
            if (buckets.containsKey(bucketId - 1) && Math.abs(num - buckets.get(bucketId - 1)) <= t) {
                return true;
            }
            if (buckets.containsKey(bucketId + 1) && Math.abs(num - buckets.get(bucketId + 1)) <= t) {
                return true;
            }
            buckets.put(bucketId, (long) num);
            if (buckets.size() > k) {
                buckets.remove(getId(nums[i - k], bucketSize));
            }
        }
        return false;
    }
}
