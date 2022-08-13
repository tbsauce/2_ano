package Recurso_104428;

import java.time.LocalDate;

public class Voo extends Servico {
    
    protected Classe tipo;
    protected LocalDate time;
    protected String codigo;

    public Voo(String codigo, LocalDate time, Classe tipo){
        ID = "V" + valor;
        this.codigo = codigo;
        this.time = time;
        this.tipo = tipo;
        valor++;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("Voo %s em %s, classe %s", codigo, time, tipo);
    }

    
}
