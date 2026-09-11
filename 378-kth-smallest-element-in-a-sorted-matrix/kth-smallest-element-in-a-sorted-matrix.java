class Solution {
    class Pair {
        int value;
        int row;
        int col;

        Pair(int value, int row, int col) {
            this.value = value;
            this.row = row;
            this.col = col;
        }
    }

    public int kthSmallest(int[][] matrix, int k) {

        int n = matrix.length;

        PriorityQueue<Pair> pq =
            new PriorityQueue<>((a, b) -> a.value - b.value);

        // Put first element of every row
        for (int i = 0; i < n; i++) {
            pq.add(new Pair(matrix[i][0], i, 0));
        }

        // Remove smallest k-1 times
        for (int i = 0; i < k - 1; i++) {

            Pair p = pq.poll();

            // Move to next element in same row
            if (p.col + 1 < n) {
                pq.add(new Pair(
                    matrix[p.row][p.col + 1],
                    p.row,
                    p.col + 1
                ));
            }
        }

        return pq.poll().value;
    }
}