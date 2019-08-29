
package com.leetcode;

/**
 * Algo:
 * 1. Traverse from right and identify the element such that num[i] < num[i+1] i.e. it breaks descending rule
 * a) If match not found we have reached the last element, so reverse the order of all elements
 * b) If match found, then traverse from right and identify the first element say num[i+x] that is greater than num[i].
 *    Swap num[i] and num[i+x] and then reverse the order of elements to the right of num[i+x]
 */
public class Program {
    public static int[] nextPermutation(int[] nums) {
        //Match from right to find a pair that breaks descending
        boolean isMatch = false;
        int i=nums.length-2;
        for(;i>=0;i--) {
            if(nums[i]<nums[i+1]) {
                isMatch = true;
                break;
            }
        }
        if(isMatch) {
            //Now swap the pair
            int j=nums.length-1;
            for(;j>i;j--) {
                if(nums[i]<nums[j]) {
                    swap(nums, i,j);
                    break;
                }
            }
            //Reverse to the right of i till end
            reverse(nums, i+1, nums.length-1);
        } else {
            //No match simply reverse to get the next lexicographically order
            reverse(nums, 0, nums.length-1);
        }

        return nums;
    }

    private static void reverse(int[] nums, int s, int e) {
        while (s<e) {
            swap(nums, s, e);
            s++;
            e--;
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        //Tests
        nextPermutation(new int[] {1, 2, 5, 4}); //1, 4, 2, 5
    }
}