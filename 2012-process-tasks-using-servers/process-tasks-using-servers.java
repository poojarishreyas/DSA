import java.util.*;

class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        int n = servers.length;
        int m = tasks.length;
        int[] ans = new int[m];

        // Free servers: [weight, index]
        PriorityQueue<int[]> free = new PriorityQueue<>(
            (a, b) -> {
                if (a[0] != b[0])
                    return Integer.compare(a[0], b[0]);
                return Integer.compare(a[1], b[1]);
            }
        );

        // Busy servers: [finishTime, weight, index]
        PriorityQueue<long[]> busy = new PriorityQueue<>(
            (a, b) -> Long.compare(a[0], b[0])
        );

        for (int i = 0; i < n; i++) {
            free.offer(new int[]{servers[i], i});
        }

        long time = 0;

        for (int i = 0; i < m; i++) {
            time = Math.max(time, (long) i);

            // Release completed servers
            while (!busy.isEmpty() && busy.peek()[0] <= time) {
                long[] server = busy.poll();
                free.offer(new int[]{
                    (int) server[1],
                    (int) server[2]
                });
            }

            // No server available: jump to earliest finish
            if (free.isEmpty()) {
                time = busy.peek()[0];

                while (!busy.isEmpty() && busy.peek()[0] <= time) {
                    long[] server = busy.poll();
                    free.offer(new int[]{
                        (int) server[1],
                        (int) server[2]
                    });
                }
            }

            int[] server = free.poll();
            ans[i] = server[1];

            busy.offer(new long[]{
                time + tasks[i],
                server[0],
                server[1]
            });
        }

        return ans;
    }
}