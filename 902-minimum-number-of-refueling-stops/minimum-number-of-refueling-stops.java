class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int reach=startFuel;
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        int stop=0;
        int idx=0;
        while(reach<target){
              while(idx<stations.length && reach>=stations[idx][0]){
                pq.add(stations[idx][1]);
                idx++;
            }
            if(!pq.isEmpty()){
                reach+=pq.poll();
                stop++;
            }
            else{
                return -1;
            }
        }
          
           
        
        return stop;

           

            
        


    }
}