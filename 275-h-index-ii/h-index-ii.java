class Solution {
    public int hIndex(int[] citations) {
        int low=1;
        int high=citations[citations.length-1];
        int res=0;
        
        while(low<=high){
            int guess=low+(high-low)/2;
            if(check(citations,guess)){
                res=guess;
                low=guess+1;
            }
            else{
                high=guess-1;
            }
        }
        return res;
    }
    public boolean check(int[] citations,int guess){
        int count =0;
        for(int ele:citations){
            if(ele>=guess){
                count++;
            }
           
        }
         if(count>=guess){
                return true;
            }
        return false;
    }
}