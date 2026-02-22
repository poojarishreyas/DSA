package Strings;

public class Roman_to_Integer {
     public static int romanToInt(String s) {

        int sum = symbol_to_val(s.charAt(0));

        for (int j = 1; j < s.length(); j++) {

            int prev = symbol_to_val(s.charAt(j - 1));
            int curr = symbol_to_val(s.charAt(j));

            if (prev < curr) {
                // Remove previously added prev and subtract it
                sum += curr - 2 * prev;
            } else {
                sum += curr;
            }
        }

        return sum;
    }

    public static int symbol_to_val(char c) {
        switch (c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
        }
        return 0;
    }
    public static void main(String[] args) {
        String s="MCMXCIV";
        int result=romanToInt(s);
        System.out.println(result);
    }   
}
/* if prev ele<curr ele  then subtract 
    example :IV --> 5-1=4*/
