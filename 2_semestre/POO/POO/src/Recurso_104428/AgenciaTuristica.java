package Recurso_104428;

import java.util.*;

public class AgenciaTuristica {
    
    protected String nome;
    protected String endereco;
    protected Set<PacoteTuristico> pacotes;
    protected List<Reserva> reservas;

    public AgenciaTuristica(String nome , String enderco){
        this.nome = nome;
        this.endereco = enderco;
    }

    public PacoteTuristico pacoteTuristico(String name, int nNights, double price){
        PacoteTuristico novo = new PacoteTuristico(name, nNights, price);
        pacotes.add(novo);
        return novo;
    }

    public void reserva(PacoteTuristico a, int nPessoas){
        reservas.add(new Reserva(a , nPessoas, a.precoTotal(nPessoas)));
    }

    public String listaPacotes(){
        String txt = "Pacotes Turisticos disponívies\n";
        for (PacoteTuristico pacoteTuristico : pacotes) {
            txt += pacoteTuristico;
        }
        return txt;
    }

    public String listaReservas(){
        String txt = "Reservas efetuadas\n";
        for (Reserva reserva : reservas) {
            txt += reserva;
        }
        return txt;
    }

}
