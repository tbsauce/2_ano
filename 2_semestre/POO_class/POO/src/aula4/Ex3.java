package aula4;
import java.util.*;

public class Ex3 {
    static Scanner sc = new Scanner(System.in);
    public static void main(String args[]){
        System.out.print("Introduza um texto: ");
        String text = sc.nextLine();
        System.out.print("Este é o acronimo " + acronimo(text));
    }

    public static String acronimo(String text){
        String [] sep = text.split("\\s");
        String ac="";
        for (int i = 0; i < sep.length; i++) {
            if(sep[i].length() >= 3){
                ac += sep[i].charAt(0);
            }
        }
        return ac.toUpperCase();
    }
}
