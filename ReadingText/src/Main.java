import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static ArrayList<String> lines = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("ProgrammingHistory.txt");
        BufferedReader br = new BufferedReader(fr);
        String line;
        while ((line = br.readLine()) != null) {
            lines.add(line);
        }
        br.close();
        //Trying
        System.out.println("Please enter the word you are searching for: ");
        Scanner scan = new Scanner(System.in);
        String word = scan.next();
        search(word);
    }

    public static void search(String word){
        int found = 0;
        System.out.print("The word is ");
        for(String s:lines){
            for(int j=0; j<s.length()-word.length(); j++){
                if(s.substring(j, j+word.length()).equals(word)){
                    found ++;
                    System.out.print("\nIn index position of: Line: "  + lines.indexOf(s) + " Position: " + j + " to " + (j+word.length()));
                }
            }
        }
        if(found == 0) System.out.print("not found.");
    }
}
