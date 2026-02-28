/*
 * @lc app=leetcode id=1004 lang=java
 *
 * [1004] Max Consecutive Ones III
 */

// @lc code=start
class Solution {
    public int longestOnes(int[] nums, int k) {

        int i = 0;
        int count = 0;
        int max = 0;

       for(int j=0;j<nums.length;j++){
            if(nums[j]==0){
                count++;
            }
            while(count>k){
                if(nums[i]==0){
                    count--;
                }
                i++;
            }
            max=Math.max(max,j-i+1);
            
       }

        return max;
    }
}
/* step1: we know th dominating char is 1 so whenever u encounter 0 increment count 
   step2: if count is greater than k then incement i and decrement count*/
// @lc code=end

