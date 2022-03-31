package aula4;

import java.util.*;

public class Ex2 {
    static Scanner sc = new Scanner(System.in);
    public static void main(String args[]){
        System.out.print("Escreva um Texto:");
        String text = sc.nextLine();

        System.out.println("The text has " + countdig(text)+ " Digits");
        System.out.println("The text has " + countspaces(text)+ " Spcaces");
        System.out.println("The text is in Lowercase " + islowercase(text));
        System.out.println(fewerspaces(text));
        System.out.println("The text is polindromo " + ispalíndromo(text));
    }

    public static int countdig(String text){
        return text.replaceAll("[\\D]", "").length();
    }

    public static int countspaces(String text){ 
        return text.replaceAll("[\\S]", "").length();
    }

    public static boolean islowercase(String text){
        return text.equals(text.toLowerCase());
    }

    public static String fewerspaces(String text){
        return text.replaceAll("[\\s]+", " ");
    }

    public static Boolean ispalíndromo(String text){
        for (int i = 0; i < (text.length()/2); i++) {
            if(text.charAt(i) !=  text.charAt((text.length()-1) - i))
                return false;
        }
        return true;
    }
}
