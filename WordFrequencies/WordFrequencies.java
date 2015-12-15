
import java.util.HashMap;
import java.util.Scanner;
import java.util.Collections;
import java.util.ArrayList;

public class WordFrequencies {
    static HashMap<String, Integer> words = new HashMap<>();//String, occurences
    static boolean caseSensitive;
    static boolean clean;

    public static void main(String[] args) throws Exception {
    
        if(args.length > 0) {
            if(args[0].equals("-sc") || args[0].equals("-cs")) {
                caseSensitive = true;
                clean = true;
            } else if(args[0].equals("-c")) {
                clean = true;
            } else if(args[0].equals("-s")) {
                caseSensitive = true;
            } else {
                System.out.println("Usage: java WordFrequencies [-cs] < file");
                return;
            }
        } else if(args.length > 1) {
            System.out.println("Usage: java WordFrequencies [-cs] < file");
            return;
        }

        Scanner scan = new Scanner(System.in).useDelimiter("[^0-9a-zA-Z\\-\\']");

        while (scan.hasNext()) { // while there is a next argument
            String s = scan.next();

            s = s.replace("-", "");
            s = s.replace("'","");

            if(s.length() == 0) {
                continue;
            }

            if(!caseSensitive) {
                s = s.toUpperCase();
            }

            if(words.get(s) == null) {
                words.put(s,1);
            } else {
                words.put(s, words.get(s) + 1);
            }
        }

        ArrayList<String> list = new ArrayList<String>(words.keySet());

        Collections.sort(list);

        int sum = 0;

        for(String s : list) {
            
            if(!caseSensitive) {
                s = s.toUpperCase();
            }

            if(clean) {
                System.out.println(s);
                continue;
            }
            System.out.println(s + " " + words.get(s));
        }
    }
}
