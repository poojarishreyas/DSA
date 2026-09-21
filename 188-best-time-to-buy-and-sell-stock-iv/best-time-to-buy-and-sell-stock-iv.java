class Solution {
    public int maxProfit(int k, int[] prices) {
        
        k=k*2;
         int[] curr=new int[k+1];
        int[] prev=new int[k+1];

       
        for(int i=prices.length-1;i>=0;i--){
            for(int j=1;j<k+1;j++){
                if(j%2==0){
                    curr[j]=Math.max(prev[j-1]-prices[i],prev[j]);
                }
                else{
                   curr[j]=Math.max(prev[j-1]+prices[i],prev[j]);

                }
            }
            int[] temp=prev;
            prev=curr;
            curr=temp;
        }
        return prev[k];
    }
}
