package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Algo:
 */
public class Program {

    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            if(!map.containsKey(num)) {
                int left = map.getOrDefault(num-1, 0);
                int right = map.getOrDefault(num+1, 0);
                int sum = left + right + 1;

                map.put(num, sum);

                max = Math.max(max, sum);

                map.put(num-left, sum);
                map.put(num+right, sum);
            }
        }
        return max;
    }

    public static void main(String[] args) {
    }

}