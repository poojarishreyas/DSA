class Solution {
    int[][] dp;
    public int lengthOfLIS(int[] nums) {
        dp=new int[nums.length][nums.length+1];
        return helper(nums,-1,0);
    }
    int helper(int[] nums,int prev,int i){
        if(i==nums.length){
            return 0;
        }
        if(dp[i][prev+1]!=0){
            return dp[i][prev+1];
        }
        if(prev!=-1 && nums[i]<=nums[prev]){
            return dp[i][prev+1]= helper(nums,prev,i+1);
        }
        int c1=1+helper(nums,i,i+1);
        int c2=helper(nums,prev,i+1);
        return dp[i][prev+1]=Math.max(c1,c2);
    }
}