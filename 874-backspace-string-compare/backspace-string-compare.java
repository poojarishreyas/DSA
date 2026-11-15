class Solution {
    public boolean backspaceCompare(String s, String t) {
        int i=s.length()-1;
        int j=t.length()-1;
        int scount=0;
        int tcount=0;
        while(i>=0 || j>=0){
            while(i>=0){
                if(s.charAt(i)=='#'){
                    i--;
                    scount++;
                }
                else if(scount!=0){
                    i--;
                    scount--;
                }
                else{
                    break;
                }
            }
            while(j>=0){
                if(t.charAt(j)=='#'){
                    j--;
                    tcount++;
                }
                else if(tcount!=0){
                    j--;
                    tcount--;
                }
                else{
                    break;
                }
            }
            if((i>=0)!= (j>=0) ){
                return false;
            }
            if(i >= 0 && j >= 0 &&s.charAt(i)!=t.charAt(j)) return false;
            else{
                i--;
                j--;
            }
        }
        return true;

    }
}