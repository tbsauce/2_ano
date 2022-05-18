package aula8;

public class Motociclo extends Viatura{

    protected String type;

    Motociclo(String matricula, String brand, String model, int power, String type){
        super(matricula, brand, model, power);
        setType(type);
    }

    public String getType(){return this.type;}

    public void setType(String type){
        type = type.toLowerCase();
        assert (type.equals("desportivo") || type.equals("estrada")): "Type Must be desportivo ou estrada";
        this.type = type;
    }

    @Override
    public String toString(){
        return super.toString() + String.format("Type - %s;", getType());
    }

    @Override
    public boolean equals(Object other){
        return super.equals(other) && type.equals(((Motociclo)other).getType());
    }

    @Override
    public int hashCode(){
        return super.hashCode() * type.hashCode();
    }

}
