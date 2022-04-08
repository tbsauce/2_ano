package aula5;

public class Retangle {

    private int length, height;
    Retangle(int length, int height){
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

    public String toString(){
        return String.format("\nThe Triangle as a length -> %d && height -> %d \n", length, height);
    }

    public boolean equals(Object a){
        if(a == null)
            return false;
        if(this.getClass() != a.getClass())
            return false;
        Retangle other = (Retangle) a;
        if (this.height == other.getheight() && this.length == other.getlength()) 
            return true;
        return false;
    }

    public double area(){
        return length * height;
    }

    public double perimetro(){
        return length * 2 + height * 2;
    }
}
