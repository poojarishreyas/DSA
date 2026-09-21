class Solution {

    public int maxProfit(int[] prices) {
        int[] curr=new int[5];
        int[] prev=new int[5];

       
        for(int i=prices.length-1;i>=0;i--){
            for(int j=1;j<5;j++){
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
        return prev[4];
    }
   
}