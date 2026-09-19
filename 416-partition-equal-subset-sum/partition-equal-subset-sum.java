class Solution {
    Boolean[][] dp;
    public boolean canPartition(int[] nums) {
        
        int sum=0;
        for(int num: nums){
            sum+=num;
        }
        if(sum%2==0){

            dp=new Boolean[nums.length+1][(sum/2)+1];
            int n=nums.length;
            dp[n][0]=true;
            for(int i=1;i<=sum/2;i++){
                dp[n][i]=false;
            }
            for(int i=n-1;i>=0;i--){
                for(int j=0;j<=sum/2;j++){
                    if(nums[i]>j){
                        dp[i][j]=dp[i+1][j];
                    }
                    else{
                         dp[i][j]=dp[i+1][j-nums[i]] || dp[i+1][j];
                    }
                   
                }
            }
            return dp[0][sum/2];
        }
        return false;
    }
 
}