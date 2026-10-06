class Solution {
    public int minDistance(String word1, String word2) {
        int n=word1.length();
        int m=word2.length();
        int[] curr=new int[word2.length()+1];
        int[] prev=new int[word2.length()+1];
        for(int i=n-1;i>=0;i--){
            curr[m]=0;
            for(int j=m-1;j>=0;j--){
                  if(word1.charAt(i)==word2.charAt(j)){
                    curr[j]=prev[j+1]+1;
                    continue;
                  }
                  curr[j]=Math.max(prev[j],curr[j+1]);
            }
            int [] temp=prev;
            prev=curr;
            curr=temp;
        }
        int c=prev[0];
        return word1.length()-c+word2.length()-c;
    }
    public int helper(String word1,String word2,int i,int j){
        if(i==word1.length() || j==word2.length()){
            return 0;
        }
        if(word1.charAt(i)==word2.charAt(j)){
            return 1+helper(word1,word2,i+1,j+1);
        }
        int c1=helper(word1,word2,i+1,j);
        int c2=helper(word1,word2,i,j+1);
        return Math.max(c1,c2);
    }
}