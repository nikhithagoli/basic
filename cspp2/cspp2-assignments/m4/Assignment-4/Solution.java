import java.util.Scanner;
/**
 * { item_description }.
 */
public final class Solution {
/**
 * Constructs the object.
 */
    private Solution() {
        //function.
    }
    /**
     * { function_description }.
     *
     * @param      s     { parameter_description }.
     *
     * @return     { description_of_the_return_value }.
     */
    static String reverseString(final String s) {
        /**
         * { var_description }.
         */
        String r = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            r += s.charAt(i);
        }
        return (r);
    }
    /**
     * { function_description }.
     *
     * @param      args  The arguments.
     */
    public static void main(final String[] args) {
        /**
         * { var_description }.
         */
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String reverse = reverseString(s);
        System.out.println(reverse);
    }
}
