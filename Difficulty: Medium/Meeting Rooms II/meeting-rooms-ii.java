class Solution {
    public int minMeetingRooms(int[] start, int[] end) {
        // code here 
        Arrays.sort(start);
        Arrays.sort(end);
        int i=0;
        int j=0;
        int n=start.length;
        int m=end.length;
        int max=1;
        int count=0;
        while(i<n && j<m){
            if(start[i]<end[j]){
                count++;
                i++;
            }
            else{
                j++;
                count--;
            }
            max=Math.max(count,max);
        }
        return max;
        
        
        
    }
}
