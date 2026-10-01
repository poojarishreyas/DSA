class Solution {
    public int change(int amounts, int[] coins) {
        int[] curr=new int[amounts+1];
        int[] prev=new int[amounts+1];
        for(int i=coins.length-1;i>=0;i--){
            curr[0]=1;
            for(int j=1;j<=amounts;j++){
                    curr[j]=prev[j];
                    if(j>=coins[i]){
                        curr[j]+=curr[j-coins[i]];
                    }

            }
            int[] temp=prev;
            prev=curr;
            curr=temp;
        }
        return prev[amounts];
        
    }
}