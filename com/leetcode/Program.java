package com.leetcode;

import java.util.concurrent.*;

class Program {


    public static boolean isPowerOfTwo(int n) {
        if(n==1)
            return true;

        int[] powers = new int[n/2];
        powers[0] = 1;

        for(int i=1; i<=n/2; i++) {
            powers[i] = powers[i-1]*2;
            if (powers[i] == n)
                return true;
            else if (powers[i] > n)
                return false;
        }
        return false;
    }

    public static void main(String[] nums) {
        isPowerOfTwo(2);
    }

}

