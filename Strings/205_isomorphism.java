// class Solution {
//     public boolean isIsomorphic(String s, String t) {
//         if(s.length()!= t.length()) return false;

//         int[] mapS = new int[256];
//         int[] mapT = new int[256];

//         for(int i = 0; i < s.length(); i++) {

//             char c1 = s.charAt(i);
//             char c2 = t.charAt(i);

//             if(mapS[c1] != mapT[c2]) return false;

//             mapS[c1] = i + 1;
//             mapT[c2] = i + 1;
//         }
//         return true;
//     }
// }
package Strings;
import java.util.HashMap;
class isomorphism {
    public static boolean isIsomorphic(String s, String t) {

        HashMap<String, String> map = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {

            String key = "" + s.charAt(i);
            String value = "" + t.charAt(i);

            if (!map.containsKey(key)) {

                if (!map.containsValue(value)) {
                    map.put(key, value);
                } else {
                    return false;
                }

            } else {
                if (!map.get(key).equals(value)) {
                    return false;
                }
            }
        }

        return true;
    }
    public static void main(String[] args) {
        String s="egg";
        String t="add";
        boolean result=isIsomorphic(s,t);
        System.out.println(result);
    }
}
