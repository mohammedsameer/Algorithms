package com.leetcode;

import java.util.*;

/**
 * Algo:
 */
public class Program {

    public static int bfs(int[][] intervals, int source, int destination) {
        Map<Integer, PriorityQueue<int[]>> map = new HashMap<>();

        for (int[] interval : intervals) {
            map.putIfAbsent(interval[0], new PriorityQueue<>((a, b) -> (b[2]-a[2])));
            map.get(interval[0]).add(new int[] {interval[1], interval[2]});
        }

        Stack<int[]> stack = new Stack<>();
        int maximumLatency = 0;
        stack.push(new int[]{0, source});

        while (!stack.isEmpty()) {
            int[] next = stack.peek();
            boolean isDestination = (next[1] == destination);

            if(!isDestination && map.containsKey(next[1]) && !map.get(next[1]).isEmpty()) {
                int[] curr = map.get(next[1]).poll();
                stack.push(new int[] {curr[1], curr[0]});
            } else {
                maximumLatency += stack.pop()[0];
            }
        }

        return maximumLatency;

    }

    public static void main(String[] args) {
    }

}