package aula5;

import java.time.LocalDate;

public class Date {

    private int day;
    private int month;
    private int year;


    //constructur
    public Date(int day, int month, int year){
        this.set(day, month, year);
    }

    //set variables
    public void set(int day, int month, int year){
        //assert valid(day, month, year) : "Data inválida!";
        if(valid(day, month, year)){
            this.day = day;
            this.month= month;
            this.year = year;
        }
        else{
            System.out.println("Data Inválida!");
        }
    }

    //get day
    public int getday(){
        return this.day;
    }

    //get month
    public int getmonth(){
        return this.month;
    }

    //get yeat
    public int getyear(){
        return this.year;
    }

    //Increments one day
    public void increment(){
        if(day < monthDays(month, year)){
            day++;
        }
        else{
            day = 1;
            if(month == 12){
                month = 1;
                year++;
            }
            else{
                month++;
            }
        }

    }

    //decrements one day
    public void decrement(){

        if(day == 1){
            if(month == 1){
                month = 12;
                year--;
            }
            else
                month --;
            day = monthDays(month, year);
        }
        else
            day--;

        if(!valid(day, month, year)){
            System.out.println("Can't Decrement more!");
            increment();
        }

    }

    //String 
    public String toString(){
        return year + "-" + month + "-" + day;
    }

    //satic Stuff
    //Valids the Month
    public static boolean validMonth(int month){
        if(month <= 12 && month > 0)
            return true;
        return false;
    }

    //É bissexto bissexto
    public static Boolean leapYear(int year){
        if( (year % 400 == 0) || ( (year % 4 == 0) && (year % 100 != 0) ) )
            return true;
        return false;
    }

    //Get fays of the month
    public static int monthDays(int month, int year){
        int [] days = {31,28,31,30,31,30,31,31,30,31,30,31};

        if(leapYear(year) && month == 2)
            return days[month -1] + 1;
        else
            return days[month -1];
    }

    //valids date
    public static boolean valid(int day, int month, int year){
        if(day < 1 || !validMonth(month) || year < 0 || monthDays(month, year) < day)
            return false;
        return true;
    }

    public static Date today(){
        LocalDate today = LocalDate.now();
        int day = today.getDayOfMonth();
        int mes = today.getMonthValue();
        int ano = today.getYear();
        return new Date(day, mes, ano);
    }

    @Override
    public boolean equals(Object obj){
        if(obj == null)
            return false;
        if(getClass() != obj.getClass())
            return false;
        if(obj == this) 
            return true;
        Date other = (Date)obj;
        return this.day == other.day && this.month == other.month && this.year == other.year;
    }

    @Override
    public int hashCode(){
        return this.day *  this.month * this.year;
    }
}

