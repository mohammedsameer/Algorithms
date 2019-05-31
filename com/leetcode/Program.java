
package com.leetcode;


import java.util.*;

/**
 * Algorithm:
 */
public class Program {

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        //Currset helps eliminate duplicates
        Set<List<Integer>> currSet = new HashSet<>();
        currSet.add(new ArrayList<>());

        result.addAll(currSet);
        for(int i=0; i<nums.length; i++) {
            //Initialize currset from prev result
            currSet = new HashSet<>(result);
            for(List<Integer> prev : result) {
                List<Integer> curr = new ArrayList<>(prev);
                curr.add(nums[i]);
                currSet.add(curr);
            }
            //We re-initialize and not addall because, add all appends where as re-initializes resets
            result = new ArrayList<>(currSet);
        }

        return result;
    }


    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        subsetsWithDup(new int[]{1,2,2});
    }
}