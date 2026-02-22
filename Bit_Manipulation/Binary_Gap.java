package Bit_Manipulation;

public class Binary_Gap {
    public static int binaryGap(int n) {
        String Binary=Integer.toBinaryString(n);
        
        int i=0;
        int j=1;
        int max=0;
        while(j<Binary.length()){
            if(Binary.charAt(i)!='1'){
                i++;
            }
            if(Binary.charAt(j)!='1'){
                j++;
            }
            
            if(j<Binary.length() &&Binary.charAt(i)=='1' && Binary.charAt(j)=='1' ){

                max=Math.max(max,j-i);
                i=j;
                j++;
            }
        }
        return max;
       
    }
    public static void main(String[] args) {
        int n=22;
        int result=binaryGap(n);
        System.out.println(result);
    }
}
