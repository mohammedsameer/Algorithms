
package com.leetcode;


/**
 * Algorithm:
 */
public class Program {

    public static int singleNumber(int[] nums) {
        int ones = 0;
        int twos = 0;
        //00->01->10
        //first bit: 0->1->0
        //sec bit:   0->0->1
        for(int i=0; i<nums.length; i++) {
            ones = (ones ^ nums[i]) & ~twos;
            twos = (twos ^ nums[i]) & ~ones;
        }

        return ones;
    }

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        singleNumber(new int[]{1,2,1,1});
    }
}