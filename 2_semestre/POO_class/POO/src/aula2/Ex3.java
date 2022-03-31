package aula2;
import java.util.Scanner;

public class Ex3 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        //leitura da massa, temperaturas inicial e final 
        Double M;
        Double tf;
        Double ti;
        //massa
        do{
        System.out.print("Mass(kg):  ");
        M = sc.nextDouble();
        }while(M<=0);

        //ti
        System.out.print("Temperatura Inicial(ºC):  ");
        ti = sc.nextDouble();

        //tf
        System.out.print("Temperatura Final(ºC):  ");
        tf = sc.nextDouble();

        //Converte em milhas
        Double Q = M * (tf-ti) * 4184; 
        System.out.print(Q + "J");

        sc.close();
    }
}
