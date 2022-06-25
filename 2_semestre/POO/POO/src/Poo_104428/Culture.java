package Poo_104428;

public class Culture extends Activity{
    
    Option modalidade;
    
    public Culture(Option a, int max_people){
        super(max_people);
        this.price = 25;
        this.modalidade = a;
    }


    public enum Option{
        ART_MUSEUM,WINE_TASTING,RIVER_TOUR,ARCHITECTURAL_TOUR
    }

    @Override
    public String toString() {
        return String.format("%s for %s", modalidade, super.toString());
    }
}
