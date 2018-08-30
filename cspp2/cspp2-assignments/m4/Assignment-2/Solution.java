import java.util.Scanner;
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Fill the main function to print resultant of addition of matrices.
    */
    private Solution() {
       //function.
    }
    /**
     * { function_description }.
     *
     * @param      args  The arguments.
     */
    public static void main(final String[] args) {
        /**
         * { item_description }.
         */
        int m, n, p, q;
        Scanner sc = new Scanner(System.in);
        m = Integer.parseInt(sc.next());
        n = Integer.parseInt(sc.next());
        int[][] a = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = Integer.parseInt(sc.next());
            }
        }
        p = Integer.parseInt(sc.next());
        q = Integer.parseInt(sc.next());
        int[][] b = new int[p][q];
        for (int i = 0; i < p; i++) {
            for (int j = 0; j < q; j++) {
                b[i][j] = Integer.parseInt(sc.next());
            }
        }
        if (m == p && n == q) {
            int[][] c = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    c[i][j] = a[i][j] + b[i][j];
                }
                String s = "";
                for (int ele : c[i]) {
                    s += Integer.toString(ele) + " ";
                }
                System.out.println(s.substring(0, s.length() - 1));
            }
        } else {
            System.out.println("not possible");
        }

    }
}
