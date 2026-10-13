class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int max=weights[0];
        int total=0;
        for(int ele:weights){
            max=Math.max(max,ele);
            total+=ele;
        }
        int low=max;
        int high=total;
        int res=-1;
        while(low<=high){
            int guess=low+(high-low)/2;
            if(check(weights,days,guess)){
                res=guess;
                high=guess-1;
            }
            else{
                low=guess+1;
            }
        }
        return res;

    }
    public boolean check(int[] weights,int days,int guess){
        int sum=0;
        int k=days;
        for(int ele:weights){
            
            if(sum+ele<=guess){
                sum+=ele;                
            }
            else{
                days--;
                
                sum=ele;
            }
        }
       if(days<=0){
        return false;
       }
       else{
        return true;
       }
        
    }
}