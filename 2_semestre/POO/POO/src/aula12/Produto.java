package aula12;

public abstract class Produto implements PVP, Comparable<Produto>{
    protected static int serie =0;
    protected String codigo;
    protected int quantidade;
    protected double preco;

    public Produto(Character start,double preco){
        this.preco=preco;
        serie+=2;
        this.codigo=start+ String.valueOf(serie) ;
        this.quantidade=0;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }
    public void setStock(int quantidade) {
        this.quantidade = quantidade;
    }
    public String getCodigo() {
        return codigo;
    }
    public double getPreco() {
        return preco;
    }
    public int getStock() {
        return quantidade;
    }
    public abstract double  precoVendaAoPublico();
    public void addStock(int k)
    {
        setStock(getStock()+k);
    }
    public abstract String getDescricao();
    public boolean vender(int q)
    {
        if (getStock()>q)
        {
            this.setStock(this.getStock()-q);
            return true;
        }
        else
        {return false;}
    }

    @Override
    public int compareTo(Produto o) {

        return getCodigo().compareTo(o.getCodigo());
    }

    public int compare(Produto o)
    {
        return getDescricao().compareTo(o.getDescricao());
    }
}

