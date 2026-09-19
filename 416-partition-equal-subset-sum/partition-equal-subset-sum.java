class Solution {
    public boolean canPartition(int[] nums) {

        int sum = 0;

        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 != 0) {
            return false;
        }

        int target = sum / 2;
        int n=nums.length;
        boolean[] prev=new boolean [target+1];
        boolean[] curr=new boolean[target+1];
        prev[0]=true;
        for(int i=n-1;i>=0;i--){
            for(int j=0;j<=target;j++){
                if(nums[i]>j){
                    curr[j]=prev[j];
                }
                else{
                    curr[j]=prev[j-nums[i]] || prev[j];
                }
            }
             boolean[] temp = prev;
            prev = curr;
            curr = temp;

        }
        return curr[target];

    }
}