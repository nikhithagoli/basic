import java.util.Scanner;
import java.lang.*;
/**
 * { item_description }.
*/
public final class Concatinate {
    /**
        * class.
    */
    private Concatinate() {
        //function
    }
    /**
     * { function_description }.
     *
     * @param      name  The name.
     */
    static void helloName(String name) {
        /**
         * { item_description }.
         */
        System.out.println("Hello " + name + "!");
    }
    /**
        * @param args of the program.
    */
    public static void main(final String[] args) {
        /**
           * main function.
        */
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        helloName(name);
    }
}

