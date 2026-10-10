class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n=matrix.length;
        int m=matrix[0].length;
        int row=n-1;
        int col=0; 
        while(row>=0 && col<m){
            if(matrix[row][col]==target){
                return true;
            }
            else if(matrix[row][col]>target){
                row=row-1;
            }
            else{
                col=col+1;
            }
        }
        return false;
    }
}