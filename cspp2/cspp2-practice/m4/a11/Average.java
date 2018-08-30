import java.util.Scanner;
import java.lang.*;
/**
 * { item_description }.
*/
public final class Average {
    /**
        * class.
    */
    private Average() {
        //function
    }
    /**
        * @param args of the program.
    */
    public static void main(final String[] args) {
        /**
           * main function.
        */
        Scanner sc = new Scanner(System.in);
        System.out.println("array length: ");
        int n = sc.nextInt();
        int[] a = new int[n];
        int sum = 0; 
        System.out.println("enter array elements: ");
        for(int i = 0; i < n;i++){
            a[i] = sc.nextInt();
            sum += a[i];
        }

        System.out.println(sum/a.length);
    }
}

