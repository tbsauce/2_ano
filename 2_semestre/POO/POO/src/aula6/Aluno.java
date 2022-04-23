package aula6;
import aula5.Date;

public class Aluno extends Pessoa {
    //... definição de atributos
    static private int count = 99;
    private int nmec;
    private Date iDataInsc;

    public Aluno(String iNome, int iBI, Date iDataNasc, Date iDataInsc){
        super(iNome, iBI, iDataNasc);
        this.iDataInsc = iDataInsc;
        count++;
        this.nmec = count;
    }

    public Aluno(String iNome, int iBI, Date iDataNasc){
        super(iNome, iBI, iDataNasc);
        this.iDataInsc = Date.today();
        count++;
        this.nmec = count;
    }
    // nota: neste caso deve assumir a data atual
    public int getNMec() {         // retorna o número mecanográfico
        return this.nmec;
    }

    // ... acrescentar métodos necessários
    public String getDayInsc(){
        return iDataInsc.toString();
    }

    @Override
    public String toString(){
        return String.format("%s ; Date de Incrição: %s; NMec: %d", super.toString(), getDayInsc(), getNMec());
    }
}
