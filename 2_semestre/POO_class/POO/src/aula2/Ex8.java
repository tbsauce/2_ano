package aula2;
import java.util.*;

public class Ex8 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        Double c1, c2;

        do{
            System.out.print("A-C:  ");
            c1 = sc.nextDouble();
        }while(c1 < 0);
        do{
            System.out.print("B-C:  ");
            c2 = sc.nextDouble();
        }while(c1 < 0);

        //hipotenusa
        Double h = Math.sqrt(Math.pow(c1,2)+ Math.pow(c2,2));

        Double ang = Math.toDegrees(Math.acos(c1 / h));

        System.out.printf("A hipotenusa e %.2f e o angulo entre A e C é %.2f", h, ang);

        sc.close();
    }
}
