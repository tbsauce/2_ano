package aula2;
import java.util.*;

public class Ex4 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        //investimento leitura
        Double inv;
        do{
            System.out.print("montante investido:  ");
            inv = sc.nextDouble();
        }while(inv<0);


        //taxa de investimento
        Double taxa;
        do{
            System.out.print("Taxa de investimento mensal:  ");
            taxa = sc.nextDouble();
            taxa = taxa /100;
        }while(taxa<=0 && taxa >100);

        //calculo final
        int meses = 3;
        Double valfinal=taxa * inv+inv; //1 mes
        for(int i= 0; i< meses - 1 ; i++){
            valfinal = taxa * valfinal+ valfinal; // resto dos meses
        }

        System.out.printf("O valor total ao final de %d meses é %.2f.", meses, valfinal);

        sc.close();
    }
}
