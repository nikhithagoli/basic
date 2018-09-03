import java.util.Scanner;
/**
 * Class for input validator.
 *
 */
class InputValidator {
    /** class to validate the input string.
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
     * to validate the input.
     *
     * @return     boolean value.
     */
    boolean validateData() {
        final int six = 6;
        return (len >= six);
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
         * to read the input string.
        */
        Scanner s = new Scanner(System.in);
        String input = s.next();
        InputValidator i = new InputValidator(input);
        System.out.println(i.validateData());
    }
}
