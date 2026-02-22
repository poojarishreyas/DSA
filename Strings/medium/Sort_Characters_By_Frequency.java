package Strings.medium;
import java.util.*;
public class Sort_Characters_By_Frequency {
  public static String frequencySort(String s) {
        Map<Character,Integer> map=new HashMap<>();
        StringBuilder sb=new StringBuilder();
        for(char ele:s.toCharArray()){
            map.put(ele,map.getOrDefault(ele,0)+1);
        }
        List<Character> arr=new ArrayList<>(map.keySet());
        arr.sort((a,b)-> map.get(b)-map.get(a));
        for(char ele:arr ){
            for(int i=0;i<map.get(ele);i++){
                sb.append(ele);
            }
        }
        return sb.toString();

        
    }
    public static void main(String[] args) {
        String s="tree";
        String result=frequencySort(s);
        System.out.println(result);
    }
}
/*Step 1: Store character frequencies in a HashMap
→ Count how many times each character appears.

Step 2: Create a List using map.keySet()
→ This gives all unique characters.

Step 3: Sort the List using a custom comparator
→ Sort based on frequency stored in the map.
→ Use descending order (highest frequency first).

Comparator idea:
map.get(b) - map.get(a)

Step 4: Append characters into StringBuilder
→ For each character in the sorted list,
→ Append it frequency number of times.

Step 5: Return the final StringBuilder result.*/
