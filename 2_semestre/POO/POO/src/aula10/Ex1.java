package aula10;

import java.util.*;

public class Ex1 {
    public static void main(String [] args){
        HashMap <String, String> list = new HashMap<>();

        list.put("Branco", "Que tem a cor da neve.");
        list.put("Laranja", "Que tem o msm nome da Laranja");
        list.put("Preto", "Que tem a cor do escuro");
        list.put("Azul", "Que tem a cor do ceu");
        list.put("Verde", "Que tem a cor da relva");

        list.replace("Branco", "Que e a cor das nuvens");

        list.remove("Laranja");

        System.out.println(list);

        // for (HashMap.Entry<String, String> aux : list.entrySet()) {
        //     System.out.println(aux.getKey());
        // }

        for (String i : list.keySet()) {
            System.out.println(i);
        }

        // for (HashMap.Entry<String, String> aux : list.entrySet()) {
        //     System.out.println(aux.getValue());
        // }

        for (String i : list.values()) {
            System.out.println(i);
        }

    }
}