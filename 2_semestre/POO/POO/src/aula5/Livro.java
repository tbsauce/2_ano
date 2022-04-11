package aula5;

public class Livro {

    private int id;
    private String titulo;
    private String tipoEmprestimo;
    private static int count = 100;

    Livro(String titulo){
        this.id = count;
        this.titulo = titulo;
        this.tipoEmprestimo = "NORMAL";
        count++;
    }

    Livro(String titulo, String tipoEmprestimo){
        this.id = count;
        this.titulo = titulo;
        this.tipoEmprestimo = tipoEmprestimo;
        count++;
    }

    public int getId(){
        return this.id;
    }

    public String getTitulo(){
        return this.titulo;
    }

    public String getTipoEmprestimo(){
        return this.tipoEmprestimo;
    }

    public void setTipoEmprestimo(String  tipoEmprestimo){
        this.tipoEmprestimo = tipoEmprestimo;
    }

    public String toString(){
        return String.format("Livro %d; %s; %s", id, titulo, tipoEmprestimo);
    }
}
