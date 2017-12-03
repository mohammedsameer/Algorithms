package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Algorithm
 * 1. Run two loops
 * a) end=0 to end=str.length+1 (end index)
 * b) start=0 to start < end (start index)
 * 2. Compute substring and if substring in dictionary set f[end] = true
 * 3. If the complete string can be matched in dictionary then f[end] = true
 */
public class Program {

    public static boolean wordBreak(String str, List<String> wordDict) {
        boolean[] f = new boolean[str.length() + 1];
        f[0] = true;

        for(int end=1; end <= str.length(); end++){
            for(int start=0; start < end; start++){
                if(f[end] && wordDict.contains(str.substring(start, end))){
                    f[end] = true;
                    break;
                }
            }
        }

        return f[str.length()];
    }

    public static void main(String[] args) {
        List<String> dict  = new ArrayList<>();
        dict.add("leet");
        dict.add("code");
        System.out.println(wordBreak("leetcode", dict));
    }
}
