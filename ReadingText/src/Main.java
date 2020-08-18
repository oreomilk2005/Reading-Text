import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        //Reader reads the lines in "ProgrammingHistory.txt" and puts each line into the ArrayList of Strings until no there are no more lines.
        ArrayList<String> lines = new ArrayList<>();
        FileReader fr = new FileReader("ProgrammingHistory.txt");
        BufferedReader br = new BufferedReader(fr);
        String line;
        while ((line = br.readLine()) != null) {
            lines.add(line);
        }
        br.close();
    }

    public static void search(String word, ArrayList<String> lines){
        int found = 0;
        System.out.print("The word is ");
        //For every lines, for every string of length word length inside the line, if the word equals to the string and the next character is a space or symbol, then we found an additional word.
        //We record the finding by increasing the integer found and print the index position of the line and word
        for(String s:lines){
            for(int j=0; j<s.length()-word.length(); j++){
                if(s.substring(j, j+word.length()).equals(word) && s.charAt(j+word.length())<=64){
                    found ++;
                    System.out.print("\nIn index position of: Line: "  + lines.indexOf(s) + " Position: " + j + " to " + (j+word.length()));
                }
            }
        }
        //if nothing was found, then we print "not found"
        if(found == 0) System.out.print("not found.");
    }
}
