package aula8;


public class Automóvel_ligeiro extends Viatura{
    
    protected int num_quadro;
    //capacidade da lagadeira
    protected int capacity;

    Automóvel_ligeiro(String matricula, String brand, String model, int power, int num_quadro, int capacity){
        super(matricula, brand, model, power);
        setNum_Quadro(num_quadro);
        setCapacity(capacity);
    }

    public int getNum_Quadro(){return num_quadro;}

    public int getCapcity(){return this.capacity;}

    public void setNum_Quadro(int num_quadro){
        assert num_quadro > 0 : "Numero de Quadro must be positive";
        this.num_quadro = num_quadro;
    }

    public void setCapacity(int capacity){
        assert capacity > 0 : "Trunk Capacity must be positive.";
        this.capacity = capacity;
    }

    @Override
    public String toString(){
        return super.toString() + String.format("Numero de Quadro - %s;Capacity - %s", getNum_Quadro(), getCapcity());
    }

    @Override
    public boolean equals(Object other){
        return super.equals(other) && num_quadro == ((Automóvel_ligeiro)other).getNum_Quadro() && capacity == ((Automóvel_ligeiro)other).getCapcity();
    }

    @Override
    public int hashCode(){
        return super.hashCode() * capacity * num_quadro;
    }
    
}
