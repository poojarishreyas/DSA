class Solution {
    public int totalNumbers(int[] digits) {

        int[] freq = new int[10];

        for (int digit : digits) {
            freq[digit]++;
        }

        int count = 0;

        for (int num = 100; num <= 998; num += 2) {

            int a = num / 100;
            int b = (num / 10) % 10;
            int c = num % 10;

            freq[a]--;

            if (freq[a] >= 0) {
                freq[b]--;

                if (freq[b] >= 0) {
                    freq[c]--;

                    if (freq[c] >= 0) {
                        count++;
                    }

                    freq[c]++;
                }

                freq[b]++;
            }

            freq[a]++;
        }

        return count;
    }
}