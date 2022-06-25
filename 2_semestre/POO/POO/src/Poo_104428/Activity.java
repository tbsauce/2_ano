package  Poo_104428;

public abstract class Activity{

    protected int max_people;
    protected double price;

    public Activity(int max_people){
        this.max_people = max_people;
    }

    public double getPrice(){
        return this.price;
    }

    public int getMaxPeople(){
        return this.max_people;
    }

    @Override
    public String toString() {
        return String.format("%d", getMaxPeople());
    }

}
