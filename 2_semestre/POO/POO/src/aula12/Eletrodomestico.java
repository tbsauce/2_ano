package aula12;
public class Eletrodomestico extends Produto {
    protected String tipo_eletrodomestico;
    protected String marca_eletrodomestico;
    protected String modelo_eletrodomestico;
    protected ClasseEnergética energetica_eletrodimestico;
    protected double potencia_eletrodomestico;

    public Eletrodomestico(String tipo,String marca,String modelo,double potencia_eletrodomestico,int preco){
        super('E', preco);
        this.modelo_eletrodomestico=modelo;
        this.marca_eletrodomestico=marca;
        this.potencia_eletrodomestico=potencia_eletrodomestico;
        this.tipo_eletrodomestico=tipo;
    }
    public Eletrodomestico(String tipo,String marca,String modelo,int preco){
        super('E', preco);
        this.modelo_eletrodomestico=modelo;
        this.marca_eletrodomestico=marca;
        this.potencia_eletrodomestico=0;
        this.tipo_eletrodomestico=tipo;
    }
    public double precoVendaAoPublico(){
        return this.getPreco()*0.23+this.getPreco();
    }

    public void setClasse(ClasseEnergética energetica_eletrodimestico) {
        this.energetica_eletrodimestico = energetica_eletrodimestico;
    }
    public void setMarca_eletrodomestico(String marca_eletrodomestico) {
        this.marca_eletrodomestico = marca_eletrodomestico;
    }
    public void setPotencia_eletrodomestico(double potencia_eletrodomestico) {
        this.potencia_eletrodomestico = potencia_eletrodomestico;
    }
    public void setModelo_eletrodomestico(String modelo_eletrodomestico) {
        this.modelo_eletrodomestico = modelo_eletrodomestico;
    }
    public void setTipo_eletrodomestico(String tipo_eletrodomestico) {
        this.tipo_eletrodomestico = tipo_eletrodomestico;
    }

    public ClasseEnergética getClasse() {
        return energetica_eletrodimestico;
    }
    public String getMarca_eletrodomestico() {
        return marca_eletrodomestico;
    }
    public String getModelo_eletrodomestico() {
        return modelo_eletrodomestico;
    }
    public double getPotencia_eletrodomestico() {
        return potencia_eletrodomestico;
    }
    public String getTipo_eletrodomestico() {
        return tipo_eletrodomestico;
    }

    public String getDescricao(){
        return tipo_eletrodomestico+":"+marca_eletrodomestico+"/"+modelo_eletrodomestico;
    }

    @Override
    public String toString() {
        return "Electrodomestico ["+getCodigo()+" "+getTipo_eletrodomestico()+" "+getMarca_eletrodomestico()+" "+getModelo_eletrodomestico()+" "+getClasse()+" "+getPotencia_eletrodomestico()+" W]";
    }
}
