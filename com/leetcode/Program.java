
package com.leetcode;

import java.util.*;


class Program {
    // Evaluates the string expr returning the boolean value
    // using left to right evaluation with no order of operations
    private boolean evaluate(String expr) {
        Stack<String> stack = new Stack<>();
        //Split on space
        String[] exprArr = expr.split(" ");
        String leftOperand, rightOperand, op;

        for(String exp : exprArr) {
            stack.push(exp);

            if (stack.size() > 2) {
                // pop everything off
                rightOperand = stack.pop();
                op = stack.pop();
                leftOperand = stack.pop();

                // evaluate & push
                String result;
                if(op == "|") {
                    result = String.valueOf(Boolean.valueOf(leftOperand) || Boolean.valueOf(rightOperand));
                } else {
                    result = String.valueOf(Boolean.valueOf(leftOperand) && Boolean.valueOf(rightOperand));
                }
                stack.push(result);
            }
        }
        //Only result on top of stack
        return Boolean.valueOf(stack.peek());
    }

    // A helper for printing out results, do not modify.
    private void printEvaluate(String expr, boolean expected) {
        System.out.println("Evaluating " + expr + " -- Actual: " + evaluate(expr) + " Expected: " + expected);
    }

    public static void main(String[] args) {
        Program s = new Program();
        s.printEvaluate("true | false & false", false);
        s.printEvaluate("true", true);
        s.printEvaluate("false", false);
    }
}