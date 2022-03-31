package aula2;
import java.util.Scanner;

public class Ex1 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        //Numero em km
        Double km;
        do{
        System.out.print("Distancia em Kilometros:  ");
        km = sc.nextDouble();
        }while(km <0);

        //Converte em milhas
        Double milhas = km/1.609; 
        System.out.print(milhas);

        sc.close();
    }
}
