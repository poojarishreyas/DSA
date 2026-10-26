class Solution {
    public int maxSubArray(int[] nums) {
         int bestending=0;;
         int max=Integer.MIN_VALUE;
         for(int i=0;i<nums.length;i++){
            bestending=Math.max(bestending+nums[i],nums[i]);
            max=Math.max(bestending,max);
            
         }
         return max;
    }
}