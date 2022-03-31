package aula2;
import java.util.*;

public class Ex7 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        
        System.out.print("P1\n");
        System.out.print("x:" );
        int x1 = sc.nextInt();
        System.out.print("y:" );
        int y1 = sc.nextInt();

        System.out.print("P2\n");
        System.out.print("x:" );
        int x2 = sc.nextInt();
        System.out.print("y:" );
        int y2 = sc.nextInt();

        //calcular
        Double dist = Math.sqrt(Math.pow(x2-x1, 2)+Math.pow(y2-y1, 2));
        System.out.printf("A distancia entre os dois pontos é %.2f", dist);

        sc.close();
    }
}
