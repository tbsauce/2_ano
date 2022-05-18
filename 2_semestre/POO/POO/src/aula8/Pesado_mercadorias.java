package aula8;

public class Pesado_mercadorias extends Viatura{
 
    protected int num_quadro;
    protected int Weight;
    protected int max_capacity;

    Pesado_mercadorias(String matricula, String brand, String model, int power, int num_quadro, int max_capacity, int Weight){
        super(matricula, brand, model, power);
        setNum_Quadro(num_quadro);
        setMaxCapacity(max_capacity);
        setWeight(Weight);
    }

    public int getNum_Quadro(){return num_quadro;}

    public int getMaxCapcity(){return this.max_capacity;}

    public int getWeight(){return this.Weight;}

    public void setNum_Quadro(int num_quadro){
        assert num_quadro > 0 : "Numero de Quadro must be positive";
        this.num_quadro = num_quadro;
    }

    public void setMaxCapacity(int max_capacity){
        assert max_capacity > 0 : "The Max Capacity must be positive.";
        this.max_capacity = max_capacity;
    }

    public void setWeight(int Weight){
    assert max_capacity > 0 : "The Weight must be positive.";
        this.Weight = Weight;
    }

    @Override
    public String toString(){
        return super.toString() + String.format("Weight - %d; Max Capacity - %d; Numero de Quadro - %d;", getWeight(), getMaxCapcity(), getNum_Quadro());
    }

    @Override
    public boolean equals(Object other){
        return super.equals(other) && Weight == ((Pesado_mercadorias)other).getWeight()
        && max_capacity == ((Pesado_mercadorias)other).getMaxCapcity() && num_quadro == ((Pesado_mercadorias)other).getNum_Quadro();
    }

    @Override
    public int hashCode(){
        return super.hashCode() * num_quadro * Weight * max_capacity;
    }
}
