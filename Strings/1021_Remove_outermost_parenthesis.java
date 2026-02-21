package Strings;

class Remove_outermost_parenthesis {
    public static String removeOuterParentheses(String s) {
        StringBuilder res=new StringBuilder();
        int counter=0;

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                if(counter>0){
                    res.append(s.charAt(i));
                }
                counter++;
            }
            if(s.charAt(i)==')'){
                counter--;
                if(counter>0){
                    res.append(s.charAt(i));
                }
                
            }

        }
        return res.toString();
    }
    public static void main(String[] args) {
        String s="(()())(())";
        String result=removeOuterParentheses(s);
        System.out.println(result);
    }
}