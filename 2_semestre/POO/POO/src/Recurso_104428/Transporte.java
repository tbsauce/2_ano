package Recurso_104428;

public class Transporte extends Servico{
    
    protected int nOcupantes;
    protected int kmMax;
    protected Combustivel tipo;

    public Transporte(int nOcupantes, int kmMax, Combustivel tipo){
        ID = "T" + valor;
        this.nOcupantes = nOcupantes;
        this.kmMax = kmMax;
        this.tipo = tipo;
        valor++;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("Transporte para %d ocupantes, %s, Kms máximos: %d", nOcupantes, tipo, kmMax);
    }
}
