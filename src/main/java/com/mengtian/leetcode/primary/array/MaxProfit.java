package com.mengtian.leetcode.primary.array;

/**
 * Created by mengtian on 2019/3/14
 */
public class MaxProfit {
    public static void main(String[] args) {
        int[] prices = new int[]{1, 2, 3, 4, 5};
        System.out.println(new MaxProfit().maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        int sum = 0;
        if (prices == null) return sum;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i + 1] > prices[i]) {
                sum += prices[i + 1] - prices[i];
            }
        }
        return sum;
    }
}
