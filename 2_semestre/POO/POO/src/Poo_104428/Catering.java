package Poo_104428;

public class Catering extends Activity{

    Option modalidade;
    public Catering(Option a, int max_people){
        super(max_people);
        this.price = 30;
        this.modalidade = a;
    }

    public enum Option{
        DRINKS_AND_SNACKS,FULL_MENU
    }
    
    @Override
    public String toString() {
        return String.format("%s for %s", modalidade, super.toString());
    }
}
