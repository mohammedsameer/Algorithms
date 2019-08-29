package com.leetcode;


import java.util.Stack;

/**
 * Algo:
 * 1. Move elements from pStack to sStack such that they are stored in sorted order in sStack
 * 2. Exit condition is pStack is empty
 */
public class Program {

    Stack<Integer> sStack = new Stack<>();

    public void sort(Stack<Integer> pStack) {
        while (!pStack.isEmpty()) {
            int value = pStack.pop();
            while (!sStack.isEmpty() && sStack.peek() < value) {
                pStack.push(sStack.pop());
            }
            sStack.push(value);
        }
    }

    public static void main(String[] args) {

    }
}