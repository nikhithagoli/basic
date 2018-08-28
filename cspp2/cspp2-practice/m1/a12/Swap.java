import java.util.Scanner;
/**
    * program to swap two numbers.
*/
public final class Swap {
    /**
        * class.
    */
    private Swap() {
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
        int temp = a;
        a = b;
        b = temp;
        System.out.println(a + " " + b);
    }
}
