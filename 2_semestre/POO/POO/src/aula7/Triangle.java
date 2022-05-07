package aula7;

public class Triangle extends Forma{
    
    private int lado1, lado2, lado3;

    Triangle(int lado1, int lado2, int lado3, String cor){
        super(cor);
        set(lado1, lado2, lado3);
    }

    public void set(int lado1, int lado2, int lado3){
        assert lado1 > 0 && lado2 > 0 && lado3 > 0: "Medidas Positivas";
        this.lado1= lado1;
        this.lado2 = lado2;
        this.lado3 = lado3;
    }

    public int getlado1(){
        return this.lado1;
    }

    public int getlado2(){
        return this.lado2;
    }

    public int getlado3(){
        return this.lado3;
    }

    @Override
    public String toString(){
        return String.format("\nThe Triangle as a lado1 -> %d && lado2 -> %d && lado3 -> %d", lado1, lado2, lado3)+ super.toString();
    }

    @Override
    public boolean equals(Object a){
        if(a == null)
            return false;
        if(this.getClass() != a.getClass())
            return false;
        Triangle other = (Triangle) a;
        if (this.lado1 == other.getlado1() && this.lado2 == other.getlado2() && this.lado3 == other.getlado3() && this.cor.equals(other.cor)) 
            return true;
        return false;
    }

    @Override
    public double area(){
        double p = perimetro();
        return Math.sqrt(p *(p -lado1)*(p-lado2)*(p-lado3));
    }

    @Override
    public double perimetro(){
        return lado1 + lado2 + lado3;
    }

    @Override
    public int hashCode(){
        return this.lado1 * this.lado2 * this.lado3 * this.cor.hashCode();
    }
}
