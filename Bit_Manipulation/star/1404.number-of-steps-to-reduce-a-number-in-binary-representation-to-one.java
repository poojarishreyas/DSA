/*
 * @lc app=leetcode id=1404 lang=java
 *
 * [1404] Number of Steps to Reduce a Number in Binary Representation to One
 */

// @lc code=start
class Solution {
    public int numSteps(String s) {
        int carry=0;
        int step=0;
        for(int i=s.length()-1;i>0;i--){
            int bit=s.charAt(i)-'0';
            if(bit+carry==1){
                //odd case
                step+=2;
                carry=1;
            }
            else{
                step+=1;
            }
        }
        return step+carry;
    }
}
// @lc code=end

