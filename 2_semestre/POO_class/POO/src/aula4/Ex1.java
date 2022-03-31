package aula4;
import java.util.*;

public class Ex1 {

    static Scanner sc = new Scanner(System.in);
    public static void main(String args[]){
        String text = sc.nextLine();
        String [] sep = text.split("\\s");
        System.out.print("Uma nova frase, convertida para minúsculas: ");
        System.out.print(text.toLowerCase());
        System.out.print("\nO último carater da frase: ");
        System.out.print(text.charAt(text.length()-1));
        System.out.print("\nOs 3 primeiros carateres: ");
        System.out.print(text.substring(0, 3));
        System.out.print("\nOutros Metodos: \n");
        System.out.println(sep.length + " palavras: "+ Arrays.toString(sep));
        System.out.print("\nTem um maximo de 10 letras?: " + text.matches("\\w{0,10}"));
        System.out.print("\nO texto comeca por 'abc' ? " + text.startsWith("abc"));
        System.out.print("\nTem algum 'poo' ? " + text.contains("poo"));
        System.out.print("\nO texto comeca por 'bye' ? " + text.endsWith("bye"));

        
        
    } 
}
