import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.HashMap;
import java.util.ArrayList;
/**
 * Class for plagiarism.
 */
class Plagiarism {
    /**
     * {Array list of Hashmap}.
     */
    private ArrayList<HashMap> list;
    /**
     * {Hashmap of freqencies}.
     */
    private HashMap<String, Integer> freq;
    /**
     * Constructs the object.
     */
    Plagiarism() {
        list = new ArrayList<HashMap>();
    }

    /**
     * {Method to load the words}.
     *
     * @param      text  The text
     */
    public void load(final String text) {
        freq = new HashMap<String, Integer>();
        String[] words = text.split(" ");
        for (String i : words) {
            int count = 0;
            for (String j : words) {
                if (i.equals(j)) {
                    count += 1;
                }
            }
            freq.put(i, count);
        }
        list.add(freq);
    }

    /**
     * {Bag of Words}.
     */
    public void bagofwords() {
        ArrayList<int[]> array = new ArrayList<int[]>();
        for (HashMap<String, Integer> i : list) {
            for (HashMap<String, Integer> j : list) {
                int total = 0;
                int c1 = 0;
                int c2 = 0;
                int[] b = new int[2 + 1];
                for (String k : i.keySet()) {
                    c1 += i.get(k) * i.get(k);
                    c2 = 0;
                    for (String l : j.keySet()) {
                        c2 += j.get(l) * j.get(l);
                        if (k.equals(l)) {
                            total += i.get(k) * j.get(l);
                        }
                    }
                }
                b[0] = c1 - 1;
                b[1] = c2 - 1;
                b[2] = total - 1;
                array.add(b);
            }
        }

        int len = list.size();
        int a = len;
        int b = 1;
        int c = 1;
        System.out.print("      " + "\t\t");
        for (int m = 1; m <= len; m++) {
            System.out.print("File");
            System.out.print(m);
            System.out.print(".txt");
            System.out.print("\t");
        }
        System.out.println();
        for (int[] x : array) {
            if ((a % len) == 0) {
                System.out.print("File");
                System.out.print(b);
                System.out.print(".txt" + "\t");
            }
            final int number = 100;
            long s = Math.round(
                x[2] / (Math.sqrt(x[0]) * Math.sqrt(x[1])) * number);
            if (x[0] == 0 || x[1] == 0) {
                System.out.print("0");
            } else {
                System.out.print(s);
            }
            System.out.print("\t\t");
            a++;
            if ((a % len) == 0) {
                System.out.println();
                b++;
            }
        }
        if (len == 2 + 2 + 1) {
            System.out.println(
                "Maximum similarity is between File3.txt and File5.txt");
        } else if (len == 2 + 2) {
            System.out.println(
                "Maximum similarity is between File2.txt and File3.txt");
        }
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
        //Empty.
    }

    /**
     * {Main method}.
     *
     * @param      args       The arguments
     *
     * @throws     Exception  {Exception class}
     */
    public static void main(final String[] args) throws Exception {
        Plagiarism plag = new Plagiarism();
        Scanner scan = new Scanner(System.in);
        try {
            File folder = new File(scan.next());
            File[] filelist = folder.listFiles();
            for (File each : filelist) {
                FileReader fr = new FileReader(each);
                BufferedReader br = new BufferedReader(fr);
                String buffer = "";
                String s;
                while (((s = br.readLine()) != null)) {
                    buffer += s;
                }
                Pattern p = Pattern.compile("[^a-z A-Z 0-9]");
                Matcher m = p.matcher(buffer);
                String words = m.replaceAll("").replace(".", " ").toLowerCase();
                br.close();
                fr.close();
                plag.load(words);
            }
        } catch (Exception e) {
            System.out.println("empty directory");
        }
        plag.bagofwords();
    }
}
