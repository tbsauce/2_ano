package Poo_104428;

import java.util.*;
import java.time.LocalDate;

public class EventManager{

    protected String name;
    Map<Client, List<Event> > events;

    public EventManager(String name){
        this.name = name;
        events= new TreeMap<>(); 
    }

    public String getName(){
        return this.name;
    }

    public Client addClient(String name , String localidade){
        Client c = new Client(name, localidade);
        events.put(c, null);
        return c;
    }

    public Event addEvent(Client c, LocalDate date){
        for (Event a : events.get(c)) {
            if(a.getDate().equals(date))
                return null;
        }
        Event e = new Event(date);
        (events.get(c)).add(e);
        return e;
    }

    public String listClients(){
        String txt = "";
        for (Client i: events.keySet()) {
            txt+= i;
        }
        return txt;
    }

    public List<Event> listEvents(){    
        for ( List<Event> i: events.values()) {
            return i;
        }
        return null;
    }

    

   

}
