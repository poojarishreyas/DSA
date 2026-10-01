class Solution {
    int[][]dp;
    public int maxProfit(int[] prices, int fee) {
        int[] prev=new int [prices.length+1];
        int[] curr=new int[prices.length+1];
        for(int i=prices.length-1;i>=0;i--){
            for(int j=0;j<=1;j++){
                if(j==0){
                    curr[j]=Math.max(prev[1]-prices[i],prev[0]);
                }
                else{
                    curr[j]=Math.max(prev[0]+prices[i]-fee,prev[1]);
                }

            }
            int[] temp=prev;
            prev=curr;
            curr=prev;
        }
        return prev[0];
    }
    
}