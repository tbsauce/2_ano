package aula8;

public class Pesado_de_passageiros_elétrico extends Pesado_passageiros implements VeiculoEletrico {
    
    protected int autonomia;

    public Pesado_de_passageiros_elétrico(String matricula, String brand, String model, int power, int num_quadro, int max_people, int Weight, int autonomia){
        super(matricula, brand, model, power, num_quadro, max_people, Weight);
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
