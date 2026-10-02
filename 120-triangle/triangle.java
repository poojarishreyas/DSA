class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        
        int n=triangle.size();
        int m=triangle.get(n-1).size();
        int[] prev=new int [m+1];
        int[] curr=new int [m+1];
        prev[m]=Integer.MAX_VALUE;
        for(int i=n-1;i>=0;i--){
             m=triangle.get(i).size();
            curr[m]=Integer.MAX_VALUE;
            for(int j=m-1;j>=0;j--){
                curr[j]=Math.min(prev[j],prev[j+1])+triangle.get(i).get(j);
            }
            int[] temp=prev;
            prev=curr;
            curr=temp;
        }
        return prev[0];
    }
  
}