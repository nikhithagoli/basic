import java.util.Scanner;
/**
 * Class for solution.
 */
public final class Solution {
	/** 
	 * Fill the main function to print resultant of addition of matrices
	 */
	private Solution(){
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
		int m,n,p,q;
		Scanner sc = new Scnner(System.in);
		m = sc.nextInt();
		n = sc.nextInt();
		p = sc.nextInt();
		q = sc.nextInt();
		int[][] a = new int[m][n];
		int[][] b = new int[p][q];
		for(int i = 0; i < m ; i++){
			for(int j =0; j < n; j++){
				a[i][j] = sc.nextInt();
			}
		}
		for(int i = 0; i < p ; i++){
			for(int j =0; j < q; j++){
				b[i][j] = sc.nextInt();
			}
		}				
		if(m == p && n == q){
			int[][] c = new int[m][n];
			for(int i = 0; i < m ; i++){
				for(int j =0; j < n; j++){
					c[i][j] = a[i][j] + b[i][j];
					System.out.println(c[i][j]);
				}
			}
		}
		else{
			System.out.println("matrix addition is not possible");
		}
	}
}