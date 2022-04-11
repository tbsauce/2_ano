package aula5;

public class Circle {
    
    private int raio, x, y;

    Circle(int raio, int x, int y){
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

    public String toString(){
        return String.format("The circle as a Radius of %d with a center of(%d, %d)", raio, x, y);
    }

    public boolean equals(Object a){
        if(a == null)
            return false;
        if(this.getClass() != a.getClass())
            return false;
        Circle other = (Circle) a;
        if (this.raio == other.getraio())
            return true;
        return false;
    }

    public double area(){
        return Math.PI * raio * raio;
    }

    public double perimetro(){
        return 2 * Math.PI * raio;
    }
}
