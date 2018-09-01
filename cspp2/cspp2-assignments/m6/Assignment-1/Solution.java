import java.util.Scanner;

/**

 * Write a java program to find the odd composite numbers

 * between 2 and n where n is given as an input.

 *

 * @author :

 */

public final class Solution {

    /**

    * Empty constructor.

    */

    private Solution() {

        //not used

    }

    /**

     * { function_description }.

     *

     * @param      i     { parameter_description }.

     *

     * @return     { description_of_the_return_value }.

     */

    static boolean isprime(final int i) {

        /**

         * { item_description }.

         */

        final int three = 3;

        for (int j = three; j <= Math.sqrt(i); j += 2) {

            if (i % j == 0) {

                return (false);

            }

        }

        return (true);

    }

    /**

     * Prints the odd composite numbers between 2 and n.

     *

     * @param      n     n value

     */

    static void oddComposites(final int n) {

        // write your code here

        final int three = 3;

        for (int i = three; i <= n; i += 2) {

            if (!isprime(i)) {

                System.out.println(i);

            }

        }

    }

    /**

    * main method as driver program.

    * @param args is the parameter for this method

    */

    public static void main(final String[] args) {

        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();

        oddComposites(n);

    }

}

