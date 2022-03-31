package aula2;
import java.util.*;
public class Ex5 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        //leitura
        Double v1;
        do{
            System.out.print("Velocidade 1:  ");
            v1 = sc.nextDouble();
        }while(v1<0);

        Double d1;
        do{
            System.out.print("Distancia 1:  ");
            d1 = sc.nextDouble();
        }while(d1<0);

        Double v2;
        do{
            System.out.print("Velocidade 2:  ");
            v2 = sc.nextDouble();
        }while(v2<0);

        Double d2;
        do{
            System.out.print("Distancia 2:  ");
            d2 = sc.nextDouble();
        }while(d2<0);


        //calculos
        Double t1 = d1/v1;
        Double t2 = d2/v2;

        Double vm = ((d2+d1)/(t2+t1));

        System.out.printf("A velocidade Média e de %.2d.", vm);

        sc.close();
    }
}
