package aula8;

public class Automóvel_ligeiro_elétrico extends Automóvel_ligeiro implements VeiculoEletrico {
    
    protected int autonomia;

    public Automóvel_ligeiro_elétrico(String matricula, String brand, String model, int power, int num_quadro, int capacity, int autonomia){
        super(matricula, brand, model, power, num_quadro, capacity);
        assert 0 <= autonomia && autonomia <= 100: "autonomia is greater than 100 or lower that 0 it cant be";
        this.autonomia = autonomia;
    }

    @Override
    public int autonomia(){
        return autonomia;
    }

    @Override
    public void carregar(int percentagem){
        assert percentagem < autonomia : "It needs to charge not the oposite";
        this.autonomia = percentagem;
    }
}
