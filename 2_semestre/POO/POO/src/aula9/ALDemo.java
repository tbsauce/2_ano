package aula9;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;
import java.util.Set;
import aula6.Pessoa;
import aula7.Date;
import aula7.DateYMD;

public class ALDemo {
public static void main(String[] args) {
        ArrayList<Integer> c1 = new ArrayList<>();
        for (int i = 10; i <= 100; i+=10)
            c1.add(i);
        System.out.println("Size: " + c1.size());
        for (int i = 0; i < c1.size(); i++)
            System.out.println("Elemento: " + c1.get(i));
        ArrayList<String> c2 = new ArrayList<>();
        c2.add("Vento");
        c2.add("Calor");
        c2.add("Frio");
        c2.add("Chuva");
        System.out.println(c2);
        Collections.sort(c2);
        System.out.println(c2);
        System.out.println(c2.subList(1, 3));
        System.out.println(c2.lastIndexOf("Vento"));
        c2.remove("Frio");
        c2.remove(0);
        System.out.println(c2);
        Set<Pessoa> c3 = new HashSet<>();
        Pessoa p1 = new Pessoa("joana", 0 , new aula5.Date(1,5,2002));
        Pessoa p2 = new Pessoa("juan", 1 , new aula5.Date(4,5,2001));
        Pessoa p3 = new Pessoa("durvs", 2 , new aula5.Date(21,11,2002));
        Pessoa p4 = new Pessoa("ricks", 3 , new aula5.Date(1,5,2011));
        Pessoa p5 = new Pessoa("pedro", 4 , new aula5.Date(2,5,2002));
        Pessoa p6 = new Pessoa("pedro", 4 , new aula5.Date(2,5,2002));
        Pessoa p7 = new Pessoa("durvs", 2 , new aula5.Date(21,11,2002));
        Pessoa p8 = new Pessoa("durvs", 2 , new aula5.Date(21,11,2002));
        c3.add(p1);
        c3.add(p2);
        c3.add(p3);
        c3.add(p4);
        c3.add(p5);
        c3.add(p6);
        c3.add(p7);
        c3.add(p8);
        for (Pessoa pessoa : c3) {
            System.out.println(pessoa);
        }

        Iterator<Pessoa> itr = c3.iterator();
        while (itr.hasNext()) {
            System.out.println("\t" + itr.next());
        }

        Set<Date> c4 = new TreeSet<>();
        Date d1 = new DateYMD(1, 1, 2);
        Date d2 = new DateYMD(2, 2, 211);
        Date d3 = new DateYMD(12, 1, 3332);
        Date d4 = new DateYMD(4, 5, 2002);
        Date d5 = new DateYMD(3, 8, 2002);
        c4.add(d1);
        c4.add(d2);
        c4.add(d3);
        c4.add(d4);
        c4.add(d5);
        for (Date date : c4) {
            System.out.println(date);
        }

        Iterator<Date> ite = c4.iterator();
        while(ite.hasNext())
        {
            System.out.println(ite.next());
        }

    }
}
