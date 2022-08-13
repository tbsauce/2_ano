package aula12;
public class Autor implements Comparable<Autor> {
    private String nome;
    private int ano;
    public Autor(String nome,int ano){
        this.ano=ano;
        this.nome=nome;
    }
    @Override
    public String toString() {
        return nome+" ( "+ano+"-), ";
    }
    public int getAno() {
        return ano;
    }
    public String getNome() {
        return nome;
    }
    @Override
    public int compareTo(Autor  o) {
        return nome.compareToIgnoreCase(o.getNome());
    }
}
