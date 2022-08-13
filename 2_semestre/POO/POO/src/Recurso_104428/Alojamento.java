package Recurso_104428;

public class Alojamento extends Servico{
    
    protected String name;
    protected int nRooms;
    protected int totalCapacity;
    protected Regime tipo;

    public Alojamento(String name , int nRooms, int totalCapacity, Regime tipo){
        ID = "A" + valor;
        this.name = name;
        this.nRooms = nRooms;
        this.totalCapacity = totalCapacity;
        this.tipo = tipo;
        valor++;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("Alojamento %s com %d quartos, ocupação maxima %d pessoas, em regime de %s", name, nRooms, totalCapacity, tipo);
    }

}
