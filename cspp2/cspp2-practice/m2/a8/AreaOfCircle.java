import java.util.Scanner;
/**
 * { item_description }.
*/
public final class AreaOfCircle {
    /**
        * class.
    */
    private AreaOfCircle() {
        //function
    }
    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }.
     */
    static double pi() {
        /**
         * { item_description }
        */
        final double val = 3.14;
        return (val);
    }
    /**
     * { function_description }.
     *
     * @param      radius  The radius.
     *
     * @return     { description_of_the_return_value }.
     */
    static double area(final int radius) {
        /**
         * { var_description }
        */
        final double piValue = pi();
        return (radius * radius * piValue);
    }
    /**
        * @param args of the program.
    */
    public static void main(final String[] args) {
        /**
           * main function.
        */
        Scanner sc = new Scanner(System.in);
        int radius = sc.nextInt();
        System.out.println("area of triangle: " + area(radius));

    }
}

