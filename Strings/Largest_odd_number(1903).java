package Strings;

class Largest_odd_number {

    public static String largestOddNumber(String num) {

        for (int i = num.length() - 1; i >= 0; i--) {
            if (num.charAt(i) % 2 != 0) {
                return num.substring(0, i + 1);

            }
        }
        return "";

    }

    public static void main(String[] args) {
        String num = "1234567";
        String result = largestOddNumber(num);
        System.out.println(result);
    }

}