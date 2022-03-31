package aula3;

import java.util.*;


public class Ex3 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        int N, count=0 ;
        while(true){
            try{
                System.out.print("Introduza um Numero:");
                N = sc.nextInt();
                if (N < 0)
                    throw new InputMismatchException();
                break;
            }
            catch(InputMismatchException e){
                System.out.print("Input Inválido.\n");
                sc.nextLine();
            }
        }
        Boolean primo = true;
        if(N == 1)
            primo = false;
        else{
            for(int i = 2; i < N ; i++){
                if(N % i ==0)
                    count++;
            }
            if(count != 0)
                primo = false;
        }
            
        if(primo)
            System.out.print("É Primo.");
        else
            System.out.print("Não é Primo.");

        sc.close();
    }
}
