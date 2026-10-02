class Solution {
    int n;
    int m;
    public int minFallingPathSum(int[][] matrix) {
         int n=matrix.length;
         int m=matrix[0].length;
         int[] prev=new int[m+2];
         int[] curr=new int[m+2];
         prev[m+1]=Integer.MAX_VALUE;
         prev[0]=Integer.MAX_VALUE;
         for(int i=n-1;i>=0;i--){
            curr[m+1]=Integer.MAX_VALUE;
            curr[0]=Integer.MAX_VALUE;
            for(int col=m;col>=1;col--){
                curr[col]= Math.min(prev[col],Math.min(prev[col-1],prev[col+1]))+matrix[i][col-1];
            }
            int[] temp=prev;
            prev=curr;
            curr=temp;
         }
         int res=Integer.MAX_VALUE;
         for(int ele:prev){
           res= Math.min(res,ele);
         }
         return res;

         
         
       
    }
    public int helper(int[][] matrix,int row, int col){
        if(  col==m || col<0){
            return Integer.MAX_VALUE;
        }
        if(row==n){
            return 0;
        }
        int c1=helper(matrix,row+1,col);
        int c2=helper(matrix,row+1,col-1);
        int c3=helper(matrix,row+1,col+1);
        return Math.min(c1,Math.min(c2,c3))+matrix[row][col];
    }
}