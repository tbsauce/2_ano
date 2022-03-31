package aula2;
import java.util.Scanner;

public class Ex2 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        //Numero em Celcius
        Double C;
        do{
        System.out.print("Distancia em celcius:  ");
        C = sc.nextDouble();
        }while(C<=0);

        //Converte em Fahrenheit
        Double F = 1.8 * C + 32; 
        System.out.print(F);

        sc.close();
    }
}
