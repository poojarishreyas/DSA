class Solution {
    public int maxProduct(int[] nums) {
        int maxending = nums[0];
        int minending = nums[0];
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {

            // 1. Save previous states
            int prevmax = maxending;
            int prevmin = minending;

            // 2. Update current states
            maxending = Math.max(nums[i],
                        Math.max(prevmax * nums[i],
                                 prevmin * nums[i]));

            minending = Math.min(nums[i],
                        Math.min(prevmax * nums[i],
                                 prevmin * nums[i]));

            // 3. Update global answer
            max = Math.max(max, maxending);
        }

        return max;
    }
}