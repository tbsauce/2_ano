package aula6;
import aula5.Date;

public class Pessoa {
    private String nome;
    private int cc;
    private Date dataNasc;

    public Pessoa(String nome, int cc, Date dataNasc){
        assert cc >0;
        this.nome = nome;
        this.cc = cc;
        this.dataNasc = dataNasc;
    }

    public String getName(){
        return this.nome;
    }

    public int getcc(){
        return this.cc;
    }

    public String getDayNasc(){
        return dataNasc.toString();
    }

    @Override 
    public String toString(){
        return String.format("%s; CC: %d; Date de Nascimento: %s", nome, cc, getDayNasc());
    }


}
