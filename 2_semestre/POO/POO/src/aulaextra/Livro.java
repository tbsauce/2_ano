package aula12;

import java.util.*;

public class Livro extends Produto  {
    private String titulo;
    private Set<Autor> autores= new TreeSet<Autor> () ;
    public Livro(String titulo,double preco){
        super('L',preco);
        this.titulo=titulo;
    }
    public Livro(String titulo,double preco,List<Autor> lista){
        super('L',preco);
        autores = new TreeSet<>(lista);
        this.titulo=titulo;
    }
    public Set<Autor> getLista() {
        return autores;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setLista(Set<Autor> autores) {
        this.autores = autores;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public void add(Autor a)
    {
        autores.add(a);
    }
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "Titulo: "+titulo+"Autores"+autores;
    }
    public double precoVendaAoPublico(){
        return this.getPreco()*0.6+this.getPreco();
    }
    public int numeroAutores()
    {
        return autores.size();
    }

    public String getDescricao(){
        return titulo;
    }
    
    public Set<Autor> autores()
    {
        return autores;
    }


}
