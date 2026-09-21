class Solution{
    int[][]dp;
    public int minCost(int n, int[] cuts) {
        ArrayList<Integer> cutss=new ArrayList<>();
        cutss.add(0);
        for(int ele:cuts){
            cutss.add(ele);
        }
        cutss.add(n);
        dp=new int[cutss.size()][cutss.size()];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        Collections.sort(cutss);
        return helper(1,cutss.size()-2,cutss);
        
    }
    int helper(int i, int j,ArrayList<Integer> cutss){
        if(i>j){
            return 0;
        }
        int res=Integer.MAX_VALUE;
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        for(int k=i;k<=j;k++){
            int cost=cutss.get(j+1)-cutss.get(i-1);
            int r=cost+ helper(i,k-1,cutss)+helper(k+1,j,cutss);
             res=Math.min(res,r);
            
        }
        return dp[i][j]= res;
    }
}