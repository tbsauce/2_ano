package aula8;

public class Prato {
    
    protected String name;
    protected Alimento [] composicao = new Alimento[100];
    protected int size;

    public Prato(String name){
        setName(name);
        this.size =0;
    }

    public int size(){return this.size;}
    public void setName(String name){
        this.name = name;
    }

    public String getName(){return this.name;}

    public boolean addIngrediente(Alimento aux){
        composicao[size++] = aux;
        return true;
    }

    public double getPesoTotal(){
        double total=0;
        for (int i = 0; i < composicao.length; i++) {
            total += composicao[i].getpeso(); 
        }
        return total;
    }

    public double getProteinasTotal(){
        double total=0;
        for (int i = 0; i < composicao.length; i++) {
            total += composicao[i].getproteinas(); 
        }
        return total;
    }

    public double getCaloriasTotal(){
        double total=0;
        for (int i = 0; i < composicao.length; i++) {
            total += composicao[i].getcalorias(); 
        }
        return total;
    }

    public String getAlimentos(){
        String text="";
        for (int i = 0; i < size(); i++) {
            text += composicao[i] + "->";
        }
        return text;
    }

    @Override
    public String toString(){
        return String.format("Prato %s, composto por %d Ingredientes", name, size);
    }

}
