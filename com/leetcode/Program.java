package com.leetcode;

/**
 * Algorithm
 * Recursion
 * 1. root == null (Base condition)
 * 2. root.left == null && root.right == null (Optional base condition)
 */
public class Program {

 public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
 }

    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;

        if(root.left == null && root.right == null)
            return 1;

        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public static void main(String[] args) {
       System.out.println();
    }
}