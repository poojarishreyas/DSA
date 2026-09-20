class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n=text1.length();
        int m=text2.length();
         int[] curr=new int[m+1];
         int[] prev=new int[m+1];
         for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                if(text1.charAt(i)==text2.charAt(j)){
                    curr[j]=1+prev[j+1];

                }
                else{
                    curr[j]=Math.max(prev[j],curr[j+1]);
                }
                
            }
            int[] temp=prev;
            prev=curr;
            curr=temp;
         }
         return prev[0];
    }
}