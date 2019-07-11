package com.leetcode;


/**
 * Algo:
 */
public class Program {
    public static int minCut(String s) {
        int n = s.length();
        boolean dp[][] = new boolean[n+1][n+1];
        int min[] = new int[n];
        for(int i=0; i<n; i++) {
            //Number of cuts at a given index is always atleast default is the index i.e. one character at a time
            int minCut = i;
            for(int j=0; j<=i; j++) {
                if(s.charAt(i) == s.charAt(j) && (i <= j+1 || dp[i-1][j+1])) {
                    dp[i][j] = true;
                    minCut = Math.min(minCut, j == 0 ? 0 : 1 + min[j - 1]);
                }
            }
            min[i] = minCut;
        }
        return min[n-1];
    }

    public static void main(String[] args) {
        minCut("aab");
    }
}