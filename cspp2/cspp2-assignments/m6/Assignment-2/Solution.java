import java.util.Scanner;
/**
 * Write a java program to round the
 * elements of a matrix to the nearest 100.
 *
 * @author : 
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //not used
    }
    /**
     * Function to round the
     * elements of a matrix to the nearest 100.
     *
     * @param      a     Matrix of which the elements to be rounded
     * @param      rows     Number of rows
     * @param      columns     Number of columns
     *
     * @return     Matrix of the rounded elements
     */
    static int[][] roundHundred(final int[][] a, final int rows, final int columns) {

	// write ypur code here
	    for (int i = 0; i < rows; i++) {
            for (int j =0; j < columns; j++) {
                int num = a[i][j];
                String s = Integer.toString(num);
                int noofdigits = s.length();
                if (noofdigits <= 2) {
                    a[i][j] = (num < (100 - num)) ? 0 :100;
                } else {
                    int n = (int) s.charAt(0);
                    a[i][j] = (num - (100 * n)) < ((100 * (n+1)) - num) ? (100 * n) : (100 * (n+1));
                }
            }
        }
        return (a);
    }
    /**
     * Main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int m = scan.nextInt();
        int n = scan.nextInt();
        int[][] a = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = scan.nextInt();
            }
        }
        int[][] b = roundHundred(a, m, n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n - 1; j++) {
                System.out.print(b[i][j] + " ");
            }
            System.out.println(b[i][n - 1]);
        }
    }
}
