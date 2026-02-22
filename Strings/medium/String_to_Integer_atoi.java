package Strings.medium;

public class String_to_Integer_atoi {
    public static int myAtoi(String s) {

        int i = 0, sign = 1, result = 0;
        int n = s.length();

        // Step 1: Skip leading whitespaces
        while (i < n && s.charAt(i) == ' ') i++;

        // Step 2: Check for optional sign
        // If '-' → sign = -1
        // If '+' → sign = +1 (default)
        if (i < n && (s.charAt(i) == '-' || s.charAt(i) == '+')) {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }

        // Step 3: Process numeric digits
        while (i < n && Character.isDigit(s.charAt(i))) {

            // Convert char → integer digit
            // Works because digits are contiguous in Unicode/ASCII
            int digit = s.charAt(i) - '0';

            // Step 4: Prevent overflow BEFORE multiplication
            // We avoid checking (result * 10 + digit) directly
            // because that expression itself may overflow.
            //
            // Safe condition derived from:
            // result * 10 + digit ≤ Integer.MAX_VALUE
            // result ≤ (Integer.MAX_VALUE - digit) / 10
            if (result > (Integer.MAX_VALUE - digit) / 10) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            // Shift digits left (×10) and append new digit
            result = result * 10 + digit;

            i++;
        }

        // Step 5: Apply sign
        return result * sign;
    }
    public static void main(String[] args) {
        String s="   -42";
        int result=myAtoi(s);
        System.out.println(result);
    }
}
