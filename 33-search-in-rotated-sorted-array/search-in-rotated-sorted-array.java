class Solution {
    public int search(int[] nums, int target) {
        int n=nums.length;
        int part;
        int low=0;
        int high=n-1;
        if(target>nums[n-1]  ){
                part=2;
        }
        else{
            part=1;
        }
        

        while(low<=high){
            int guess=low+(high-low)/2;
            if(nums[guess]==target){
                return guess;
            }
           
            if(part==1){
                if(nums[guess]>=nums[n-1]){
                    low=guess+1;
                }
               else{
                    if(nums[guess]>target){
                        high=guess-1;
                    }
                    else{
                        low=guess+1;
                     }
                }
            }
            else{
                if(nums[guess]<=nums[n-1]){
                    high=guess-1;
                }
                  else{
                    if(nums[guess]>target){
                        high=guess-1;
                    }
                    else{
                        low=guess+1;
                     }
                }
            }
        }
        return -1;
    }
}