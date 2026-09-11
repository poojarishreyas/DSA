class Solution {
    class node{
        int row;
        int ele;
        int col;
        node(int r,int e,int col){
            row=r;
            ele=e;
            this.col=col;
        }
    }
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<node> pq=new PriorityQueue<>((a,b)->{
            return a.ele-b.ele;
        });
        int n=matrix.length;
        for(int i=0;i<n;i++){
            pq.add(new node(i,matrix[i][0],0));
        }
        while(k>1){

            node p=pq.poll();
            if(p.col+1<n){
                pq.add(new node(p.row,matrix[p.row][p.col+1],p.col+1));
            }
            
            k--;

           
        }
        return pq.poll().ele;

    }
}