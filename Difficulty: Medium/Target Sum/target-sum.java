class Solution {
    public int totalWays(int[] nums, int target) {
        // code here
        int totalsum=0;
                for(int num:nums){
                    totalsum+=num;
                }
                int pos=(totalsum+target)/2;
                if((totalsum+target)%2!=0 || Math.abs(target)>totalsum){
                    return 0;
                }

                int[] prev=new int[pos+1];
                int[] curr=new int[pos+1];
                int n=nums.length;
                prev[0]=1;
                for(int i=n-1;i>=0;i--){
                    for(int j=0;j<=pos;j++){
                        if(nums[i]>j){
                            curr[j]=prev[j];
                        }
                        else{
                            curr[j]=prev[j-nums[i]]+prev[j];
                        }
                    }
                    int[] temp=prev;   
                    prev=curr;
                    curr=temp;     
                }
                return prev[pos];
            }
    
}