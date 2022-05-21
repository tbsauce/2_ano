package aula8;

public class Peixe extends Alimento{
    
    protected String tipo;
    
    public Peixe(String tipo, double proteinas, double calorias, double peso){
        super(proteinas, calorias, peso);
        setTipo(tipo);
    }

    public void setTipo(String tipo){
        assert validTipo(tipo): "Type must be Congelado or Fresco";
        this.tipo = tipo;
    }

    public String getTipo(){return this.tipo;}

    @Override
    public String toString(){
        return String.format("Peixe %s,", tipo) +super.toString();
    }

    public boolean validTipo(String tipo){
        tipo = tipo.toLowerCase();

        String state [] = {"congelado", "fresco"};
        
        for (int i = 0; i < state.length; i++) {
            if(tipo.equals(state[i]))
                return true;
        }
        return false;
    }
}

