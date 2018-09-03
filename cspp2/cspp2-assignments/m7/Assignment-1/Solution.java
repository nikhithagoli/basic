import java.util.Scanner;
/**
 * Class for input validator.
 *
 */
class InputValidator {
    /**Write the atrributes and methods for InputValidator.
     */
    private int len;
    /**
     * Constructs the object.
     *
     * @param      str   The string
     */
    InputValidator(final String str) {
        len = str.length();
    }
    /**
     * { function_description }.
     *
     * @return     boolean value.
     */
    boolean validateData() {
        final int six = 6;
        if (len >= six) {
            return (true);
        }
        return (false);
    }
}
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * main class.
     */
    private Solution() {
        //constructor.
    }
    /**
     * @param      args   The string
     */
    public static void main(final String[] args) {
        /**
         * { var_description }.
        */
        Scanner s = new Scanner(System.in);
        String input = s.next();
        InputValidator i = new InputValidator(input);
        System.out.println(i.validateData());
    }
}
