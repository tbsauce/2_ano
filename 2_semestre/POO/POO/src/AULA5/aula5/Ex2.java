package aula5;
import help.Help;

public class Ex2 {

    public static void main (String args[]){
        Calender cal = new Calender(0, 1);
        int op = 1, dayweek = 0, year = 0;

        while(true){

            if(op == 1){
                dayweek = Help.getint("day of the week:", 1, 7);
                year = Help.getint("year:", 0);
                cal = new Calender(year, dayweek);
            }
            if(op == 2)
                System.out.print(cal.printMonth(Help.getint("Escolha um mes:", 1, 12)));
            if(op == 3)
                System.out.print(cal);
            if(op == 0)
                break;
            
            System.out.print("\n\nCalendar operations:\n"+
            "1 - create new calendar\n"+
            "2 - print calendar month\n"+
            "3 - print calendar\n"+
            "0 - exit\n\n");
            //chooses operation
            op = Help.getint("Choose Operation: ");
        }
    }
    
}
