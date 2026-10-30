class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->{
            return a[0]-b[0];
        });
        ArrayList<int[]> res=new ArrayList<>();
        res.add(intervals[0]);
        for(int i=1;i<intervals.length;i++){
            if(res.get(res.size()-1)[1]<intervals[i][0]){
                res.add(intervals[i]);
            }
            else{
                res.get(res.size()-1)[1]=Math.max(res.get(res.size()-1)[1],intervals[i][1]);
            }
        }
        return res.toArray(new int[res.size()][2]);
    }
}