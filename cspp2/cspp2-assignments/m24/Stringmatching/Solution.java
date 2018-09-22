import java.util.*;
import java.lang.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
class CommonString{
	private String file1;
	private String file2;
	private int lcs = 1;
	private Double result;
	private Double res;
	CommonString(String input1, String input2){
		file1 = input1;
		file2 = input2;
	}
	public void common(char X[], char Y[], int m, int n)  
    { 
        Double longest[][] = new Double[m + 1][n + 1]; 
        result = 0.0; 
        for (int i = 0; i <= m; i++){ 
            for (int j = 0; j <= n; j++){ 
                if (i == 0 || j == 0){ 
                    longest[i][j] = 0.0;
                } 
                else if (X[i - 1] == Y[j - 1]){ 
                    longest[i][j] = longest[i - 1][j - 1] + 1; 
                    result = Double.max(result, longest[i][j]); 
                }  
                else
                    longest[i][j] = 0.0; 
            } 
        } 
        res = (double)Math.round((((result * 2) /(m + n)) * 100d));
    }
	public Double getresult(){
		return res;
	}
}
class Solution{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
        File testcase = new File(input.nextLine());
        File[] testfiles = testcase.listFiles();
        for (File name : testfiles) {
            System.out.print("\t" + name.toString().split("\\\\")[1]);
        }
        
        ArrayList<String> fileStrings = new ArrayList<>();
        ArrayList<CommonString> objects = new ArrayList<>();
        for(File filename: testfiles){
        	try{
    		String content = new String(Files.readAllBytes(Paths.get(filename.getAbsolutePath())));
        	content = content.replaceAll("\n"," ").replaceAll("[^A-Za-z0-9 ]", "").replaceAll("\\s+", " ");
        	fileStrings.add(content);
        	} catch(Exception e){
        		System.out.println("file not found");
        	}
        }
        int k = 0;
        int i = 1;
        for(String input1: fileStrings){
            System.out.println();
            System.out.print("File" + i + ".txt" + "\t");
        	for(String input2: fileStrings){
        		objects.add(new CommonString(input1, input2));
        		objects.get(k).common(input1.toCharArray(),input2.toCharArray(),input1.length(),input2.length());
        		System.out.print(objects.get(k).getresult() + "\t");
        		k++;

        	}
            i++;
            System.out.println();
        }
	}
	
}