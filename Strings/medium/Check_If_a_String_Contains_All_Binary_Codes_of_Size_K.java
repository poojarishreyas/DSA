package Strings.medium;
import java.util.*;
public class Check_If_a_String_Contains_All_Binary_Codes_of_Size_K {
     public static boolean hasAllCodes(String s, int k) {
        Set<String> set=new HashSet<>();
        for(int i=0;i<=s.length()-k;i++){
            
            set.add(s.substring(i,i+k));

        }
        if(set.size()!=Math.pow(2,k)){
            return false;
        }
        return true;


    }
    public static void main(String[] args) {
        String s="101101100101";
        int k=2;
        boolean result=hasAllCodes(s,k);
        System.out.println(result);
    }
}
/*step 1: sliding  window of  size k
 step2: store sliding window substring in set to avoid duplicates 
 step 3: check hther the seize of set==2^k


 alternatv bit manipulaton
 class Solution {
    public boolean hasAllCodes(String s, int k) {
        int need = 1 <<k;
        int n = s.length();

        if(n<k || n-k+1 < need)
        return false;

        boolean[] seen = new boolean[need];
        int hash = 0;
        int allOnes = need -1;
        int count = 0;

        for(int i=0; i<n; i++) {
            hash = ((hash << 1) & allOnes) | (s.charAt(i) - '0');
             if(i >= k-1){
                if(!seen[hash]){
                    seen[hash]=true;
                    count++;
                    if(count == need)
                    return true;
                }
             }
        }
        return false;
    }
}*/