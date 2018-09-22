import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
/**
 * Class for common string.
 */
class CommonString {
    /**
     * file1.
     */
    private String file1;
    /**
     * file2.
     */
    private String file2;
    /**
     * lcs.
     */
    private int lcs = 1;
    /**
     * result.
     */
    private Double result;
    /**
     * res.
     */
    private Double res;
    /**
     * Constructs the object.
     *
     * @param      input1  The input 1
     * @param      input2  The input 2
     */
    CommonString(final String input1, final String input2) {
        file1 = input1;
        file2 = input2;
    }
    /**
     * { function_description }.
     *
     * @param      one   One
     * @param      two   Two
     * @param      m     { parameter_description }
     * @param      n     { parameter_description }
     */
    public void common(final char[] one, final char[] two,
        final int m, final int n) {
        final double h = 100.0;
        Double[][] longest = new Double[m + 1][n + 1];
        result = 0.0;
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    longest[i][j] = 0.0;
                } else if (one[i - 1] == two[j - 1]) {
                    longest[i][j] = longest[i - 1][j - 1] + 1;
                    result = Double.max(result, longest[i][j]);
                } else {
                    longest[i][j] = 0.0;
                }
            }
        }
        res = (double) Math.round((((result * 2) / (m + n)) * h));
    }
    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }
     */
    public Double getresult() {
        return res;
    }
}
/**
 * Class for solution.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //funtion.
    }
    /**
     * { function_description }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner input = new Scanner(System.in);
        // if (testfiles.length == 0) {
        //     System.out.println("empty Directory");
        // } else {
        try {
            File testcase = new File(input.nextLine());
            File[] testfiles = testcase.listFiles();

            System.out.print("             ");
            for (File name : testfiles) {
                System.out.print(name.toString().split("\\\\")[1] + "    ");

            }

            ArrayList<String> fileStrings = new ArrayList<>();
            ArrayList<CommonString> objects = new ArrayList<>();
            for (File filename : testfiles) {
                try {
                    String content = new String(Files.
                    readAllBytes(Paths.get(filename.getAbsolutePath())));
                    content = content.replaceAll("\n", " ")
                    .replaceAll("[^A-Za-z0-9 ]", "").replaceAll("\\s+", " ");
                    fileStrings.add(content);
                } catch (Exception e) {
                    System.out.println("file not found");
                }
            }
            int k = 0;
            int i = 1;
            for (String input1 : fileStrings) {
                System.out.println();
                System.out.print("File" + i + ".txt" + "        ");
                for (String input2 : fileStrings) {
                    objects.add(new CommonString(input1, input2));
                    objects.get(k).common(input1.toCharArray(),
                    input2.toCharArray(), input1.length(), input2.length());
                    System.out.print(objects.get(k).getresult() + "         ");
                    k++;
                }
                i++;
            }
        } catch (Exception e) {
            System.out.println("Empty Directory");
        }
    }

}
