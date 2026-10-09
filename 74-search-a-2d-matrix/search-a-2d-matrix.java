
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // int n = matrix.length;
        // int m = matrix[0].length;

        // int rlow = 0;
        // int rhigh = n - 1;
        // int i = -1;

        // // Find the candidate row
        // while (rlow <= rhigh) {
        //     int guess = rlow + (rhigh - rlow) / 2;

        //     if (matrix[guess][m - 1] == target) {
        //         return true;
        //     } else if (matrix[guess][m - 1] < target) {
        //         rlow = guess + 1;
        //     } else {
        //         i = guess;
        //         rhigh = guess - 1;
        //     }
        // }

        // if (i == -1) {
        //     return false;
        // }

        // // Binary search inside the candidate row
        // int low = 0;
        // int high = m - 1;

        // while (low <= high) {
        //     int guess = low + (high - low) / 2;

        //     if (matrix[i][guess] == target) {
        //         return true;
        //     } else if (matrix[i][guess] < target) {
        //         low = guess + 1;
        //     } else {
        //         high = guess - 1;
        //     }
        // }

        // return false;
        int n=matrix.length;
        int m=matrix[0].length;
        int low=0;
        int high=m*n-1;
        while(low<=high){
            int guess=low+(high-low)/2;
            if(matrix[guess/m][guess%m]==target){
                return true; 
            }
            else if(matrix[guess/m][guess%m]<target){
                low=guess+1;

            }
            else{
                high=guess-1;
            }
        }
        return false;
    }
}
