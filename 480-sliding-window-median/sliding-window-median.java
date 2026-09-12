class Solution {

    PriorityQueue<Integer> left =
        new PriorityQueue<>(Collections.reverseOrder());

    PriorityQueue<Integer> right =
        new PriorityQueue<>();

    int extraleft = 0;
    int extraright = 0;

    HashMap<Integer, Integer> map = new HashMap<>();

    public double[] medianSlidingWindow(int[] nums, int k) {

        int n = nums.length;
        double[] res = new double[n - k + 1];

        for (int i = 0; i < k; i++) {
            addnum(nums[i]);
        }

        res[0] = median(k);

        for (int i = k; i < n; i++) {

            // Add new element
            addnum(nums[i]);

            // Mark outgoing element
            int x = nums[i - k];

            map.put(x, map.getOrDefault(x, 0) + 1);

            /*
             * Decide which logical heap contains x.
             *
             * If x <= left.peek(), it belongs to left.
             * Otherwise it belongs to right.
             */
            if (x <= left.peek()) {
                extraleft++;
            } else {
                extraright++;
            }

            // Remove invalid elements from heap tops
            cleanLeft();
            cleanRight();

            // Balance
            balance();

            res[i - k + 1] = median(k);
        }

        return res;
    }

    public void addnum(int num) {

        if (left.isEmpty() || num <= left.peek()) {
            left.add(num);
        } else {
            right.add(num);
        }

        balance();
    }

    public void balance() {

        /*
         * Number of VALID elements in each heap
         */
        int leftValid = left.size() - extraleft;
        int rightValid = right.size() - extraright;

        // left can have at most one more valid element
        while (leftValid > rightValid + 1) {

            int x = left.poll();

            // If this element was already marked for deletion
            if (map.containsKey(x)) {

                removeFromMap(x);
                extraleft--;

            } else {

                right.add(x);
            }

            leftValid = left.size() - extraleft;
            rightValid = right.size() - extraright;
        }

        // right cannot have more valid elements than left
        while (rightValid > leftValid) {

            int x = right.poll();

            if (map.containsKey(x)) {

                removeFromMap(x);
                extraright--;

            } else {

                left.add(x);
            }

            leftValid = left.size() - extraleft;
            rightValid = right.size() - extraright;
        }
    }

    public void cleanLeft() {

        while (!left.isEmpty() && map.containsKey(left.peek())) {

            int x = left.poll();

            removeFromMap(x);

            extraleft--;
        }
    }

    public void cleanRight() {

        while (!right.isEmpty() && map.containsKey(right.peek())) {

            int x = right.poll();

            removeFromMap(x);

            extraright--;
        }
    }

    public void removeFromMap(int x) {

        map.put(x, map.get(x) - 1);

        if (map.get(x) == 0) {
            map.remove(x);
        }
    }

    public double median(int k) {

        cleanLeft();
        cleanRight();

        if (k % 2 == 0) {
            return ((double) left.peek() + right.peek()) / 2.0;
        } else {
            return left.peek();
        }
    }
}