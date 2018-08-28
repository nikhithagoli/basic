import java.util.Scanner;
/**
    * program to find quotiemt and remainder of a number when divided by other.
*/
public final class QuotientRemainder  {
    /**
        * class.
    */
    private QuotientRemainder() {
        //function
    }

    /**
        * @param args of the program.
    */

    public static void main(final String[] args) {
        /**
            * main function.
        */
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println("Quotient: " + a / b);
        System.out.println("Remainder: " + a % b);
    }
}
