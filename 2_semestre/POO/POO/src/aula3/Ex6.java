package aula3;
import java.util.*;

import help.Help;

public class Ex6 {
    static Scanner sc = new Scanner(System.in);
    public static void main(String args []){
        int [] mesd = {31,28,31,30,31,30,31,31,30,31,30,31};
        int mes = Help.getint("Introduza um Mes: ");
        double ano = Help.getdouble("Introduza um Ano: ");
        
        boolean bissexto = false;
        if( (ano % 400 == 0) || ( (ano % 4 == 0) && (ano % 100 != 0) ) )
            bissexto= true;

        if(bissexto && mes == 2)
            System.out.print("o Mes tem " + (mesd[mes-1] + 1) + " dias");
        else
            System.out.print("o Mes tem " + + mesd[mes-1]+ " dias");


    }
}
