// Given an String, Write a java method that returns
// the decimal value for the given binary string.
import java.util.Scanner;
/**
 * Class for solution.
 */
public final class Solution {
    /*
    Do not modify this main function.
    */
    private Solution() {
        //constructor.
    }
    /**
     * { item_description }.
     */
    static String binaryToDecimal(String s){
        /**
         * { item_description }.
         */
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '1'){
                sum += Math.pow(2, (s.length() - 1) - i);
            }
        }
        return (Integer.toString(sum));
    } 
	/**
	 * { function_description }.
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
        /**
         * { var_description }.
         */
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			String s = sc.nextLine();
			String res = binaryToDecimal(s); //Write binaryToDecimal function
			System.out.println(res);
		}
	}

}
