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

    public Date getDayNascDate(){
        return dataNasc;
    }

    @Override 
    public String toString(){
        return String.format("%s; CC: %d; Date de Nascimento: %s", nome, cc, getDayNasc());
    }

    @Override
    public boolean equals(Object obj){
        if(obj == null)
            return false;
        if(getClass() != obj.getClass())
            return false;
        if(obj == this) 
            return true;
        Pessoa other = (Pessoa)obj;
        return this.getName().equals(other.getName()) && this.getcc() == other.getcc() && this.getDayNascDate().equals(other.getDayNascDate());
    }

    @Override
    public int hashCode(){
        return this.getName().hashCode() * this.cc * this.getDayNascDate().hashCode();
    }


}
