import java.util.Scanner;
/**
    * program to find quotiemt and remainder of a number when divided by other.
*/
public final class DegreesToFahrenheit {
    /**
        * class.
    */
    private DegreesToFahrenheit() {
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
        int degrees = sc.nextInt();
        final int b = 32;
        final double a = 1.8;
        System.out.println("temp in farenheit: " + (degrees * (a) + b));

    }
}
