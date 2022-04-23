package aula6;
import aula5.Date;
public class Bolseiro extends Aluno {
    
    private int bolsa;

    public Bolseiro(String bNome, int bBI, Date bDataNasc, Date bDataInsc, int bolsa){
        super(bNome, bBI, bDataNasc, bDataInsc);
        this.bolsa = bolsa;
    }

    public Bolseiro(String bNome, int bBI, Date bDataNasc, int bolsa){
        super(bNome, bBI, bDataNasc);
        this.bolsa = bolsa;
    }

    public int getBolsa(){
        return this.bolsa;
    }

    public void setBolsa(int bolsa){
        this.bolsa = bolsa; 
    }

    @Override
    public String toString(){
        return String.format("%s ; Bolsa: %d", super.toString(), getBolsa());
    }
}
