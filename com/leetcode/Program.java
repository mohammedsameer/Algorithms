package com.leetcode;


import java.util.Arrays;
import java.util.Comparator;

//Algo:
//1. Sort in descending order but by concatinating two numbers and determining what comes first
class Program {

    //Comparator<T> is functional interface
    public static Comparator<String> stringComparator = (s1, s2) -> {
        String str1 = s1 + s2; // 20 + 3
        String str2 = s2 + s1; // 3 + 20
        return str2.compareTo(str1); //Descending sort 3, 20 descending order
    };

    public static String largestNumber(int[] nums) {
        StringBuilder sb = new StringBuilder();
        String[] strArr = new String[nums.length];
        for (int i = 0; i < strArr.length; i++) {
            strArr[i] = String.valueOf(nums[i]);
        }

        //Sort
        Arrays.sort(strArr, stringComparator);

        //Append
        for (int i=0; i<strArr.length; i++) {
            sb.append(strArr[i]);
        }

        //Remove any leading zero's & return result
        String result = sb.toString().replaceFirst("^0*", "");
        return result.isEmpty() ? "0" : result;
    }

    public static void main(String[] nums) {
        largestNumber(new int[] {0, 0});
    }
}