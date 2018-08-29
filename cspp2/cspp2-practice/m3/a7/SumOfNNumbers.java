import java.util.Scanner;
/**
    * helloworld program.
*/
public final class SumOfNNumbers {
    /**
        * class.
    */
    private SumOfNNumbers() {
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
        final int n = sc.nextInt();
        System.out.println(n * (n + 1) / 2);
    }
}
