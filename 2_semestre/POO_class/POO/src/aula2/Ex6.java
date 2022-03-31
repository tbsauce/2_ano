package aula2;
import java.util.*;

public class Ex6 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        //leitura do tempo em segundos
        int s;
        do{
            System.out.print("Tempo em Segundos:  ");
            s = sc.nextInt();
        }while(s<0);

        //calculos
        int h = s / 3600;
        int hr = s % 3600;

        int m = hr / 60;
        s =hr % 60;


        System.out.printf("%02d:%02d:%02d", h, m, s);

        sc.close();
    }
}
