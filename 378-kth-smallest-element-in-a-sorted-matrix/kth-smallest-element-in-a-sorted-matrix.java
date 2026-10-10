class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n=matrix.length;
        int m=matrix[0].length;
        int low=matrix[0][0];
        int high=matrix[n-1][m-1];
        int res=-1;
        while(low<=high){
            int guess=low+(high-low)/2;
            if(func(matrix,guess)>=k){
                res=guess;
                high=guess-1;
            }
            else{
                low=guess+1;
            }
        }
        return res;

    }
    public int func(int[][] matrix,int guess){
        int n=matrix.length;
        int m=matrix[0].length;
        int row=n-1;
        int col=0;
        int count=0;
        while(row>=0 && col<m){
            if(matrix[row][col]>guess){
                row--;
            }
            else{
                count+=row+1;
                col++;
            }
        }
        return count;
    }
}