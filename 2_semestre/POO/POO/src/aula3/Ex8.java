package aula3;
import java.util.*;
import help.Help;

public class Ex8 {
    static Scanner sc = new Scanner(System.in);
    public static void main(String args[]){
        double pauta [][] = new double[3][16];

        for(int i = 0 ; i< 16; i++){
            for(int j = 0 ; j < 2; j++){
                pauta[j][i] = Help.randomdouble(0, 20);
            }

            //Calculo da nota final
            //caso uma das notas seja menor que 7.0
            if(pauta[0][i]<7.0 || pauta[1][i]<7.0)
                pauta[2][i] =66;
            //calculo da nota final    
            else
                pauta[2][i] =0.4* pauta[0][i] +0.6* pauta[1][i]; 
        }

        System.out.printf("NotaT   NotaP   Pauta\n");
        for(int i = 0 ; i< 16; i++){
            for(int j = 0 ; j < 3; j++){
                System.out.printf("%02.2f    ",pauta[j][i]);

            }
            System.out.print("\n");
        }
    }
    
}

