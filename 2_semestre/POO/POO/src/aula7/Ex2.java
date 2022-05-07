package aula7;
import help.Help;

public class Ex2 {
    public static void main(String args[]){
        Date data = new DateND(1, 1, 0);
        int op = 1, day, month, year;
        while(true){

            if(op == 1){
                do{
                    day = Help.getint("day:");
                    month =  Help.getint("month:");
                    year = Help.getint("year:");
                    data = new DateND(day, month, year);
                }while(!Date.valid(day, month, year));
            }
            if(op == 2)
                System.out.println(data);
            if(op == 3)
                data.increment();
            if(op == 4)
                data.decrement();
            if(op == 0)
                break;
            
            System.out.print("Date operations:\n"+
            "1 - create new date\n"+
            "2 - show current date\n"+
            "3 - increment date\n"+
            "4 - decrement date\n"+
            "0 - exit\n\n");
            //chooses operation
            op = Help.getint("Choose Operation: ");
        }
    }
}
