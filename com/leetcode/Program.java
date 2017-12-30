package com.leetcode;

/**
 * Algo:
 */
public class Program {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s==null)
            return true;
        if(t==null)
            return true;
        return isMatching(s, t) || isSubtree(s.left, t) || isSubtree(s.right,t);
    }

    private boolean isMatching(TreeNode s, TreeNode t) {
        if(s==null && t==null) return true;
        if(s==null || t==null) return false;
        if(s.val != t.val) return false;
        return isMatching(s.left, t.left) && isMatching(s.right, t.right);
    }

    public static void main(String[] args) {
    }
}