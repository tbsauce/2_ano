package Poo_104428;

import java.util.*;
import java.time.LocalDate;

public class Event implements IEvent {
    
    protected LocalDate date;
    protected List<Activity> activitys;

    public Event(LocalDate date){
        this.date = date;
        activitys = new ArrayList<>();
    }

    public Event addActivity(Activity activity){
        activitys.add(activity);
        return this;
    }

    public LocalDate getDate(){
        return this.date;
    }

    public double eventPrice(){
        double totalPrice=0;
        for (Activity activity : activitys) {
            totalPrice += activity.getPrice();
        }
        return totalPrice;
    }

    @Override
    public String toString() {
        String s ="";
        s+= String.format("*** Evento em %s, total=%f euros,\n", date, eventPrice());
        for (Activity activity : activitys) {
            s+= activity +"\n";
        }
        return s;
    }
}
