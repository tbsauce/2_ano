package aula7;

public class DateND extends Date{

    private int day;
    private int month;
    private int year;

    //base
    private int base_day = 1;
    private int base_month = 1;
    private int base_year = 2000;

    //constructur
    public DateND(int day, int month, int year){
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

    public int days(){
        int days = 0;

        //years after 2000
        if(base_year < this.year){
            //get days year
            for (int i = base_year; i < this.year; i++) {
                if(leapYear(i))
                    days += 366;
                else
                    days += 365;
            }

            //get days month
            for(int i = base_month ; i < this.month ; i++){
                days += monthDays(i, this.year);
            }

            //get days days
            days += this.day - base_day;
        }
        //years before 2000
        else{
            //get days year
            for (int i = base_year-1; i > this.year; i--) {
                if(leapYear(i))
                    days += 366;
                else
                    days += 365;
            }

            //get days month
            for(int i = 12 ; i > this.month ; i--){
                days += monthDays(i, this.year -1);
            }

            //get days days
            days += monthDays(this.month, this.year-1) - this.day +1;
        }
        return days;
    }

    //String 
    @Override
    public String toString(){
        days();
        return String.format("From day %d-%d-%d theres %d days of diference", base_day, base_month, base_year, days());
    }
}

