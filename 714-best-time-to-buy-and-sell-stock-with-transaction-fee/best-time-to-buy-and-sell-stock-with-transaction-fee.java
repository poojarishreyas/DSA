class Solution {
    int[][]dp;
    public int maxProfit(int[] prices, int fee) {
        dp=new int[prices.length][2];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return helper(prices,fee,0,0);
    }
    int helper(int[] prices,int fee,int i,int k){
        if(i==prices.length){
            return 0;
        }
        if(dp[i][k]!=-1) return dp[i][k];
        if(k==0){
            int c1=helper(prices,fee,i+1,1)-prices[i];
            int c2=helper(prices,fee,i+1,0);
            return dp[i][k]= Math.max(c1,c2);
        }
        else{
             int c1=helper(prices,fee,i+1,0)+prices[i]-fee;
            int c2=helper(prices,fee,i+1,1);
            return dp[i][k]=Math.max(c1,c2);
        }
           
        
    }
}