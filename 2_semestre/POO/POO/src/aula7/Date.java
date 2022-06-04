package aula7;

import java.time.LocalDate;

public abstract class Date implements Comparable<Date>{

    protected int day;
    protected int month;
    protected int year;

    //set variables
    public abstract void set(int day, int month, int year);

    //get day
    public abstract int getday();

    //get month
    public abstract int getmonth();

    //get yeat
    public abstract int getyear();

    //Increments one day
    public abstract void increment();

    //decrements one day
    public abstract void decrement();

    //String
    @Override
    public String toString(){
        return getyear() + "-" + getmonth() + "-" + getday();
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

    //Get fays of the month
    public static int YearDays(int year){
        if(leapYear(year))
            return 366;
        return 365;
    }

    //valids date
    public static boolean valid(int day, int month, int year){
        if(day < 1 || !validMonth(month) || year < 0 || monthDays(month, year) < day)
            return false;
        return true;
    }

    public static DateYMD today(){
        LocalDate today = LocalDate.now();
        int day = today.getDayOfMonth();
        int mes = today.getMonthValue();
        int ano = today.getYear();
        return new DateYMD(day, mes, ano);
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

    
    @Override
    public int compareTo(Date o){
        if(getday() == o.getday())
            return 0;
        if(getday() > o.getday())
            return -1;
        else 
            return 1;
    }
}

