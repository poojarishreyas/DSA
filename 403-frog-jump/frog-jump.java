class Solution {
    int n;
    HashMap<Integer, HashMap<Integer, Boolean>> dp;

    public boolean canCross(int[] stones) {
        n = stones.length;

        dp = new HashMap<>();

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(stones[i], i);
        }

        return helper(stones, map, 1, 1);
    }

    boolean helper(int[] stones, HashMap<Integer, Integer> map,
                   int curr, int k) {

        if (curr >= stones[n - 1]) {
            return curr == stones[n - 1];
        }

        if (!map.containsKey(curr)) {
            return false;
        }

        if (dp.containsKey(curr) && dp.get(curr).containsKey(k)) {
            return dp.get(curr).get(k);
        }

        boolean c1 = false;

        if (k > 1) {
            c1 = helper(stones, map, curr + k - 1, k - 1);
        }

        boolean c2 = helper(stones, map, curr + k, k);
        boolean c3 = helper(stones, map, curr + k + 1, k + 1);

        boolean ans = c1 || c2 || c3;

        dp.putIfAbsent(curr, new HashMap<>());
        dp.get(curr).put(k, ans);

        return ans;
    }
}