class Solution {
    int[] dp;
    public int climbStairs(int n) {
        dp=new int[n+1];
        return solve(0,n);
        
    }
    int solve(int i,int n){
        if(i==n){
            return 1;
        }
        if(i>n) return 0;
        if(dp[i]!=0){
            return dp[i];
        }
        return dp[i]=solve(i+1,n)+solve(i+2,n);
    }
}