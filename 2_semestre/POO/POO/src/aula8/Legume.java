package aula8;

public class Legume extends Alimento{
    
    protected String name;
    
    public Legume(String name, double proteinas, double calorias, double peso){
        super(proteinas, calorias, peso);
        setname(name);
    }

    public void setname(String name){
        this.name = name;
    }

    public String getname(){return this.name;}

    @Override
    public String toString(){
        return String.format("Legume %s,", name) +super.toString();
    }
}
