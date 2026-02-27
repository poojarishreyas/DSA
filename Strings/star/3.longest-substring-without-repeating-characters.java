/*
 * @lc app=leetcode id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i=0;
        int j=0;
        HashSet<Character> set=new HashSet<>();
        int length=0;
        int max=0;
        while(j<s.length()){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j));
                 max=Math.max(max,j-i+1);
                j++;
            }
            else{
                set.remove(s.charAt(i));
                 
                i++;
            }

            

        }
        return max;
    }
}
/*step1 : hile loop tiil string length
step2:  take a Hashset and append the elem  to it if it doesnt contain in set 
        take max and increment j
        if it contains than remove the pivot means i  and increment it
step 3:return max
*/
// @lc code=end

