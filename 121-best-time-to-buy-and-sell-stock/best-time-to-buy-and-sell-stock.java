class Solution {
    public int maxProfit(int[] prices) {
        int[] prev=new int[3];
        int[] curr=new int[3];
        for(int i=prices.length-1;i>=0;i--){
            for(int j=1;j<3;j++){
                if(j==2){
                    curr[j]=Math.max(prev[j-1]-prices[i],prev[j]);
                }
                if(j==1){
                    curr[j]=Math.max(prev[j-1]+prices[i],prev[j]);

                }
            }
            int[] temp=prev;
            prev=curr;
            curr=temp;
        }
        return prev[2];
    }
  
}