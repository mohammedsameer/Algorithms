package com.leetcode;


/**
 * Algo:
 *     IF the set "ones" does not have num[i]
 *      Add num[i] to the set "ones" if and only if its not there in set "twos"
 *     ELSE
 *      Remove it from the set "ones"
 *
 *     IF the set "twos" does not have num[i]
 *      Add num[i] to the set "twos" if and only if its not there in set "ones"
 *     ELSE
 *      Remove it from the set "twos"
 *
 *  Hence, if the element appears once its in ones, if the element appears twice its in twos but not in ones
 *  If the element appears thrice then its not in either because
 *  a) Ones does not have it but its in twos, hence do not add to ones
 *  b) Twos has it so remove it from twos
 */
public class Program {
    public static int singleNumber(int[] nums) {
        int ones = 0;
        int twos = 0;
        //first bit: 0->1->0
        //sec bit:   0->0->1
        for(int i=0; i<nums.length; i++) {
            ones = (ones ^ nums[i]) & ~twos;
            twos = (twos ^ nums[i]) & ~ones;
        }

        return ones;
    }

    public static void main(String[] args) {
        singleNumber(new int[] {2,2,3,2});
    }
}