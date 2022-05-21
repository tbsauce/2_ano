package aula8;

public class Cereal extends Alimento{
    
    protected String name;
    
    public Cereal(String name, double proteinas, double calorias, double peso){
        super(proteinas, calorias, peso);
        setname(name);
    }

    public void setname(String name){
        this.name = name;
    }

    public String getname(){return this.name;}

    @Override
    public String toString(){
        return String.format("Cereal %s,", name) +super.toString();
    }
}
