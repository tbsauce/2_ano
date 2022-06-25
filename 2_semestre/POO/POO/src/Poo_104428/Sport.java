package Poo_104428;

public class Sport extends Activity {
    
    Modality modalidade;
    public Sport(Modality a, int max_people){
        super(max_people);
        this.price = 20;
        this.modalidade = a;
    }

    
    public enum Modality{
        HIKING,KAYAK
    }

    @Override
    public String toString() {
        return String.format("%s for %s", modalidade, super.toString());
    }

}
