package aula8;

public class PratoDieta extends Prato {
    
    protected double maxCalorias;
    protected double cal;

    public PratoDieta(String name, double maxCalorias){
        super(name);
        setMaxCalorias(maxCalorias);
        this.cal = 0;
    }

    public void setMaxCalorias(double maxCalorias){
        assert maxCalorias > 0 : "Calorias must be positive";
        this.maxCalorias = maxCalorias;
    }

    public double getMaxCalorias(){return this.maxCalorias;}

    public void setcalorias(double cal){
        this.cal = cal;
    }

    public double getCal(){return this.cal;}

    @Override
    public boolean addIngrediente(Alimento aux){
        if(maxCalorias > cal + aux.getcalorias()){
            cal = cal + aux.getcalorias();
            composicao[size++] = aux;
            return true;
        }
        return false;
    }
}
