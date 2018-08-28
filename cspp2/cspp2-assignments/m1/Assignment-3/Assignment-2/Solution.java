import java.util.Scanner;
/**
    * program to print my name and roll number.
*/
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        /**
            //function.
        */
    }
    /**
     * { function_description }.
     *
     * @param      base    The base.
     * @param      height  The height.
     *
     * @return     { description_of_the_return_value }
     */
    double areaOfTriangle(final int base, final int height) {
        /**
         * are of triangle.
        */
        final double a = 0.5;
        return (base * height * a);
    }
    /**
     * { function_description }.
     *
     * @param      args  The arguments.
     */
    public static void main(final String[] args) {
        /**
            * { var_description }.
        */
        Scanner scan = new Scanner(System.in);
        int base = scan.nextInt();
        int height = scan.nextInt();
        Solution area = new Solution();
        System.out.println(area.areaOfTriangle(base, height));
    }
    /*
    Need to fill the areaOfTriangle function and print the output
    of fahrenheit.
    */
}
