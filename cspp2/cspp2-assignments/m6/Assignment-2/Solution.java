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
     * @param      r     Number of rows
     * @param      c     Number of columns
     *
     * @return     Matrix of the rounded elements
     */
    static int[][] round(final int[][] a, final int r, final int c) {
        // write ypur code here
        final int h = 100;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int num = a[i][j];
                String s = Integer.toString(num);
                if (num <= h) {
                    if (num < (h - num)) {
                        a[i][j] = 0;
                    } else {
                        a[i][j] = h;
                    }
                } else {
                    String s1 = String.valueOf(s.charAt(0));
                    int n = Integer.parseInt(s1);
                    int upper = (h * (n + 1));
                    int lower = (h * n);
                    if ((num - lower) < (upper - num)) {
                        a[i][j] = lower;
                    } else {
                        a[i][j] = upper;
                    }
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
        int[][] b = round(a, m, n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n - 1; j++) {
               System.out.print(b[i][j] + " ");
            }
            System.out.println(b[i][n - 1]);
        }
    }
}
