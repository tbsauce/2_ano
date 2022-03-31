package aula3;

import java.util.*;

public class Ex2 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        int N;
        while(true){
            try{
                System.out.print("Introduza um Número Positivo:");
                N = sc.nextInt();
                if(N<0)
                    throw new InputMismatchException();
                break;
            }
            catch(InputMismatchException e){
                System.out.print("Input Inválido.");
                sc.nextLine();
            }
        }

        for (int i = N  ; i>=0; i--)
            if(i == 0)
                System.out.print(i);
            else
                System.out.print(i+"->");
        sc.close();
    }
}
