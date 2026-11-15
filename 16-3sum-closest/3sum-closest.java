class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
       int min_diff=Integer.MAX_VALUE;
       int res=0;
        for(int i=0;i<nums.length-2;i++){
            int j=i+1;
            int k=nums.length-1;
            while(j<k){
                int sum=nums[i]+nums[j]+nums[k];
                int diff=Math.abs(target-sum);
                if(sum==target){
                    return target;
                }
                else if(sum<target){
                    if(diff<min_diff){
                        min_diff=diff;
                        res=sum;
                    }
                    j++;

                  
                }
                else{
                      if(diff<min_diff){
                        min_diff=diff;
                        res=sum;
                      }
                    k--;
                }
            }
        }
        return res;
    }
}