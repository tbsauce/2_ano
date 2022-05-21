package aula8;

public class Carne extends Alimento{
    
    protected String variedade;
    
    public Carne(String variedade, double proteinas, double calorias, double peso){
        super(proteinas, calorias, peso);
        setVariedade(variedade);
    }

    public void setVariedade(String variedade){
        assert validVariedade(variedade) : "Variade not in list";
        this.variedade = variedade;
    }

    public String getVariedade(){return this.variedade;}

    @Override
    public String toString(){
        return String.format("Carne %s,", variedade) +super.toString();
    }

    public boolean validVariedade(String variedade){
        variedade = variedade.toLowerCase();

        String meat [] = {"vaca", "porco", "peru", "frango", "outra"};
        
        for (int i = 0; i < meat.length; i++) {
            if(variedade.equals(meat[i]))
                return true;
        }
        return false;
    }
}
