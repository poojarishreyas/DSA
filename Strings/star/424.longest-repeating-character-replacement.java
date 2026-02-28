/*
 * @lc app=leetcode id=424 lang=java
 *
 * [424] Longest Repeating Character Replacement
 */

// @lc code=start
class Solution {
    public int characterReplacement(String s, int k) {
        int i=0;
        int dominating_char=0;
        int[] freq=new int[26];
        int maxlength=0;
        
        for(int j=0;j<s.length();j++){
            freq[s.charAt(j)-'A']++;
            dominating_char=Math.max(dominating_char,freq[s.charAt(j)-'A']);
            while((j-i+1)-dominating_char>k){
                freq[s.charAt(i)-'A']--;
                i++;

            }
            maxlength=Math.max(maxlength,j-i+1);



        }
        return maxlength;
    }
}
/* step1: get the freq of the dominating character
   step2: if  window size - dominating charcter >k then increment i
   calculate maxlngth evry time when j increments 
   */
   
// @lc code=end

