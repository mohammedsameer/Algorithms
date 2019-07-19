package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Algo:
 */
public class Program {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        rightSideViewHelper(root, result, 0);
        return result;
    }

    private static void rightSideViewHelper(TreeNode root, List<Integer> result, int currDepth) {
        if(root == null)
            return;

        if(result.size() == currDepth)
            result.add(root.val);

        rightSideViewHelper(root.right, result, currDepth+1);
        rightSideViewHelper(root.left, result, currDepth+1);
    }

    public static void main(String[] args) {
    }
}