package aula5;


public class Utilizador {

    private String nome;
    private int nMec;
    private String curso;
    private int borroewd;
    
    Utilizador(String nome , int nMec, String curso){
        this.nome = nome;
        this.nMec = nMec;
        this.curso = curso;
        this.borroewd = 0;
    }

    public void setnMec(int nMec){
        this.nMec = nMec;
    }

    public int getnMec(){
        return this.nMec;
    }

    public Boolean borrowing(){
        if(borroewd == 3)
            return true;
        borroewd++;
        return false;
    }

    public void giveback(){
        borroewd--;
    }



    public String toString(){
        return String.format("Aluno: %d; %s; %s", nMec, nome, curso);
    }
}
