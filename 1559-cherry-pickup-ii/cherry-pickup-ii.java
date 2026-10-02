class Solution {
    int n;
    int m;
    public int cherryPickup(int[][] grid) {
        n=grid.length;
        m=grid[0].length;
        int[][] prev=new int [m+2][m+2];
        int[][] curr=new int[m+2][m+2];
        for(int row=n-1;row>=0;row--){
            for(int col1=m-1;col1>=0;col1--){
                for(int col2=m-1;col2>=0;col2--){
                    int res=0;
                    for(int dj1=-1;dj1<=1;dj1++){
                        for(int dj2=-1;dj2<=1;dj2++){
                            int c1;
                            if(col1==col2){
                                c1=grid[row][col1]+prev[col1+dj1+1][col2+dj2+1];
                            }
                            else{
                                c1=grid[row][col1]+grid[row][col2]+prev[col1+dj1+1][col2+dj2+1];
                            }
                            res=Math.max(res,c1);

                        }
                    }
                    curr[col1+1][col2+1]=res;
                }
            }
            int[][] temp=prev;
            prev=curr;
            curr=temp;

                  

        }
        return prev[1][m];
    }
    public int helper(int[][]grid,int row,int col1,int col2){
        if(row==n || col1==m || col2==m || col1<0 || col2<0){
            return 0;
        }
        //all possible comboination of direction for each row
        int res=0;
       for(int dj1=-1;dj1<=1;dj1++){
        for(int dj2=-1;dj2<=1;dj2++){
            int c1;
            if(col1==col2){
                 c1=grid[row][col1]+helper(grid,row+1,col1+dj1,col2+dj2);
            }
            else{
                 c1=grid[row][col1]+grid[row][col2]+helper(grid,row+1,col1+dj1,col2+dj2);
            }
            res=Math.max(res,c1);

        }
       }
       return res;
    }
}