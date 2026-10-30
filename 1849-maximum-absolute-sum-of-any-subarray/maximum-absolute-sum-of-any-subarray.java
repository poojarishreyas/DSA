class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int maxending=nums[0];
        int minending=nums[0];
        int max=Math.abs(nums[0]);
        for(int i=1;i<nums.length;i++){
           maxending=Math.max(maxending+nums[i],nums[i]);
           minending=Math.min(minending+nums[i],nums[i]);
           max=Math.max(max,Math.max(maxending,Math.abs(minending)));
        }
        return max;
    }
}