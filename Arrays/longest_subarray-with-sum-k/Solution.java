
public class Solution {
    public static int longestSubarray(int[] nums, int k) {

        int i = 0;
        int sum = 0;
        int max = 0;

        for (int j = 0; j < nums.length; j++) {

            sum += nums[j];

            while (sum > k) {
                sum -= nums[i];
                i++;
            }

            if (sum == k) {
                max = Math.max(max, j - i + 1);
            }
        }

        return max;
    }

    public static void main(String[] args){
        int[] nums={10, 5, 2, 7, 1, 9};
        int k=15;
        int result=longestSubarray(nums,k);
        System.out.println(result);
    }
}
/*simple funda :
    if sum<target increment
    if sum > target trim
    if sm==target then store lngth 
*/