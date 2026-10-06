class Solution {
    public int minInsertions(String s) {
        int n = s.length();

        int[] prev = new int[n];
        int[] curr = new int[n];
        prev[n-1]=1;
        for(int i = n - 2; i >= 0; i--) {
            curr[i] = 1;

            for(int j = i + 1; j < n; j++) {

                if(s.charAt(i) == s.charAt(j)) {
                    curr[j] = prev[j - 1] + 2;
                } else {
                    curr[j] = Math.max(prev[j], curr[j - 1]);
                }
            }

            int[] temp = prev;
            prev = curr;
            curr = temp;
        }

        return s.length()-prev[n-1];
    }
}