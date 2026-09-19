class Solution {
    static Boolean[][] dp;
    static boolean isSubsetSum(int arr[], int sum) {
        // code here
        dp=new Boolean [arr.length+1][sum+1];
       return fun(arr,0,sum);
        
    }
    static boolean fun(int[] arr,int i, int sum){
        if(i==arr.length){
            if(sum==0){
                return true;
            }
            return false;
        }
        if(dp[i][sum]!=null){
            return dp[i][sum];
        
        }
        if(arr[i]>sum){
            return dp[i][sum]=fun(arr,i+1,sum);
        }
        boolean c1=fun(arr,i+1,sum-arr[i]);
        boolean c2=fun(arr,i+1,sum);
        return dp[i][sum]=c1 || c2;
        
    }
}