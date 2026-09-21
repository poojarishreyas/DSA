class Solution {
    int[][] dp;
  public int maxProfit(int[] prices) {
        dp=new int[prices.length+1][3];

       
        for(int i=prices.length-1;i>=0;i--){
            for(int j=1;j<3;j++){
                if(j==2){
                    dp[i][j]=Math.max(dp[i+1][j-1]-prices[i],dp[i+1][j]);
                }
                if(j==1){
                    dp[i][j]=Math.max(dp[i+1][2]+prices[i],dp[i+1][j]);

                }
            }
        }
        return dp[0][2];
    }
    int helper(int[] prices, int i, int k) {

    if (i == prices.length ) {
        return 0;
    }

    if (dp[i][k] != -1) {
        return dp[i][k];
    }

    if (k == 2) { // BUY

        int c1 = helper(prices, i + 1, k - 1) - prices[i];
        int c2 = helper(prices, i + 1, k);

        return dp[i][k] = Math.max(c1, c2);

    } else { // SELL

        int c1 = helper(prices, i + 1, 2) + prices[i];
        int c2 = helper(prices, i + 1, k);

        return dp[i][k] = Math.max(c1, c2);
    }
}

}