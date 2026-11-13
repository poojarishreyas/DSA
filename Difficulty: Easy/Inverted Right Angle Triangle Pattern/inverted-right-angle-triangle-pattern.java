class Solution {
    public void rightPattern(int n) {
        // code here
        for(int i=0;i<n;i++){
            for(int j=n-i;j>0;j--){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}