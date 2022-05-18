package aula8;

public class Pesado_passageiros extends Viatura {

    protected int num_quadro;
    protected int Weight;
    protected int max_people;

    Pesado_passageiros(String matricula, String brand, String model, int power, int num_quadro, int max_people, int Weight){
        super(matricula, brand, model, power);
        setNum_Quadro(num_quadro);
        setMaxpeople(max_people);
        setWeight(Weight);
    }

    public int getNum_Quadro(){return num_quadro;}

    public int getMaxPeople(){return this.max_people;}

    public int getWeight(){return this.Weight;}

    public void setNum_Quadro(int num_quadro){
        assert num_quadro > 0 : "Numero de Quadro must be positive";
        this.num_quadro = num_quadro;
    }

    public void setMaxpeople(int max_people){
        assert max_people > 0 : "The Max people must be positive.";
        this.max_people = max_people;
    }

    public void setWeight(int Weight){
    assert Weight > 0 : "The Weight must be positive.";
        this.Weight = Weight;
    }
    

    @Override
    public String toString(){
        return super.toString() + String.format("Weight - %d; Max People - %d; Numero de Quadro - %d;", getWeight(), getMaxPeople(), getNum_Quadro());
    }

    @Override
    public boolean equals(Object other){
        return super.equals(other) && Weight == ((Pesado_passageiros)other).getWeight()
        && max_people == ((Pesado_passageiros)other).getMaxPeople() && num_quadro == ((Pesado_mercadorias)other).getNum_Quadro();
    }

    @Override
    public int hashCode(){
        return super.hashCode() * num_quadro * Weight * max_people;
    }
}
