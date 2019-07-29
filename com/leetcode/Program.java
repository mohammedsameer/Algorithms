package com.leetcode;

import java.util.*;

//Algo:
class Program {

    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> result = new ArrayList<>();

        for(int i=0; i<input.length(); i++) {
            char c = input.charAt(i);
            if ( c == '+' || c == '-' || c == '*') {
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i+1));

                for (int l : left) {
                    for (int r : right) {
                        switch (c) {
                            case '+': result.add(l + r); break;
                            case '-': result.add(l - r); break;
                            case '*': result.add(l * r); break;
                        }
                    }
                }
            }
        }

        if (result.isEmpty())
            result.add(Integer.parseInt(input));

        return result;
    }


    public static void main(String[] args) {
    }
}
