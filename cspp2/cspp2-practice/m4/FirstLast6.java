import java.util.Scanner;
import java.lang.*;
/**
 * { item_description }.
*/
public final class FirstLast6 {
    /**
        * class.
    */
    private FirstLast6() {
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
        System.out.println("enter array elements: ");
        for(int i = 0; i < n;i++){
            a[i] = sc.nextInt();
        }
        System.out.println(a[0] == 6 || a[a.length-1] == 6);
    }
}

