package aula10;

import java.util.*;

public class Ex2 {
    public static void main(String [] args){
        TreeMap <String, ArrayList<String>> list = new TreeMap<>();

        ArrayList <String> a1 = new ArrayList<>();
        a1.add("Que tem cor da neve");
        a1.add("Que tem cor das nuvens");
        list.put("Branco", a1);

        ArrayList <String> a2 = new ArrayList<>();
        a2.add("Que tem cor da Laranja");
        a2.add("Que tem o msm nome da Laranja");
        list.put("Laranja", a2);

        ArrayList <String> a3 = new ArrayList<>();
        a3.add("Que tem a cor do escuro");
        a3.add("Que tem a cor dos Corvos");
        list.put("Preto", a3);

        ArrayList <String> a4 = new ArrayList<>();
        a4.add("Que tem a cor do ceu");
        a4.add("Que tem a cor do Mar");
        list.put("Azul", a4);
    
        ArrayList <String> a5 = new ArrayList<>();
        a5.add("Que tem a cor da relva");
        a5.add("Que tem a cor da erva");
        list.put("Azul", a5);
        
        a1.clear();
        a1.add("Que tem cor da baunilha");
        a1.add("Que tem cor da Paz");


        list.replace("Branco", a1);

        list.remove("Laranja");

        System.out.println(list);

        for (String i: list.keySet()) {
            System.out.println(i);
        }

        for ( ArrayList<String> i: list.values()) {
            System.out.println(i);
        }

    }
}