import java.util.Scanner;
public class Solution
{   /**
    Do not modify the main function. 
    */
    private Solution() {
        //function.
    }
    static String reverseString(String s) {
        String r = "";
        for(int i = s.length()-1; i >= 0; i--){
            r += s.charAt(i);
        }
        return (r);
    }
    /**
     * { function_description }.
     *
     * @param      args  The arguments.
     */
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        String reverse=reverseString(s);	
        System.out.println(reverse);
		
    }
}
