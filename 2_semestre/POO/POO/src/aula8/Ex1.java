package aula8;

import help.Help;

public class Ex1 {
    
    public static void main(String args[]){
    
        Empresa nova = new Empresa("Sauce", "3810-079", "sauce@ua.pt");
        nova.add(new Taxi("aa-11-ds", "fiat", "punto", 10, 1, 2, 1245));
        nova.add(new Pesado_mercadorias("rr-22-ss", "opel", "ubunto", 60, 3, 200, 10000));
        nova.add(new Pesado_passageiros("jq-11-as", "merces", "benze", 50, 7, 20, 5000));
        nova.add(new Motociclo("yi-12-ss", "bmw", "jaguar", 11, "estrada"));
        System.out.println(nova);

        int num = 0;
        do {
            num = Help.getint("Number of the viature");
            if(num != -1)
            nova.get(num).trajeto(Help.getint("Distance"));
        } while (num != -1);
        

        for (int i = 0; i < nova.size(); i++) {
            System.out.println(nova.get(i).distanciaTotal());
        }
        
    }
}
