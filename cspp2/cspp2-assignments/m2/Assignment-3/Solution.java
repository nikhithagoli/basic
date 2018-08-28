/**.
    * this is main class.
*/
import java.util.Scanner;
/**.
    *  function for taking user inputs
*/
public final class Solution {
    /**.
    Do not modify this main function.
    */
    private Solution() {
        /**
        this is constructor.
        */
    }
    /**.
        * @param args of type string : command line arguments
    */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int base = sc.nextInt();
        int exponent = sc.nextInt();
        long res = power(base, exponent);
        System.out.println(res);
    }
    /**.
    the power function.
    *@return float
    /**
    * comment of function
    * @param base **this is base number**
    * @param exponent **this is exponent number**
    */
    public static long power(final int base, final int exponent) {
        if (exponent == 0) {
            return 1;
        } else {
            return (base * power(base, exponent - 1));
        }
    }
}
