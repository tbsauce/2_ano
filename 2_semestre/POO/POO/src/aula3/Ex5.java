package aula3;
import java.util.*;

public class Ex5 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        double N;
        double taxa;
        while(true){
            try{
                System.out.print("Introduza o investimento:");
                N = sc.nextDouble();
                if (N <1000 || N % 1000!=0 )
                    throw new InputMismatchException();
                break;
            }
            catch(InputMismatchException e){
                System.out.print("Input Inválido.\n");
                sc.nextLine();
            }
        }
        while(true){
            try{
                System.out.print("Introduza uma taxa entre 0% e 5%:");
                taxa = sc.nextDouble();
                if (taxa < 0 || taxa >5)
                    throw new InputMismatchException();
                break;
            }
            catch(InputMismatchException e){
                System.out.print("Input Inválido.\n");
                sc.nextLine();
            }
        }

        for(int i = 0; i<=12; i++){
            System.out.printf("Mes %d -> %.2f \n", i, N);
            N += N *(taxa/100);         
    
            
        }
    
        sc.close();
    }
}
