class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n=0;
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                n++;
                if(n<=k){
                    pq.add(matrix[i][j]);
                }
                else{
                    if(pq.peek()>matrix[i][j]){
                        pq.poll();
                        pq.add(matrix[i][j]);
                    }
                }
            }
        }
        return pq.poll();
    }
}