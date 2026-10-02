class Solution {
    public int uniquePaths(int m, int n) {
        int[] prev=new int[n];
        int[] curr=new int[n];
        Arrays.fill(prev,1);
    
        for(int i=m-2;i>=0;i--){
            curr[n-1]=1;
            for(int j=n-2;j>=0;j--){
                curr[j]=curr[j+1]+prev[j];
            }
            int[] temp=prev;
            prev=curr;
            curr=temp;
        }
        return prev[0];
    }
    public int helper(int m,int n,int i,int j){
        if(i==m-1 && j==n-1){
            return 1;
        }
        if(i>=m || j>=n ){
            return 0;
        }
        int c1=helper(m,n,i,j+1);
        int c2=helper(m,n,i+1,j);
        return c1+c2;
    }
}