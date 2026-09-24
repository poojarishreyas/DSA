class Solution {
    public int smallestIndex(int[] nums) {
        for(int i=0;i<nums.length;i++){
            if(i==sum(nums[i])){
                return i;
            }
        }
        return -1;
    }
    public int sum(int digit){
        if(digit<10){
            return digit;
        }
        int c1=digit%10+sum(digit/10);
        return c1;
    }
}