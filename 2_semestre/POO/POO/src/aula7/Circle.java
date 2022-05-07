package aula7;

public class Circle extends Forma{
    
    private int raio, x, y;

    Circle(int raio, int x, int y, String cor){
        super(cor);
        set(raio, x, y);
    }

    public void set(int raio, int x, int y){
        assert raio > 0 : "Impossibel Radius";
        this.raio = raio;
        this.x = x;
        this.y = y;
    }

    public int getraio(){
        return this.raio;
    }

    public int getx(){
        return this.x;
    }

    public int gety(){
        return this.y;
    }

    @Override
    public String toString(){
        return String.format("The circle as a Radius of %d with a center of(%d, %d)", raio, x, y) + super.toString();
    }

    @Override
    public boolean equals(Object a){
        if(a == null)
            return false;
        if(this.getClass() != a.getClass())
            return false;
        Circle other = (Circle) a;
        if (this.raio == other.getraio() && this.cor.equals(other.cor))
            return true;
        return false;
    }

    @Override
    public double area(){
        return Math.PI * raio * raio;
    }

    @Override
    public double perimetro(){
        return 2 * Math.PI * raio;
    }

    @Override
    public int hashCode(){
        return this.raio * this.x * this.y * this.cor.hashCode();
    }
}
