class Solution {
    int[][] dp;
    public int rob(int[] nums) {
        int n=nums.length;
        dp=new int[n+1][2];
        for(int[] row:dp){
             Arrays.fill(row,-1);
        }
       
        return helper(nums,0,1);
    }
    int helper(int[] nums,int i, int free){
        if(i==nums.length){
            return 0;
        }
        if(dp[i][free]!=-1){
            return dp[i][free];
        }
        if(free==0){
            return dp[i][free]=helper(nums,i+1,1);
        }
        int c1=nums[i]+helper(nums,i+1,0);
        int c2=helper(nums,i+1,1);
        return dp[i][free]=Math.max(c1,c2);

    }
}