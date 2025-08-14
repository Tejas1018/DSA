package com.dsaPrep.Arrays;

public class BuyAndSellStock {
    //---- LeetCode Problem 121: Best Time to Buy and Sell Stock
    //---Brute Force Approach
    // Time Complexity: O(n^2)
    // Space Complexity: O(1)
    public int maxProfit(int[] prices) {
        int size = prices.length;
        int max_profit = 0;

        for(int i = 0 ; i < size; i++){
            int profit = 0;
            for(int j = i+1; j < size;j++){
                profit = prices[j] - prices[i];
                max_profit = Math.max(max_profit, profit);
            }

        }
        return max_profit;
    }

    //---Optimized Approach
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public int maxProfit1(int[] prices) {
        int len = prices.length;
        int minBuy = prices[0];
        int maxProfit = 0;
        for(int i = 1 ; i < len; i++){
            int profit = prices[i] - minBuy;
            maxProfit = Math.max(maxProfit,profit);
            minBuy = Math.min(minBuy,prices[i]);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        BuyAndSellStock stock = new BuyAndSellStock();
        int[] prices = {7,1,5,3,6,4};
        System.out.println("Maximum Profit (Optimized): " + stock.maxProfit1(prices));
    }
}
