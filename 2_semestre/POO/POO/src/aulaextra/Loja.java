package aula12;
import java.util.*;
public class Loja  {
    protected String nome;
    protected String EnderecoWeb;
    protected Set <Produto> produtos= new TreeSet<>();
    public Loja(String nome,String EnderecoWeb)
    {
        this.EnderecoWeb=EnderecoWeb;
        this.nome=nome;
    }
    
    public void setEnderecoWeb(String EnderecoWeb) {
        this.EnderecoWeb = EnderecoWeb;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getEnderecoWeb() {
        return EnderecoWeb;
    }
    public String getNome() {
        return nome;
    }
    
    public void add(Produto p)
    {
        produtos.add(p);
    }

    public  int totalItems()
    {
        int quantidade=0;
        for (Produto produto : produtos) {
            quantidade+=produto.getStock();
        }
        return quantidade;
    }

    public Produto getProdutoPelaDescricao(String s)
    {
        for (Produto produto : produtos) {
            if(produto.getDescricao().equals(s))
            {
                return produto;
            }
        }
        return null;
    }

    public void reorder()
    {
        Set <Produto>temp= new TreeSet<>( Produto::compare );
        temp.addAll(produtos);
        produtos=temp;
    }

    @Override
    public String toString() {
        String s="";
        for (Produto produto : produtos) {
            s+= produto.getCodigo()+ " "+produto.getDescricao()+"   "+produto.getStock()+" "+produto.precoVendaAoPublico()+"/n";
        }
        return s;
    }
}
