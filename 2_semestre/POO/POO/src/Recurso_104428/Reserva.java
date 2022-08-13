package Recurso_104428;

public class Reserva {
    
    protected PacoteTuristico pacote;
    protected int nPessoas;
    protected int precoTotal;

    public Reserva(PacoteTuristico pacote,int nPessoas, int precoTotal){
        this.pacote = pacote;
        this.nPessoas = nPessoas;
        this.precoTotal = precoTotal;
    }

    @Override
    public String toString() {
        return String.format("Reserva: %s para %d pessoas. Valor total: %d", pacote, nPessoas, precoTotal);
    }
}
