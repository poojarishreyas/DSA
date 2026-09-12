class Solution {
    int[] dp;

    public int rob(int[] nums) {
        dp = new int[nums.length];
        Arrays.fill(dp, -1);

        return helper(nums, 0);
    }

    int helper(int[] nums, int i) {
        if (i >= nums.length) {
            return 0;
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        int rob = nums[i] + helper(nums, i + 2);
        int skip = helper(nums, i + 1);

        return dp[i] = Math.max(rob, skip);
    }
}