package Poo_104428;

public class Client implements Comparable<Client>{
    
    protected String name;
    protected String localidade;

    public Client(String name , String localidade){
        this.name = name;
        this.localidade = localidade;
    }

    public String getName(){
        return this.name;
    }

    public String getLocalidade(){
        return this.localidade;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setlocalidade(String localiade){
        this.localidade = localiade;
    }

    @Override 
    public int compareTo(Client m) {
        return name.compareToIgnoreCase(m.getName()) + localidade.compareToIgnoreCase(m.getLocalidade());
    }

    @Override
    public String toString() {
        return String.format("%s [%s]", name, localidade);
    }

}
