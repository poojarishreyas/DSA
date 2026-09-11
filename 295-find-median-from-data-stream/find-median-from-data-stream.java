class MedianFinder {
    PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;

    public MedianFinder() {
        left=new PriorityQueue<>(Collections.reverseOrder());
        right=new PriorityQueue<>();
    }
    
    public void addNum(int num) {
      if(left.isEmpty() || left.peek()>num){
        left.add(num);
      }
      else{
        right.add(num);
      }
      if(left.size()-1>right.size()){
        right.add(left.poll());
      }
      if(right.size()>left.size()){
        left.add(right.poll());
      }
    }
    
    public double findMedian() {
        int n=left.size()+right.size();
        if(n%2==0){
            return (left.peek()+right.peek())/2.0;

        }
        else{
            return left.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */