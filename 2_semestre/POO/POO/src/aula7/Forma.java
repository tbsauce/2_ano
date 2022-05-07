package aula7;

public abstract class Forma {
    
    protected String cor;

    Forma(String cor){
        this.cor = cor.toLowerCase();
    }

    public abstract double perimetro();

    public abstract double area();

    public String getCor(){
        return cor;
    }

    public void setCor(String cor){
        this.cor = cor.toLowerCase();
    }

    @Override
    public String toString(){
        return String.format("The color is :%s", cor);
    }


}
