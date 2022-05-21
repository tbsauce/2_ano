package aula8;

public abstract class Alimento {
    
    protected double proteinas;
    protected double calorias;
    protected double peso;

    public Alimento(double proteinas, double calorias, double peso){
        setproteinas(proteinas);
        setcalorias(calorias);
        this.peso = peso;
    }

    public void setproteinas(double proteinas){
        this.proteinas = proteinas;
    }

    public void setcalorias(double calorias){
        this.calorias = calorias;
    }

    public void setpeso(double peso){
        this.peso = peso;
    }

    public double getproteinas(){return this.proteinas;}

    public double getcalorias(){return this.calorias;}

    public double getpeso(){return this.peso;}

    @Override
    public String toString(){
        return String.format("Proteinas %f, calorias %f, Peso %f", proteinas, calorias, peso);
    }

}
