class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if(bloomDay.length<(long) m*k){
            return -1;
        }
        int low=0;
        int max=bloomDay[0];
        for(int ele:bloomDay){
            max=Math.max(max,ele);
        }
        int high=max;
        int res=-1;
        while(low<=high){
            int guess=low+(high-low)/2;
            if(check(bloomDay, m, k,guess)){
                res=guess;
                high=guess-1;
            }
            else{
                low=guess+1;
            }
        }
        return res;
    }
    public boolean check(int[] bloomDay,int m,int k,int guess){
        int temp=k;
        for(int i=0;i<bloomDay.length;i++){
            if(bloomDay[i]<=guess){
                k--;
                if(k==0){
                    m--;
                    k=temp;
                }
                if(m==0){
                    return true;
                }
            }
            else{
                k=temp;
            }
        }
        return false;
    }
}