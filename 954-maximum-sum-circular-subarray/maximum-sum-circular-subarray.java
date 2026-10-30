class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int minending=nums[0];
        int maxending=nums[0];
        int min=nums[0];
        int max=min;
        int sum=nums[0];
        int n=nums.length;

        for(int i=1;i<n;i++){
            sum+=nums[i];
            maxending=Math.max(maxending+nums[i],nums[i]);
            minending=Math.min(minending+nums[i],nums[i]);
            min=Math.min(minending,min);
            max=Math.max(maxending,max);
        }
         if (max < 0) return max;
        return Math.max(sum-min,max);
    
    }
}