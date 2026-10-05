class Solution {
    List [][] dp;
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        dp=new List [n+1][n+1];
        return helper(nums,0,-1);
    }
    public List<Integer> helper(int[] nums,int i,int last){
        if(i==nums.length){
            return new ArrayList<>();
        }
        if(dp[i][last+1]!=null) return dp[i][last+1];
        if(last!=-1){
            if(nums[i]%nums[last]!=0){
                return dp[i][last+1]=helper(nums,i+1,last);
            }
        }
        ArrayList<Integer> c1=new ArrayList<>(helper(nums,i+1,i));
        c1.add(0,nums[i]);
        ArrayList<Integer> c2=new ArrayList<>(helper(nums,i+1,last));
        if(c1.size()>c2.size()){
            return dp[i][last+1]=c1;
        }
        else{
            return  dp[i][last+1]=c2;
        }
    }
}