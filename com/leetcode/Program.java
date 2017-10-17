package com.leetcode;

import java.util.*;

class Program {

    public static List<Integer> stack = new ArrayList<>();
    public static List<Integer> minStack = new ArrayList<>();

    public static void push(int val)
    {
        //Always add on primary stack
        stack.add(val);

        if(minStack.isEmpty()) {
            minStack.add(val);
        }
        else
        {
            if(getMin()>val)
                minStack.add(val);
        }
    }

    public static int pop()
    {
        int result = -1;
        if(!stack.isEmpty())
        {
            result = stack.remove(stack.size() - 1);
            if(getMin() == result)
            {
                minStack.remove(minStack.size() -1);
            }
        }

        return result;
    }

    public static int getMin()
    {
        int result = -1;
        if(!minStack.isEmpty()) {
            result = minStack.get(minStack.size()-1);
        }

        return result;
    }


    public static void main(String[] args) {

        //Add ontop of stack
        Program.push(10);
        Program.push(20);
        Program.push(-30);
        System.out.println("The min element:"+ Program.getMin());

    }
}