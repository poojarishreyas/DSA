class Solution {
    public int scheduleCourse(int[][] courses) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        Arrays.sort(courses,(a,b)->{
            return a[1]-b[1];
        });
        int time=0;
        for(int[] course:courses){
           int duration=course[0];
           int deadline=course[1];
           if(time+duration<=deadline){
                pq.add(duration);
                time+=duration;
           }
           else{
            if(!pq.isEmpty() && pq.peek()>duration){
                time-=pq.poll();
                time+=duration;
                pq.add(duration);
            }
           }

        }
        return pq.size();
    }
}