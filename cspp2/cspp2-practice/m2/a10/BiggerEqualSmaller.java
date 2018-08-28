import java.util.Scanner;
/**
 * { item_description }.
 */
public final class BiggerEqualSmaller {
    /**
        * class.
    */
    private BiggerEqualSmaller() {
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
        int varA = sc.nextInt();
        int varB = sc.nextInt();
        if (varA > varB) {
            System.out.println("Bigger");
        } else if (varA < varB) {
            System.out.println("Smaller");
        } else {
            System.out.println("Equal");
        }

    }
}
