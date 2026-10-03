class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[] prev_prev=new int [n+2];
        int[] prev=new int[n+2];
        int [] curr=new int[n+2];
        for(int i=n-1;i>=0;i--){
            for(int j=1;j>=0;j--){
                if(j==0){
                    curr[0]=Math.max(prev[1]-prices[i],prev[0]);
                }
                else{
                    curr[1]=Math.max(prev_prev[0]+prices[i],prev[1]);
                }
            }
            int [] temp=prev_prev;
            prev_prev=prev;
            prev=curr;
            curr=temp;
        }
        return prev[0];
    }
    public int helper(int[] prices,int i,int k){
        if(i>=prices.length){
            return 0;
        }
        
        if(k==0){
            int c1=helper(prices,i+1,1)-prices[i];
            int c2=helper(prices,i+1,0);
            return Math.max(c1,c2);

        }
        else{
            int c1=helper(prices,i+2,0)+prices[i];
            int c2=helper(prices,i+1,1);
            return Math.max(c1,c2);
        }
    }
}