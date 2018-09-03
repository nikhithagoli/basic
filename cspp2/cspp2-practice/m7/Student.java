import java.util.Scanner;
import java.lang.*;
/**
 * to find average GPA.
*/
public class Student {
    /**
        * class.
    */
    String name, rollnumber;
    /**
     * to calculate average
     *
     * @param      a     marks.
     * @param      b     marks.
     * @param      c     marks.
     */
    void gpa(double a, double b, double c) {
        /**
         * gpa calculation.
         */
        System.out.println((double)((int)(((a + b + c) / 3)*10.0))/10.0);
    }
    Student(String name, String rollnumber, double a, double b, double c) {
        //function
        this.name = name;
        this.rollnumber = rollnumber;
        gpa(a,b,c);
    }
    /**
        * @param args of the program.
    */
    public static void main(final String[] args) {
        /**
           * main function.
        */
        Scanner sc = new Scanner(System.in);
        Student s = new Student(sc.next(), sc.next(), sc.nextDouble(), sc.nextDouble(), sc.nextDouble());
    }
}
