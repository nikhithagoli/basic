import java.util.Scanner;
/**
 * Class for input validator.
 *
 */
class InputValidator {
    /**Write the atrributes and methods for InputValidator.
     */
    final int len;
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
        if (len >= 6) {
            return (true);
        }
        return (false);
    }
}
/**
 * Class for solution.
 */
public class Solution {
    /**
     * main class.
     */
    /**
     * @param      args   The string
     */
    private Solution(){
        //constructor.
    }
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
