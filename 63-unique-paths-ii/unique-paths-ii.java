class Solution {
    int n;
    int m;
    int[][] dp;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
         n=obstacleGrid.length;
         m=obstacleGrid[0].length;
         dp=new int[n+1][m+1];
         if(obstacleGrid[n-1][m-1]!=0) return 0;
        return helper(obstacleGrid,0,0);
    }
    public int helper(int[][] obstacleGrid,int i,int j){
        if(i==n-1 && j==m-1){
            return 1;
        }
        if(i>=n || j>=m){
            return 0;
        }
        if(dp[i][j]!=0) return dp[i][j];
        if(obstacleGrid[i][j]!=0) return dp[i][j] =0;
        int  c1= helper(obstacleGrid,i+1,j);
        int  c2=helper(obstacleGrid,i,j+1);


        return  dp[i][j]=c1+c2;
    }
}