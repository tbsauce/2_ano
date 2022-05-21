package aula8;

public class Prato {
    
    protected String name;
    protected Alimento [] composicao = new Alimento[100];
    protected int size;

    public Prato(String name){
        setName(name);
        this.size =0;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){return this.name;}

    public boolean addIngrediente(Alimento aux){
        composicao[size++] = aux;
        return true;
    }

    @Override
    public String toString(){
        return String.format("Prato %s, composto por %d Ingredientes", name, size);
    }

}
