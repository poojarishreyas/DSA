package Strings.medium;

public class Maximum_Nesting_Depth_of_the_Parentheses {
       public static int maxDepth(String s) {
 /*       Deque<Character> stack=new ArrayDeque<>();
        int max=0;
        for(char ele:s.toCharArray()){
            if(ele=='('){
                stack.push(ele);
            }
            if(ele==')'){
                max=Math.max(max,stack.size());
                stack.pop();

            }
        }
        return max;*/
        int max=0;
        int count=0;
        for(char ele:s.toCharArray()){
            if(ele=='('){
                count++;
            }
            if(ele==')'){
                max=Math.max(max,count);
                count--;

            }
        }
        return max;
    }
    public static void main(String[] args) {
        String s="(1+(2*3)+((8)/4))+3";
        int result=maxDepth(s);
        System.out.println(result);
    }
}
/*Step 1: Initialize two variables
→ count → tracks current nesting depth
→ max   → stores maximum depth found

Step 2: Traverse the string character by character

Step 3: When '(' is encountered
→ Increment count (entering deeper level)

Step 4: When ')' is encountered
→ Update max using current count
→ Decrement count (exiting one level)

Step 5: Continue until entire string is processed

Step 6: Return max as final depth*/


