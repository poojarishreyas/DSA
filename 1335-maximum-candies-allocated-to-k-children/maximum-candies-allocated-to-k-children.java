class Solution {
    public int maximumCandies(int[] candies, long k) {
        long low=1;
        long max=candies[0];
        for(int ele:candies){
            max=Math.max(ele,max);
        }
        long high=max;
        long res=0;
        while(low<=high){
            long guess= low+(high-low)/2;
            if(check(candies,k,guess)){
                res=guess;
                low=guess+1;
            }
            else{
                high=guess-1;
            }
        }
        return (int)res;
    }
    public boolean check(int[] candies,long k,long candy){
        long count =0;
        for(int ele:candies){
             count+=(ele/candy);
            if(count>=k){
                return true;
            }
        }
        return false;
    }
}