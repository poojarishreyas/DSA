class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n=piles.length;
        int low=1;
        int max= piles[0];
        for(int ele:piles){
            max=Math.max(ele,max);
        }
        int high=max;
        int res=-1;
        while(low<=high){
            int guess=low+(high-low)/2;
            if(guess>0 && time(piles,guess)>h){
                low=guess+1;
            }
            else{
                res=guess;
                high=guess-1;
            }
        }
        return res;
    }
    public long time(int[] piles,int speed){
        long time=0;
        for(int ele:piles){
            time+=ele/speed;
            if(ele%speed !=0){
                time++;
            }

        }
        return time;
    }
}