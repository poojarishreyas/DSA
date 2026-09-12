class Solution {
    PriorityQueue<Integer> left =
        new PriorityQueue<>(Collections.reverseOrder());

    PriorityQueue<Integer> right =
        new PriorityQueue<>();

  

    HashMap<Integer, Integer> map = new HashMap<>();

    public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        double[] res = new double[n - k + 1];

        for (int i = 0; i < k; i++) {
            if(left.isEmpty() || left.peek()>=nums[i] ){
                left.add(nums[i]);
            }
            else{
                right.add(nums[i]);
            }
            if(left.size()>right.size()+1){
                right.add(left.poll());

            }
            if(right.size()>left.size()){
                left.add(right.poll());
            }
        }
        res[0]=median(k);
        

        for(int i=k;i<n;i++){
            int counter=0;
            int numA=nums[i];
            int numR=nums[i-k];
            map.put(numR,map.getOrDefault(numR,0)+1);
            if(numA<=left.peek()){
                left.add(numA);
                counter++;

            }
            else{
                right.add(numA);
                counter--;
            }
            if(numR<=left.peek()){
                counter--;
            }
            else{
                counter++;
            }
            if(counter>0){
                right.add(left.poll());
            }
            if(counter<0){
                left.add(right.poll());

            }
            while(!left.isEmpty() && map.getOrDefault(left.peek(),0)>0){
               int p= left.poll();
               map.put(p,map.get(p)-1);

            }
               while(!right.isEmpty() && map.getOrDefault(right.peek(),0)>0){
               int p= right.poll();
               map.put(p,map.get(p)-1);

            }
            res[i-k+1]=median(k);

        }
        return res;
        
    }
    public double median(int k) {
        if (k % 2 == 0) {
            return ((long) left.peek() + right.peek()) / 2.0;
        } 
        else {
            return left.peek();
        }
    }
}