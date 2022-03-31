package aula3;
import java.util.*;

import help.Help;
public class Ex7 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String args []){
        int rand = Help.randomint(0, 100), count = 0 , num;
        while(true){
            while(true){
                String text = String.format("Try %d: ", count);
                num = Help.getint(text, 1 , 100);

                if(num == rand ){
                    System.out.print("Congrats you won!!");
                    break;
                }
                if(num < rand )
                    System.out.print("Try higher\n");
                if(num > rand )
                    System.out.print("Try Lower\n");

                count++;
            }
            System.out.print("Wanna Keep going? Sim(S)/ Nao(N)");
            String resp = sc.next();
            resp = resp.toLowerCase();

            if("s"!= resp ||"sim"!= resp)
                break;

        }


    }
}

