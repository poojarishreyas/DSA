class Solution {
    int[][] dp;
    public int knapsack(int W, int val[], int wt[]) {
        // code here
        dp=new int[val.length+1][W+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return helper(val,wt,0,W);
    }
    int helper(int[] val,int[] wt,int i,int cap){
        if(i==val.length){
            return 0;
        }
        if(dp[i][cap]!=-1 ){
            return dp[i][cap];
        }
        if(wt[i]>cap){
            return dp[i][cap]=helper(val,wt,i+1,cap);
        }
        int take=val[i]+helper(val,wt,i+1,cap-wt[i]);
        int nottake=helper(val,wt,i+1,cap);
        return dp[i][cap]=Math.max(take,nottake);
    }
}
