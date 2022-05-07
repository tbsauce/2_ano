package aula7;

public class DateYMD extends Date{

    private int day;
    private int month;
    private int year;


    //constructur
    public DateYMD(int day, int month, int year){
        this.set(day, month, year);
    }

    //set variables
    @Override
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
    @Override
    public int getday(){
        return this.day;
    }

    //get month
    @Override
    public int getmonth(){
        return this.month;
    }

    //get yeat
    @Override
    public int getyear(){
        return this.year;
    }

    //Increments one day
    @Override
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
    @Override
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
    @Override
    public String toString(){
        return this.year + "-" + this.month + "-" + this.day;
    }
}

