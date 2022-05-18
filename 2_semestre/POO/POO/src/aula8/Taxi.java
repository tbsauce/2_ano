package aula8;

public class Taxi extends Automóvel_ligeiro{
    
    protected int license;

    Taxi(String matricula, String brand, String model, int power, int num_quadro, int capacity, int license){
        super(matricula, brand, model, power, num_quadro, capacity);
        setLicense(license);
    }

    public int getlicense(){return this.license;}

    public void setLicense(int license){
        assert license >=0 : "license number must be positive";
        this.license = license;
    }

    @Override
    public String toString(){
        return super.toString() + String.format("License - %d", getlicense());
    }

    @Override
    public boolean equals(Object other){
        return super.equals(other) && license == ((Taxi)other).getlicense();
    }

    @Override
    public int hashCode(){
        return super.hashCode() * license;
    }
}
