import java.util.Scanner;
/**
    * helloworld program.
*/
public final class Pattern {
    /**
        * class.
    */
    private Pattern() {
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
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
