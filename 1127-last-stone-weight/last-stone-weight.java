class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int ele: stones){
            pq.add(ele);
        }
        while(pq.size()>1){
            int elem1=pq.poll();
            int elem2=pq.poll();
            if(elem1-elem2>0){
                pq.add(elem1-elem2);
            }
        }
         return pq.isEmpty() ? 0 : pq.poll();
    }
}