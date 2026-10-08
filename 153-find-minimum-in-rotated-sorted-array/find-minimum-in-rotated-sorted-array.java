class Solution {
    public int findMin(int[] nums) {
        int n=nums.length;
        int low=0;
        int high=n-1;
        int res=0;
        while(low<=high){
            int guess=low+(high-low)/2;
            if(nums[guess]<=nums[n-1]){
                res=guess;
                high=guess-1;
            }
            else{
                low=guess+1;
            }
        }
        return nums[res];
    }
}