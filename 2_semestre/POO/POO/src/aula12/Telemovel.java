package aula12;
import java.util.*;

public class Telemovel extends Produto {
    String marca;
    String modelo;
    Set<String> notas_telemovel = new TreeSet<>();
    public Telemovel(String marca,String modelo,double preco){
        super('T',preco);
        this.marca=marca;
        this.modelo=modelo;
    }
    public double precoVendaAoPublico(){
        return this.getPreco()*0.23+this.getPreco();
    }

    public String getMarca() {
        return marca;
    }
    public String getModelo() {
        return modelo;
    }
    public Set<String> getNotas_telemovel() {
        return notas_telemovel;
    }
    
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public void setNotas_telemovel(Set<String> notas_telemovel) {
        this.notas_telemovel = notas_telemovel;
    }

    public void addNotas(String s)
    {
        notas_telemovel.add(s);
    }

    public String getDescricao(){
        return marca+"/"+modelo;
    }

    public void addNota(String s)
    {
        notas_telemovel.add(s);
    }

    @Override
    public String toString() {
        return "Telemovel ["+getCodigo()+" "+getMarca()+" - "+getModelo()+" "+getDescricao()+" ]";
    }
}