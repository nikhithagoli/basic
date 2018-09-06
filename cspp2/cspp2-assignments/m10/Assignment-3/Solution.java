import java.io.BufferedInputStream;
import java.util.Scanner;
//A Class is implemented for Student details
/**
* student class.
*/
class Student {
    /**
    * class.
    */
    private String name;
    /**
    * Constructs the object.
    *
    * @param      n  The name
    */
    Student(final String n) {
    //A constructor used to initialize the instance variables
        this.name = n;
    }
    /**
    * Gets the name.
    *
    * @return     The name.
    */
    public String getName() {
    //Getter method which returns the value of instance variable
        return this.name;
    }

    @Override
    /**
     * { function_description }
     *
     * @param      other  The other
     *
     * @return     { description_of_the_return_value }
     */
    public boolean equals(final Object other) {
    //This method is to check if two students names are equal or not
        if (!(other instanceof Student)) {
            return false;
        }

        Student that = (Student) other;
        return this.getName().equals(that.getName());
    }
    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }
     */
    public int hashCode() {
        return this.hashCode();
    }
    /**
    * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        return this.name;
    }
}
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //function.
    }
    /**
     * for strings.
     */
    static void strings(String line){
        List<String> listString = new List();
                // split the line using space
                String[] tokens = line.split(" ");
                switch (tokens[0]) {
                case "add":
                    listString.add(tokens[1]);
                    break;
                case "addAll":
                    if (tokens.length == 2) {
                        String[] t1 =
                         tokens[1].split(",");
                        listString.addAll(t1);
                    }
                    break;
                case "size":
                    System.out.println(listString.size());
                    break;
                case "print":
                    System.out.println(listString);
                    break;
                case "remove":
                    listString.remove(Integer.
                    parseInt(tokens[1]));
                    break;
                case "indexOf":
                    System.out.println(listString.
                    indexOf(tokens[1]));
                    break;
                case "get":
                    System.out.println(listString.
                    get(Integer.parseInt(tokens[1])));
                    break;
                case "contains":
                    System.out.println(listString.
                        contains(tokens[1]));
                    break;
                default:
                    break;
                
            }
    }
    /**
     * for integers.
     */
    static void integers(String line){
        List<Integer> listInteger = new List();
            
                String[] tokens = line.split(" ");
                switch (tokens[0]) {
                case "add":
                    listInteger.add(Integer.
                        parseInt(tokens[1]));
                    break;
                case "addAll":
                    if (tokens.length == 2) {
                        String[] t1 =
                         tokens[1].split(",");
                        Integer[] temp =
                         new Integer[t1.length];
                        for (int i = 0;
                         i < temp.length; i++) {
                            temp[i] =
                            Integer.parseInt(t1[i]);
                        }
                        listInteger.addAll(temp);
                    }
                    break;
                case "size":
                    System.out.println(listInteger.size());
                    break;
                case "print":
                    System.out.println(listInteger);
                    break;
                case "remove":
                    listInteger.remove(Integer.
                        parseInt(tokens[1]));
                    break;
                case "indexOf":
                    System.out.println(listInteger.
                    indexOf(Integer.parseInt((tokens[1]))));
                    break;
                case "get":
                    System.out.println(listInteger.
                    get(Integer.parseInt(tokens[1])));
                    break;
                case "contains":
                    System.out.println(listInteger.
                    contains(Integer.
                        parseInt((tokens[1]))));
                    break;
                default:
                    break;
            }
    }
    /**
     * for floats.
     */
    static void floats(String line){
         List<Float> listFloat = new List();
                String[] tokens = line.split(" ");
                switch (tokens[0]) {
                case "add":
                    listFloat.add(Float.
                        parseFloat(tokens[1]));
                    break;
                case "addAll":
                    if (tokens.length == 2) {
                        String[] t1 =
                         tokens[1].split(",");
                        Float[] temp =
                         new Float[t1.length];
                        for (int i = 0;
                         i < t1.length; i++) {
                            temp[i] =
                            Float.parseFloat(t1[i]);
                        }
                        listFloat.addAll(temp);
                    }
                    break;
                case "size":
                    System.out.println(listFloat.size());
                    break;
                case "print":
                    System.out.println(listFloat);
                    break;
                case "remove":
                    listFloat.remove(Integer.
                    parseInt(tokens[1]));
                    break;
                case "indexOf":
                    System.out.println(listFloat.
                    indexOf(Float.parseFloat(tokens[1])));
                    break;
                case "get":
                    System.out.println(listFloat.
                    get(Integer.parseInt(tokens[1])));
                    break;
                case "contains":
                    System.out.println(listFloat.
                    contains(Float.parseFloat(tokens[1])));
                    break;
                default:
                    break;
                
            }
    }
    /**
     * for chars.
     */
    static void characters(String line){
        List<Character> listCharacter = new List();
                String[] tokens = line.split(" ");
                switch (tokens[0]) {
                case "add":
                    listCharacter.add(tokens[1].charAt(0));
                    break;
                case "addAll":
                    if (tokens.length == 2) {
                        String[] t1 =
                         tokens[1].split(",");
                        Character[] temp =
                         new Character[t1.length];
                        for (int i = 0;
                         i < t1.length; i++) {
                            temp[i] =
                             t1[i].charAt(0);
                        }
                        listCharacter.addAll(temp);
                    }
                    break;
                case "size":
                    System.out.println(
                        listCharacter.size());
                    break;
                case "print":
                    System.out.println(listCharacter);
                    break;
                case "remove":
                    listCharacter.remove(Integer.
                        parseInt(tokens[1]));
                    break;
                case "indexOf":
                    System.out.println(listCharacter.
                        indexOf(tokens[1].charAt(0)));
                    break;
                case "get":
                    System.out.println(listCharacter.
                    get(Integer.parseInt(tokens[1])));
                    break;
                case "contains":
                    System.out.println(listCharacter.
                        contains(tokens[1].charAt(0)));
                    break;
                default:
                    break;
                
            }
    }
    /**
     * for doubles.
     */
    static void doubles(String line){
        List<Double> listDouble = new List();
                String[] tokens = line.split(" ");
                switch (tokens[0]) {
                case "add":
                    listDouble.add(Double.
                        parseDouble(tokens[1]));
                    break;
                case "addAll":
                    if (tokens.length == 2) {
                        String[] t1 =
                         tokens[1].split(",");
                        Double[] temp =
                         new Double[t1.length];
                        for (int i = 0;
                         i < t1.length; i++) {
                            temp[i] = Double.
                            parseDouble(t1[i]);
                        }
                        listDouble.addAll(temp);
                    }
                    break;
                case "size":
                    System.out.println(listDouble.size());
                    break;
                case "print":
                    System.out.println(listDouble);
                    break;
                case "remove":
                    listDouble.remove(Integer.
                    parseInt(tokens[1]));
                    break;
                case "indexOf":
                    System.out.println(listDouble.
                    indexOf(Double.parseDouble(tokens[1])));
                    break;
                case "get":
                    System.out.println(listDouble.
                    get(Integer.parseInt(tokens[1])));
                    break;
                case "contains":
                    System.out.println(listDouble.
                    contains(Double.
                    parseDouble(tokens[1])));
                    break;
                default:
                    break;
                
            }
    }
    /**
     * for objects.
     */
    static void objects(String line){
        List<Student> listStudent = new List();
                String[] tokens = line.split(" ");
                switch (tokens[0]) {
                case "add":
                    listStudent.add(new Student(tokens[1]));
                    break;
                case "addAll":
                    if (tokens.length == 2) {
                        String[] t1 =
                            tokens[1].split(",");
                        Student[] temp =
                            new Student[t1.length];
                        for (int i = 0;
                             i < t1.length; i++) {
                            temp[i] =
                             new Student(t1[i]);
                        }
                        listStudent.addAll(temp);
                    }
                    break;
                case "size":
                    System.out.println(listStudent.size());
                    break;
                case "print":
                    System.out.println(listStudent);
                    break;
                case "remove":
                    listStudent.remove(Integer.
                    parseInt(tokens[1]));
                    break;
                case "indexOf":
                    System.out.println(listStudent.
                    indexOf(new Student(tokens[1])));
                    break;
                case "get":
                    System.out.println(listStudent.
                    get(Integer.parseInt(tokens[1])));
                    break;
                case "contains":
                    System.out.println(listStudent.
                    contains(new Student(tokens[1])));
                    break;
                default:
                    break;
            }
    }
    /**
     * main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        // create an object of the list to invoke methods on it
        Scanner stdin = new Scanner(new BufferedInputStream(System.in));
        String objectType = stdin.nextLine();

        switch (objectType) {
        case "S":
            while (stdin.hasNext()) {
                // read the line
                String line = stdin.nextLine();
                strings(line);
            }
            break;

        case "I":
            while (stdin.hasNext()) {
                // read the line
                String line = stdin.nextLine();
                integers(line);
            }
            break;

        case "F":
            while (stdin.hasNext()) {
                // read the line
                String line = stdin.nextLine();
                floats(line);
            }
            break;

        case "C":
            while (stdin.hasNext()) {
                // read the line
                String line = stdin.nextLine();
                characters(line);
            }
            break;

        case "D":
            while (stdin.hasNext()) {
                // read the line
                String line = stdin.nextLine();
                doubles(line);
            }
            break;

        case "O":
            while (stdin.hasNext()) {
                // read the line
                String line = stdin.nextLine();
                objects(line);
            }
            break;
        default:
            break;
        
    }
}
}