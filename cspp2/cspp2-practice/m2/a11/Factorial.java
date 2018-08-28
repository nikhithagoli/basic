import java.util.Scanner;
/**
 * { item_description }.
 */
public final class Factorial {
    /**
        * class.
    */
    private Factorial() {
        //function
    }
    /**
     * { function_description }.
     *
     * @param      num   The number.
     *
     * @return     { description_of_the_return_value }.
     */
    static int factorial(final int num) {
        /**
         * { item_description }.
         */
        if (num == 1 || num == 1) {
            return (1);
        } else {
            return (num * factorial(num - 1));
        }
    }
    /**
        * @param args of the program.
    */

    public static void main(final String[] args) {
        /**
            * main function.
        */
        Scanner sc = new Scanner(System.in);
        final int num = sc.nextInt();
        System.out.println(factorial(num));

    }
}
