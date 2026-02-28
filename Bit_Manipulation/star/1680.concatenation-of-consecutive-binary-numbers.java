/*
 * @lc app=leetcode id=1680 lang=java
 *
 * [1680] Concatenation of Consecutive Binary Numbers
 */

// @lc code=start
class Solution {
    public int concatenatedBinary(int n) {
        long result=0;
        int length=0;
        for(int i=1;i<=n;i++){
            if((i&(i-1))==0) length++;
            result=((result<<length)+i)% 1000000007;
        }
        return (int)result;
    }
}
/* concept: to concantinate two binary ex: 1+10 => left shift 1 by len(10)=> 1<<len(10)
                                                =>   100 then add 10
                                                =>    100
                                                    +  10
                                                    --------
                                                      110
            mod it by 1000000007
            turn result;
*/
// @lc code=end

