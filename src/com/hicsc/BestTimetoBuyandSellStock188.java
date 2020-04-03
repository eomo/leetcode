package hicsc;

public class BestTimetoBuyandSellStock188 {

    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        // 如果k大于天数的话,那么其实很简单,如果明天比今天价钱高,买卖就好,到最后一定是最大值
        // 方法类似于k无限制
        if (k > prices.length / 2) {
            int profit = 0;
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] > prices[i - 1]) {
                    profit += prices[i] - prices[i - 1];
                }
            }
            return profit;
        }
        // 如果k小于天数,使用DP
        // hold[i][j] =  第i天 交易j次 持有股票的最大利润
        // unhold[i][j] = 第i天 交易j次 不持有股票的最大利润
        // 买入股票当作交易(卖出时不计算次数)时，递推公式：
        //      hold[i][j] = max(hold[i-1][j], unhold[i-1][j-1]-price[i])
        //      第i天交易j次持有股票的最大利润 = max(前一天的hold, 前一天unhold[今天买入])
        //      unhold[i][j] = max(unhold[i-1][j], hold[i-1][j]+price[i])
        //      第i天交易j次不持有股票的最大利润 = max(前一天的unhold, 前一天的hold[今天卖出])
        int n = prices.length;
        int[][] hold = new int[n][k + 1];
        int[][] unhold = new int[n][k + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= k; j++) {
                if (i == 0) {
                    hold[i][j] = -prices[i];
                    unhold[i][j] = 0;
                } else {
                    hold[i][j] = Math.max(hold[i - 1][j], unhold[i - 1][j - 1] - prices[i]);
                    unhold[i][j] = Math.max(unhold[i - 1][j], hold[i - 1][j] + prices[i]);
                }
            }
        }
        return Math.max(hold[n-1][k],unhold[n-1][k]);

//
//        int[][] dp = new int[k + 1][prices.length];
//        for (int i = 1; i <= k; i++) {
//            int diff = prices[0];
//            for (int j = 1; j < prices.length; j++) {
//                dp[i][j] = Math.max(dp[i][j - 1], prices[j] - diff);
//                diff = Math.min(diff, prices[j] - dp[i - 1][j - 1]);
//            }
//        }
//        return dp[k][prices.length - 1];
//
//
//
//
//        int[] g = new int[k + 1];
//        int[] l = new int[k + 1];
//        for (int i = 0; i < prices.length - 1; i++) {
//            int diff = prices[i + 1] - prices[i];
//            for (int j = k; j > 0; j--) {
//                l[j] = Math.max(g[j - 1] + Math.max(diff, 0), l[j] + diff);
//                g[j] = Math.max(g[j], l[j]);
//            }
//        }
//        return g[k];
    }

    public static void main(String[] args) {
        BestTimetoBuyandSellStock188 obj = new BestTimetoBuyandSellStock188();
        System.out.println(obj.maxProfit(2, new int[]{2, 4, 1}));
        System.out.println(obj.maxProfit(2, new int[]{3, 2, 6, 5, 0, 3}));
    }
}
