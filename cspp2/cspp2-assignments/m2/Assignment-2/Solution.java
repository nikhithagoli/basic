import java.util.Scanner;
/**
 * { item_description }.
 */
public final class Solution {
    /**
    Do not modify this main function.
    */
    private Solution() {
        /**
        //function.
        */
    }
    /**
     * { function_description }.
     *
     * @param      a     { parameter_description }.
     * @param      b     { parameter_description }.
     * @param      c     { parameter_description }.
     */
    static void roots(final int a, final int b, final int c) {
        /**
         * { var_description }.
        */
        double discriminant = Math.sqrt((b * b) - (4 * a * c));
        double root1, root2;
        if (discriminant > 0) {
            root1 = (-b + discriminant) / (2 * a);
            root2 = (-b - discriminant) / (2 * a);

            System.out.println(root1 + " " + root2);
        } else if (discriminant == 0) {
            root1 = -b / (2 * a);
            root2 = -b / (2 * a);
            System.out.println(root1 + " " + root1);
        } else {
            double real = -(double)b / (2 * a);
            double img = discriminant / (2 * a);

            System.out.println(real + "+ i" + img + "  " + real + "- i" + img);
        }
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
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();
        roots(a, b, c);
    }
    /*
    Need to write the rootsOfQuadraticEquation
    function and print the output.
    */
}
