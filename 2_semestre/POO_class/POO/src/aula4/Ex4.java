package aula4;
import java.util.*;
import help.Help;

public class Ex4 {
    static Scanner sc = new Scanner(System.in);
    public static void main(String args[]){
        int mes = Help.getint("Introduza um mes: ", 0, 12);
        int ano = Help.getint("Introduza um ano: ", 0);
        int dias= Help.getint("Introduza um dia da semana:", 1, 7);

        Help.calendario(dias, mes, ano);
        
    }
}
