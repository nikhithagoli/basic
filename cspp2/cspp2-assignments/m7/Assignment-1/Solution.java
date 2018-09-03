import java.util.Scanner;
/**
 * Class for input validator.
 *
 */
class InputValidator {
	/*Write the atrributes and methods for InputValidator*/
	int len;
	/**
	 * Constructs the object.
	 *
	 * @param      str   The string
	 */
	InputValidator(String str) {
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
public class Solution {
	/**
	 * main class.
	 */
	public static void main(String args[]) {
		/**
		 * { var_description }.
		 */
		Scanner s = new Scanner(System.in);
		String input = s.next();
		InputValidator i = new InputValidator(input);
		System.out.println(i.validateData());

	}

}
