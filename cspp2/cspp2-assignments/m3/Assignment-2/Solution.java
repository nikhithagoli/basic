import java.util.Scanner;
/**
    Do not modify this main function.
*/
public final class Solution {
/** Fill the main function to print the number of 7's between 1 to n.
*/
    private Solution() {
        //function 
    }
    /**
        * @param args of the program.
    */
    public static void main(final String[] args) {
        /**
            * main function.
        */
        Scanner s = new Scanner(System.in);
        final int n = s.nextInt();
        int count = 0;
        final int seven = 7;
        final int ten = 10;
        for (int i = 1; i <= n; i++) {
            int num = i;
            while (num > 0) {
                int digit = num % ten;
                num = num / ten;
                if (digit == seven) {
                    count += 1;
                }
            }
        }
        System.out.println(count);
    }

}
