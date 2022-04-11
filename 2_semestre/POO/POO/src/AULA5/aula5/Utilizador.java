package aula5;


public class Utilizador {

    private String nome;
    private int nMec;
    private String curso;
    private int borrowed;
    
    Utilizador(String nome , int nMec, String curso){
        this.nome = nome;
        this.nMec = nMec;
        this.curso = curso;
        this.borrowed = 0;
    }

    public void setnMec(int nMec){
        this.nMec = nMec;
    }

    public int getnMec(){
        return this.nMec;
    }

    public String getnome(){
        return this.nome;
    }

    public String getcurso(){
        return this.curso;
    }

    //Borrows a book counting how many the user has goten
    public Boolean borrowing(){
        if(borrowed == 3)
            return true;
        borrowed++;
        return false;
    }

    //gives back a book decresing the number of books borrowed
    public void giveback(){
        borrowed--;
    }

    public String toString(){
        return String.format("Aluno: %d; %s; %s", nMec, nome, curso);
    }
}
