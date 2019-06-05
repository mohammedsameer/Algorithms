
package com.leetcode;


import java.util.Stack;

/**
 * Algorithm:
 */
public class Program {

    public static int largestRectangle(int[] heights) {

        if(heights.length == 0)
            return 0;

        //Maintain stack with indexes for computing width
        Stack<Integer> stack = new Stack<>();
        int maxArea = Integer.MIN_VALUE;
        int index = 0;
        while (index<heights.length) {
            if(stack.isEmpty() || heights[index] > heights[stack.peek()]) {
                //If empty stack or curr height is greater than prev height in stack, continue adding on stack and move to next index
                stack.push(index);
                index++;
            } else {
                //If stack is non-empty and current element smaller than previous element compute area
                int h = heights[stack.pop()];//Previous height
                int w = stack.isEmpty() ? index : index-1-stack.peek();
                maxArea = Math.max(maxArea, h * w);
            }
        }

        while (!stack.isEmpty()) {
            int h = heights[stack.pop()];//Previous height
            int w = stack.isEmpty() ? index : index-1-stack.peek();
            maxArea = Math.max(maxArea, h * w);
        }

        return maxArea;

    }

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        largestRectangle(new int[]{2,3,1});
    }
}