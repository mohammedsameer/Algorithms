package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.HashSet;

/**
 * Algorithm
 */
public class Program {

    public static List<List<Integer>> threeSum(int[] arr, int target) {
        if(arr == null || arr.length == 0)
            return null;

        List<List<Integer>> result = new ArrayList<>();
        HashSet<List<Integer>> set = new HashSet<>();
        Arrays.sort(arr);
        int i, j, k, sum;

        for(i =0; i < arr.length-2 ; i++) {
            j = i+1;
            k = arr.length - 1;

            while(j<k) {
                sum = arr[i] + arr[j] + arr[k];

                if(sum == target) {
                    List<Integer> currResult = Arrays.asList(arr[i], arr[j], arr[k]);
                    set.add(currResult);
                    j++;
                    k--;
                } else if (sum < target) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        result.addAll(set);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{1, 5, 4, 2, 7}, 9));
    }
}