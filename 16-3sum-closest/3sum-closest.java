class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
          int min=Integer.MAX_VALUE;
          int res=0;
        for(int i=0;i<nums.length;i++){
            int left=i+1;
            int right=nums.length-1;
          
            while(left<right){
                int sum=nums[left]+nums[right]+nums[i];
                if(min>Math.abs(target-sum)){
                    min=Math.abs(target-sum);
                    res=sum;
                }
                if(sum==target){
                    return sum;
                }
                if(sum>target){
                    right--;
                  
                }
                else{
                    left++;
                }
            }


        }
        return res ;
    }
}