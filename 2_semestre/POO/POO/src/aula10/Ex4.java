package aula10;

import java.util.*;
import java.io.FileReader;
import java.io.IOException;

public class Ex4 {
    public static void main(String[] args) throws IOException{
        Scanner input = new Scanner(new FileReader("aula10/words.txt"));
        HashSet <String> list = new HashSet<>();

        while (input.hasNext()) {
            String word = input.next();
            System.out.println(word);

            if(word.length() > 2)
                list.add(word);

            if(!word.matches("[a-zA-Z]+"))
                list.remove(word);
        }

        for (String string : list) {
            if(string.endsWith("s"))
                System.out.println(string);                
        }

        System.out.println(list);
    
    }
}
