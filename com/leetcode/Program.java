package com.leetcode;

import java.util.*;

/**
 * Algorithm
 * Sliding window
 */
public class Program {

    public static int lengthOfLongestSubstring(String str) {
        int result = 0;
        int len = str.length();
        Set<Character> resultSet = new HashSet<>();

        if(len == 0)
            return result;
        int i = 0, j = 0;
        while(i < len &&  j < len) {
            if(!resultSet.contains(str.charAt(j))) {
                resultSet.add(str.charAt(j++));
                result = Math.max(result, j - i);
            } else {
                resultSet.remove(str.charAt(i++));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("dvdf"));
    }
}