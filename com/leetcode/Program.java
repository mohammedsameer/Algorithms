package com.leetcode;

import java.util.*;

/**
 * Algorithm
 * 1. Maintain a map (sorted str, list)
 * 2. Loop through string array and check if the key exists in map, if yes add to list else create new entry
 */
public class Program {

    public static List<List<String>> groupAnagrams(String[] strs) {

        if(strs.length == 0)
            return new ArrayList<>();

        Map<String, List<String>> result = new HashMap<>();
        for(String str: strs) {
            char[] currArr = str.toCharArray();
            Arrays.sort(currArr);
            String currStr = String.valueOf(currArr);

            if(!result.containsKey(currStr)) {
                result.put(currStr, new ArrayList<>());
            }
            result.get(currStr).add(str);
        }

        return new ArrayList<>(result.values());
    }

    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }
}