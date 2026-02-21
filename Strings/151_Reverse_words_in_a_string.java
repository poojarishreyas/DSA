package Strings;

class Reverse_words_in_a_string {
    public static String reverseWords(String s) {
        s=s.trim();
        String[] words= s.split("\\s+");
        reverse(words);
        return String.join(" ",words);


    }
    static void reverse(String[] words){
        int i=0;
        int j=words.length-1;
        while(i<j){
            String temp=words[i];
            words[i]=words[j];
            words[j]=temp;
            i++;
            j--;
        }


    }
    public static void main(String[] args) {
        String s="  hello world  ";
        String result=reverseWords(s);
        System.out.println(result);
    }
}