package aula12;

public class Documentario extends Produto {
    private String titulo;
    private int ano;
    private int duracao;
    public Documentario(String codigo,double preco,String titulo,int duracao,int ano){
        super('D', preco);
        this.ano=ano;
        this.duracao=duracao;
        this.titulo=titulo;
    }
    public int getAno() {
        return ano;
    }
    public int getDuracao() {
        return duracao;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setAno(int ano) {
        this.ano = ano;
    }
    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public double precoVendaAoPublico(){
        return this.getPreco()*0.23+this.getPreco();
    }
    public String getDescricao() {
        return null;
    }

        
}
