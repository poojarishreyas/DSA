class Solution {
    int[][] dp;
    public int lengthOfLIS(int[] nums) {
         int n=nums.length;
         dp=new int[n+1][n+1];
        int[] prev=new int [n+1];
        int [] curr=new int[n+1];
        for(int i=n-1;i>=0;i--){
            for(int j=n-1;j>=-1;j--){
                if(j!=-1){
                    if(nums[i]<=nums[j]){
                        curr[j+1]=prev[j+1];
                        continue;
                    }
                }
            
                     curr[j+1]=Math.max(1+prev[i+1],prev[j+1]);
                
               

            }
            int [] temp=prev;
            prev=curr;
            curr=prev;
        }
        return prev[0];
        
    }
    public int helper(int[] nums,int i,int prev){
        if(i==nums.length){
            return 0;
        }
        if(dp[i][prev+1]!=0) return dp[i][prev+1];
        if(prev!=-1){
            if(nums[i]<=nums[prev]){
                return dp[i][prev+1]= helper(nums,i+1,prev);
            }
            
        }
        int c1=1+helper(nums,i+1,i);
        int c2=helper(nums,i+1,prev);
        return dp[i][prev+1]=Math.max(c1,c2);
    }
}