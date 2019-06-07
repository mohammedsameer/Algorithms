
package com.leetcode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Algorithm:
 */
public class Program {

    public static int maxProfit(int[] prices) {
        int firstBuy = Integer.MAX_VALUE;
        int secondBuy = Integer.MAX_VALUE;
        int firstSell = 0;
        int secondSell = 0;

        for(int i=0; i<prices.length; i++) {
            //First time: You buy and you sell
            firstBuy = Math.min(firstBuy, prices[i]);
            firstSell = Math.max(firstSell, prices[i] - firstBuy);

            //Second time: You buy after first sell
            secondBuy = Math.min(secondBuy, prices[i] - firstSell);
            secondSell = Math.max(secondSell, prices[i] - secondBuy);
        }

        return secondSell;
    }

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        maxProfit(new int[]{3,3,5,0,0,3,1,4});
    }
}