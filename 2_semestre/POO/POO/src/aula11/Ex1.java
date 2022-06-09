package aula11;
import java.util.*;
import java.io.FileReader;
import java.io.IOException;

public class Ex1 {
    public static void main(String argrs[]) throws IOException{
        Scanner file = new Scanner(new FileReader("major.txt"));
        HashMap <String, TreeMap<String, Integer>> list = new HashMap<>();
        //file.useDelimiter("[\\p{Punct}\\p{Space}]+");
        file.useDelimiter("[^\\p{IsAlphabetic}]+"); // isto ou o outro
        while (file.hasNext()) {
            String word = file.next();
            if(!(word.length() < 3)){
                String par="";
                TreeMap <String, Integer> counts;
                if(word.length() % 2 == 0)
                    par = word;
                if(list.containsKey(par)){
                    counts = new TreeMap<>();
                    if(counts.isEmpty())
                        counts.put(word, 1);
                    else if(counts.containsKey(word)){

                    }
                }
                else if(list.containsKey(par) && !word.equals(par))
                    counts = new TreeMap<>();
                    counts.put("word", 1);
                    list.put(par, counts); 
            }

            
        }

        System.out.println(list);
    } 
}
