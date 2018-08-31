// Given an String, Write a java method that returns
// the decimal value for the given binary string.
import java.util.Scanner;
/**
 * Class for solution.
 */
public final class Solution {
    /**
    Do not modify this main function.
    */
    private Solution() {
        //constructor.
    }
    /**
     * { function_description }.
     *
     * @param      s     { parameter_description }.
     *
     * @return     { description_of_the_return_value }.
     */
    static String binaryToDecimal(final String s) {
        /**
         * { item_description }.
        */
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                sum += Math.pow(2, (s.length() - 1) - i);
            }
        }
        return (Integer.toString(sum));
    }
    /**
     * { function_description }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        /**
         * { var_description }.
        */
        Scanner sc = new Scanner(System.in);
        String s;
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            s = sc.next();
            String res = binaryToDecimal(s);
            System.out.println(res);
        }
    }
}
