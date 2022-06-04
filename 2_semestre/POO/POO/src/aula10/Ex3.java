package aula10;

import java.util.*;

public class Ex3 {
    public static void main(String [] args){

    String text = "hello world";
    TreeMap <Character, ArrayList<Integer>> list = new TreeMap<>();
    
    for (int i = 0; i < text.length(); i++) {
        ArrayList <Integer> a = new ArrayList<>();

        for (int j = 0; j < text.length(); j++) {
            if(text.charAt(i) == text.charAt(j)){
                a.add(j);
            }
        }

        list.put(text.charAt(i), a);
    }

    System.out.println(list);

    }    
}
