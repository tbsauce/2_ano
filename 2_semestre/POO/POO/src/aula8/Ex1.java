package aula8;

import help.Help;

public class Ex1 {
    
    public static void main(String args[]){
    
        Empresa nova = new Empresa("Sauce", "3810-079", "sauce@ua.pt");
        nova.add(new Taxi("aa-11-ds", "fiat", "punto", 10, 1, 2, 1245));
        nova.add(new Pesado_mercadorias("rr-22-ss", "opel", "ubunto", 60, 3, 200, 10000));
        nova.add(new Pesado_passageiros("jq-11-as", "merces", "benze", 50, 7, 20, 5000));
        nova.add(new Motociclo("yi-12-ss", "bmw", "jaguar", 110, "estrada"));
        nova.add(new Pesado_de_passageiros_elétrico("jq-11-as", "merces", "benze", 50, 7, 20, 5000, 50));
        nova.add(new Automóvel_ligeiro_elétrico("aa-22-aa", "Range Rover", "x7", 70, 8, 80, 90));
        
        nova.orderPower();
        System.out.println(nova);

        int num = 0;
        do {
            num = Help.getint("Number of the viature");
            if(num >= 0)
                nova.get(num).trajeto(Help.getint("Distance"));
        } while (num >= 0);

        int car = 0;
        for (int i = 0; i < nova.size(); i++) {
            if(nova.get(car).distanciaTotal() < nova.get(i).distanciaTotal()){
                car = i;
            }
        }

        System.out.println(((Pesado_de_passageiros_elétrico) nova.get(4)).autonomia());
        ((Pesado_de_passageiros_elétrico) nova.get(4)).carregar(100);
        //((Pesado_de_passageiros_elétrico) nova.get(4)).carregar(5); // Gona catch an assert
        System.out.println(((Pesado_de_passageiros_elétrico) nova.get(4)).autonomia());

        System.out.printf("The car with the most kilometres is %s %s with maticula %s, that has %d km\n",nova.get(car).getBrand(), nova.get(car).getModel(), nova.get(car).getMatricula(), nova.get(car).distanciaTotal());
        System.out.printf("The car %s %s with maticula %s, did %d km\n",nova.get(car).getBrand(), nova.get(car).getModel(), nova.get(car).getMatricula(), nova.get(car).ultimoTrajeto());
        
    }
}
