package aula11;
import java.util.*;
import java.io.FileReader;
import java.io.IOException;

public class Ex1 {
    public static void main(String argrs[]) throws IOException{
        Scanner file = new Scanner(new FileReader("aula11/major.txt"));
        HashMap <String, TreeMap<String, Integer>> list = new HashMap<>();
        file.useDelimiter("[^\\p{IsAlphabetic}0-9]+");
        String save = "";
        while (file.hasNext()) {
            String word = file.next();
            
            if(!(word.length() < 3)){
                if(list.get(save)!= null){
                    TreeMap<String, Integer> a = list.get(save);
                    if(a.containsKey(word))
                        a.put(word, a.get(word) + 1);
                    else
                        a.put(word, 1);
                }
                save = "";
                if(word.length() % 2 == 0){
                    save = word;
                    if(!list.containsKey(word))
                        list.put(word, new TreeMap<>());
                }
            }
            
        }

        System.out.println(list);
    } 
}
