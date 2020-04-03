package com.hicsc;

public class BestTimetoBuyandSellStock121 {

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int maxProfit = 0;
        int slow = 0;
        for (int fast = 0; fast < prices.length; fast++) {
            if (prices[fast] < prices[slow]) {
                slow = fast;
            }
            maxProfit = Math.max(prices[fast] - prices[slow], maxProfit);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(maxProfit(new int[]{7, 6, 4, 3, 1}));
    }
}
