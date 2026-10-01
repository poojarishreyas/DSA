class Solution {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
         int n=obstacleGrid.length;
         int m=obstacleGrid[0].length;
         int[] prev=new int [m+1];
         int[] curr=new int[m+1];
         if(obstacleGrid[n-1][m-1]!=0) return 0;
         prev[m]=0;
         prev[m-1]=1;
         for (int j = m - 2; j >= 0; j--) {
            if (obstacleGrid[n - 1][j] != 0) {
                prev[j] = 0;
            } else {
                prev[j] = prev[j + 1];
            }
        }
         for(int i=n-2;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                if(obstacleGrid[i][j]!=0){
                    curr[j]=0;
                    continue;
                } 
                curr[j]=prev[j]+curr[j+1];
            }
            int[] temp=prev;
            prev=curr;
            curr=temp;
         }
         return prev[0];
    }
   
}