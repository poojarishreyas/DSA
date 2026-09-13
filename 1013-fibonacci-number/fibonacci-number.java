class Solution {
    public int fib(int n) {
        int prev=1;
        int prev_prev=0;
        if(n<=1) return n;
        int ans=0;
        for(int i=2;i<=n;i++){
            ans=prev+prev_prev;
            prev_prev=prev;
            prev=ans;
        }
        return ans;
        
    }
}