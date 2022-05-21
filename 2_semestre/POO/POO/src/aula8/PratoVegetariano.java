package aula8;


public class PratoVegetariano extends Prato{

    public PratoVegetariano(String name){
        super(name);
    }

    @Override
    public boolean addIngrediente(Alimento aux){
        if(aux instanceof Legume|| aux instanceof Cereal){
            composicao[size++] = aux;
            return true;
        }
        return false;
    }
    
}
