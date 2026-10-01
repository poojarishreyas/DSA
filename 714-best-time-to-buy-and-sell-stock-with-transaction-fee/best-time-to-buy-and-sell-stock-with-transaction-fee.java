class Solution {
    public int maxProfit(int[] prices, int fee) {

        int[] dp = new int[2];

        for (int i = prices.length - 1; i >= 0; i--) {

            // Save previous day's values
            int old0 = dp[0];
            int old1 = dp[1];

            if (0 == 0) {
                dp[0] = Math.max(old1 - prices[i], old0);
            }

            if (1 == 1) {
                dp[1] = Math.max(old0 + prices[i] - fee, old1);
            }
        }

        return dp[0];
    }
}