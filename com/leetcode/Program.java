package com.leetcode;

/**
 * Algorithm
 * 1. Use (n) * (n + 1)/2 to calculate sum of n numbers
 * 2. Subtract every number whats remainder is the number thats missing
 * Note: n starts with 1, hence if the remainder is 0 then it implies 0 is missing
 */
public class Program {

    public static int missingNumber(int[] nums) {
        int len = nums.length;
        int sum = (len) * (len + 1)/2;

        for(int i = 0; i < nums.length; i++) {
            sum -= nums[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(missingNumber(new int[] {3,0,1}));
    }
}