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
    static boolean isprime(final int i) {
        for (int j = 3; j <= Math.sqrt(i); j += 2) {
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
        for (int i = 3; i <= n; i += 2 ) {
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
