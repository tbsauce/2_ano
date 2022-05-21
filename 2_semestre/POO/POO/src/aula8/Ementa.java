package aula8;

public class Ementa {
    
    protected String name;
    protected String local;
    protected Prato [] pratos = new Prato[100];
    protected int size;

    public Ementa(String name, String local){
        setName(name);
        setLocal(local);
        this.size=0;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setLocal(String local){
        this.local = local;
    }

    public String getName(){return this.name;}

    public String getLocal(){return this.local;}

    
    public void addPrato(Prato aux){
        pratos[size++] = aux;
    }

    public int size(){return this.size;}

    @Override
    public String toString(){
        String text = "";
        for (int j = 0; j < size(); j++) {
            text  += pratos[j] + "\n";
        }
        return text;
    }
}
