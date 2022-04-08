package aula5;

import help.Help;

public class Calender{

    private int year;
    private int dayweek;

    //cunstructor
    Calender(int year, int dayweek){
        this.year= year;
        this.dayweek = dayweek;
    }   
    
    public int getyear(){
        return this.year;
    }

    public int getdayweek(){
        return this.dayweek;
    }

    public int firstWeekdayOfMonth(int month){
        int first = this.dayweek;
        if(month == 1)
            return first;
        for (int i = 1; i < month; i++) {
            first = ( (Date.monthDays(i, this.year) + first ) % 7 );
        }
        return first;
    }

    public String printMonth(int month){

        String all = "";
        int day = firstWeekdayOfMonth(month);

        //cabecalho
        all +=String.format("\n   %s   %d \n", Help.mestoString(month),year );
        all += "Su Mo Tu We Th Fr Sa\n";

        //print dos espacos
        for (int i = 0; i < day; i++) {
            if(day == 7)
                break;
            all+="   ";
        }

        //para os domingos visto que sao o 1 dia do month
        if(day == 7)
            day = 0;

        //print do calendario
        for (int i = 1, count = day; i <= Date.monthDays(month, year); i++ , count++) {
            if( count == 7){
                all += "\n";
                count =0;
            }

            all += String.format("%2d ", i);
        }
        return all; 
    }

    public String toString(){
        String all = "";
        for (int month = 1; month <= 12; month++) {
            all += printMonth(month);
        }
        return all; 
    }
}
