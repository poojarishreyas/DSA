class Solution {
    static int[][] dp;
    static int matrixMultiplication(int arr[]) {
        // code here
        int m=arr.length;
        dp=new int[m][m];
        
        return helper(1,arr.length-1,arr);
        
        
    }
    static int helper(int i ,int j,int[] arr){
        if(i==j){
            return 0;
        }
        if(dp[i][j]!=0){
            return dp[i][j];
        }
        int res=Integer.MAX_VALUE;
        for(int k=i;k<j;k++){
            int cost=(arr[i-1]*arr[k]*arr[j])+helper(i,k,arr)+helper(k+1,j,arr);
            res=Math.min(res,cost);
            
        }
        return dp[i][j]=res;
    }
}