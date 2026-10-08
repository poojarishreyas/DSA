class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int low=0;
        int high=arr.length-1;
        int ans=-1;
        while(low<=high){
            int guess=low+(high-low)/2;
            if(guess<arr.length-1 && arr[guess]>arr[guess+1]){
                ans=guess;
                high=guess-1;
            }
            else{
                low=guess+1;
            }
        }
        return ans;
    }
}