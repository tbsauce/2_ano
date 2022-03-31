package aula3;
import java.util.*;

public class Ex1 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        //leitura de dados
        Double nt;
        Double np;
        int nf;
        //Nota teorica
        while(true){
            try{
                System.out.print("NotaTeorica:");
                nt = sc.nextDouble();
                if(nt<0 || nt>20)
                    throw new InputMismatchException();
                break;
            }
            catch(InputMismatchException e){
                System.out.print("Input Inválido.\n");
                sc.nextLine();
            }
        }
        //nota pratica
        while(true){
            try{
                System.out.print("NotaPrática:");
                np = sc.nextDouble();
                if(np<0 || np>20)
                    throw new InputMismatchException();
                break;
            }
            catch(InputMismatchException e){
                System.out.print("Input Inválido.\n");
            }
        }

        //Calculo da nota final
        //caso uma das notas seja menor que 7.0
        if(np<7.0 || nt<7.0)
            nf = 66;
        //calculo da nota final    
        else
            nf = (int)(0.4*nt+0.6*np);
        
        System.out.printf("Nota Final -> %d", nf);

        sc.close();
    }
}
