import java.util.Scanner;
/**
    * program to print my name and roll number.
*/
public final class Solution {
    /**
        * class.
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
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        int rollnumber = sc.nextInt();
        System.out.println("Name :" + name + "\nRoll Number : " + rollnumber);
    }
}
