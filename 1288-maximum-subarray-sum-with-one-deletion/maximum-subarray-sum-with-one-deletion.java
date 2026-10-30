class Solution {
    public int maximumSum(int[] arr) {
         int onedeletion=arr[0];
         int nodeletion=arr[0];
         int max=arr[0];
         for(int i=1;i<arr.length;i++){
            int prevnodeletion=nodeletion;
            int prevonedeletion=onedeletion;
            nodeletion=Math.max(nodeletion+arr[i],arr[i]);
            onedeletion=Math.max(prevnodeletion,prevonedeletion+arr[i]);
            max=Math.max(nodeletion,Math.max(max,onedeletion));
         }
         return max;

    }
}