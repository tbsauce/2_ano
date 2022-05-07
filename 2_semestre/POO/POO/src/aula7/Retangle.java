package aula7;

public class Retangle extends Forma {

    private int length, height;

    Retangle(int length, int height, String cor){
        super(cor);
        set(length, height);
    }

    public void set(int length, int height){
        assert length > 0 && height > 0: "Medidas Positivas";
        this.length= length;
        this.height = height;
    }

    public int getlength(){
        return this.length;
    }

    public int getheight(){
        return this.height;
    }

    @Override
    public String toString(){
        return String.format("\nThe Triangle as a length -> %d && height -> %d", length, height) + super.toString();
    }

    @Override
    public boolean equals(Object a){
        if(a == null)
            return false;
        if(this.getClass() != a.getClass())
            return false;
        Retangle other = (Retangle) a;
        if (this.height == other.getheight() && this.length == other.getlength() && this.cor.equals(other.cor)) 
            return true;
        return false;
    }

    @Override
    public double area(){
        return length * height;
    }

    @Override
    public double perimetro(){
        return length * 2 + height * 2;
    }

    @Override
    public int hashCode(){
        return this.length* this.height * this.cor.hashCode();
    }
}
