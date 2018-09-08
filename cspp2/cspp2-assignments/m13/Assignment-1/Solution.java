import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Arrays;

/**
 * Class for set.
 * @author :
 */
class Set {
    //your code goes here...
    //Good luck :-)
    /**
    *class
    */
    private int[] set;
    private int size;
    /**
     * Constructs the object.
     */
     Set() {
        final int ten = 10;
        set = new int[ten];
        final int zero = 0;
        size = zero;
    }
    /**
     * size.
     *
     * @return     int
     */
    public int size() {
        return size;
    }
    /**
     * contains function.
     *
     * @param      item  The item
     *
     * @return     int
     */
    public boolean contains(final int item) {
        for (int each : set) {
            if (each == item) {
                return true;
            }
        }
        return false;
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        if (size == 0) {
            return "{}";
        }
        String s = "";
        for (int i = 0; i < size; i++) {
            s += ", " + Integer.toString(set[i]);
        }
        return "{" + s.substring(2) + "}";
    }
    /**
     * resizes.
     */
    public void resize() {
        set =  Arrays.copyOf(set, set.length * 2);
    }
    /**
     * add.
     *
     * @param      item  The item
     */
    public void add(final int item) {
        if (size == set.length) {
            resize();
        } else {
            if (!this.contains(item)) {
                set[size++] = item;
            }
        }
    }
    /**
     * add All.
     *
     * @param      items  The items
     */
    public void add(final int[] items) {
        for (int element : items) {
            add(element);
        }
    }
    /**
     * intersection.
     *
     * @param      b     { parameter_description }
     *
     * @return     object
     */
    public Set intersection(final Set b) {
        Set result = new Set();
        /*for (int ele: b.set){
            if(this.contains(ele)){
                result.add(ele);
            }
        }*/
        for (int ele : set) {
            for (int y : b.set) {
                if (ele == y) {
                    result.add(ele);
                }
            }
        }
        return result;
    }
    /**
     * retains all elements.
     *
     * @param      array  The array
     *
     * @return     object.
     */
    public Set retainAll(final int[] array) {
        Set res = new Set();
        /*for (int e: array){
            if (this.contains(e)){
                res.add(e);
            }
        }*/
        for (int e : set) {
            for (int x : array) {
                if (e == x) {
                    res.add(e);
                }
            }
        }
        return res;
    }
    /**
     * get.
     *
     * @param      index  The index
     *
     * @return     int
     */
    public int get(final int index) {
        return set[index];
    }
    /*public String[][] cartesianProduct(Set newset){
        int row = this.size();
        int col = newset.size();
        String[][] product = new String[row][col];
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                String r = Integer.toString(this.set[i]);
                String c = Integer.toString(newset.set[j]);
                product[i][j] ="[" + r + ", " + c + "]";
            }
        }
        return product;

    }*/
    /**
     * cartesian product.
     *
     * @param      newset  The newset
     *
     * @return     2-d array.
     */
    public int[][] cartesianProduct(final Set newset) {
        int row = this.size() * newset.size();
        int col = 2;
        int[][] product = new int[row][col];
        int k = 0;
        for (int i = 0; i < this.size(); i++) {
            for (int j = 0; j < newset.size(); j++) {
                product[k][0] = this.get(i);
                product[k][1] = newset.set[j];
                k += 1;
            }
        }
        return product;
    }

}
/**
 * Solution class for code-eval.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * helper function to convert string input to int array.
     *
     * @param      s     { string input from test case file }
     *
     * @return     { int array from the given string }
     */
    public static int[] intArray(final String s) {
        String input = s;
        if (input.equals("[]")) {
            return new int[0];
        }
        if (s.contains("[")) {
            input = s.substring(1, s.length() - 1);
        }
        return Arrays.stream(input.split(","))
               .mapToInt(Integer::parseInt)
               .toArray();
    }
    /**
     * main function to execute test cases.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        // instantiate this set
        Set s = new Set();
        // code to read the test cases input file
        Scanner stdin = new Scanner(new BufferedInputStream(System.in));
        // check if there is one more line to process
        while (stdin.hasNext()) {
            // read the line
            String line = stdin.nextLine();
            // split the line using space
            String[] tokens = line.split(" ");
            // based on the list operation invoke the corresponding method
            switch (tokens[0]) {
            case "size":
                System.out.println(s.size());
                break;
            case "contains":
                System.out.println(s.contains(Integer.parseInt(tokens[1])));
                break;
            case "print":
                System.out.println(s);
                break;
            case "add":
                int[] intArray = intArray(tokens[1]);
                if (intArray.length == 1) {
                    s.add(intArray[0]);
                } else {
                    s.add(intArray);
                }
                break;
            case "intersection":
                s = new Set();
                Set t = new Set();
                intArray = intArray(tokens[1]);
                s.add(intArray);
                intArray = intArray(tokens[2]);
                t.add(intArray);
                System.out.println(s.intersection(t));
                break;
            case "retainAll":
                s = new Set();
                intArray = intArray(tokens[1]);
                s.add(intArray);
                intArray = intArray(tokens[2]);
                System.out.println(s.retainAll(intArray));
                break;
            case "cartesianProduct":
                s = new Set();
                t = new Set();
                intArray = intArray(tokens[1]);
                s.add(intArray);
                intArray = intArray(tokens[2]);
                t.add(intArray);
                if (t.size() == 0 || s.size() == 0) {
                    System.out.println("null");
                } else {
                    System.out.println(Arrays.
                    deepToString(s.cartesianProduct(t)));
                }
                break;
            default:
                break;
            }
        }
    }
}
