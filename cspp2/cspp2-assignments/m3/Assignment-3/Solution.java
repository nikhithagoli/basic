import java.util.Scanner;
/**
    Do not modify this main function.
*/
public final class Solution {
    /**
     * Constructs the object.
    */
    private Solution() {
        //function
    }
    /**
     * { function_description }.
     *
     * @param      a     { parameter_description }.
     * @param      b     { parameter_description }.
     *
     * @return     { description_of_the_return_value }.
     */
    static int gcd(final int a, final int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return (a);
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
        Scanner s = new Scanner(System.in);
        int n1 = s.nextInt();
        int n2 = s.nextInt();
        System.out.println(gcd(n1, n2));
    }
    /*
     *Need to write the gcd function and print the output.
    */
}
