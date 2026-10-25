class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n=numbers.length;
        int low=0;
        int high=n-1;
        int res[] =new int[2];
        while(low<high){
            int ans=numbers[high]+numbers[low];
            if(ans==target){
                res[0]=low+1;
                res[1]=high+1;
                return res;
            }
            else if(ans>target){
                high--;

            }
            else{
                low++;
            }
        }
        return res;
    }
}