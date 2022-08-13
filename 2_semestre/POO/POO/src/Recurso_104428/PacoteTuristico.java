package Recurso_104428;

import java.util.*;

public class PacoteTuristico implements IPacoteTuristico {   

    String name;
    int nNights;
    double price;
    Set<Servico> servicos; 

    public PacoteTuristico(String name, int nNights, double price){
        this.name = name;
        this.nNights = nNights;
        this.price = price;
        servicos = new TreeSet<>();
    }

    public PacoteTuristico adicionaServico(Servico servico){
        servicos.add(servico);
        return this;
    }
    public Collection<String> listaServicos(){
        Collection<String> lista = new ArrayList<>();
        
        for (Servico servico : servicos) {
            lista.add(servico.toString()); 
        }

        return lista;
    }

    public int precoTotal(int numPessoas){
        double total = price * numPessoas;
        if(total > 10000)
            total = total * 0.05;
        return (int)total;
    }

    @Override
    public String toString() {
        String txt = String.format("Pacote Turistico %s: %d noites; %f $ / pessoa / noite", name, nNights, price);
        for (Servico servico : servicos) {
           txt += servico; 
        }
        return txt;
    } 

}
