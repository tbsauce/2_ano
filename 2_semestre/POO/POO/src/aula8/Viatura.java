package aula8;


public abstract class Viatura implements KmPercorridosInterface{
    
    protected String matricula;
    protected String brand;
    protected String model;
    protected int power;

    //distancia
    protected int distanciaTotal = 0;
    protected int trajeto = 0;
    protected int ultimoTrajeto;
    
    Viatura(String matricula, String brand, String model, int power){
        setBrand(brand);
        setMatricula(matricula);
        setModel(model);
        setPower(power);
    }

    //get set
    public String getMatricula(){return this.matricula;}

    public String getBrand(){return this.brand;}

    public String getModel(){return this.model;}

    public int getPower(){return this.power;}

    public void setMatricula(String matricula){
    assert validMatricula(matricula) : "Matricula must be AA-00-AA";
        this.matricula = matricula;
    }

    public void setBrand(String brand){
        this.brand = brand;
    }

    public void setModel(String model){
        this.model = model;
    }

    public void setPower(int power){
    assert power > 0 : "Power must be positive";
        this.power = power;
    }

    //Trajeto
    public void trajeto(int quilometros){
    assert quilometros > 0 : "km must be positive";
        trajeto = quilometros;
        distanciaTotal += trajeto;
    }

    public int ultimoTrajeto(){
        return trajeto;
    }

    public int distanciaTotal(){
        return distanciaTotal;
    }

    public boolean validMatricula(String matricula){
        if(matricula.length() == 8){
            if(Character.isLetter(matricula.charAt(0)) && Character.isLetter(matricula.charAt(1)) &&
               Character.isDigit(matricula.charAt(3))  && Character.isDigit(matricula.charAt(4))  &&
               Character.isLetter(matricula.charAt(6)) && Character.isLetter(matricula.charAt(7)))
               return true;
        }
        return false;
    }

    @Override
    public String toString(){
        return String.format("Brand - %s;Model - %s;Matricula - %s;Power - %d;", getBrand(), getModel(), getMatricula(), getPower());
    }

    @Override
    public boolean equals(Object obj){
        if(obj == null)
            return false;
        if(getClass() != obj.getClass())
            return false;
        if(obj == this) 
            return true;
            Viatura other = (Viatura)obj;
        return this.matricula.equals(other.getMatricula()) && this.brand.equals(other.getBrand()) &&
               this.model.equals(other.getModel()) && this.power == other.getPower();
    }

    @Override
    public int hashCode(){
        return matricula.hashCode()*brand.hashCode()*model.hashCode()*power;
    }
}
