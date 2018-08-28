import java.util.Scanner;
/**
 * Class for solution.
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
     * Calculates the from degrees to farenheit.
     *
     * @param      degreesCelsius  The degrees celsius.
     *
     * @return     The from degrees to farenheit.
     */
    double calculateFromDToF(final double degreesCelsius) {
        final int b = 32;
        final double a = 1.8;
        return ((degreesCelsius * a) + b);
    }
    /**
     * { function_description }.
     *
     * @param      args  The arguments.
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        double degreesCelsius = scan.nextDouble();
        Solution degree = new Solution();
        double f = degree.calculateFromDToF(degreesCelsius);
        System.out.println(f);
    }
    /*
    Need to fill the calculateFromDegreesToFarenheit function
    and print the output of fahrenheit.
    */
}
