package aula8;

public class Empresa {
    
    private String name;
    private String codigo_postal;
    private String email;
    private Viatura [] stock = new Viatura[100];
    private int size;

    Empresa(String name, String codigo_postal, String email){
        setName(name);
        setEmail(email);
        setCodigo_Postal(codigo_postal);
        this.size = 0;
    }

    public String getName(){return this.name;}

    public String getCodigo_Postal(){return this.codigo_postal;}

    public String getEmail(){return this.email;}

    public int size(){return this.size;}

    public void setName(String name){
        this.name = name;
    }

    public void setCodigo_Postal(String codigo_postal){
    assert validCodigo_Postal(codigo_postal) : "Codigo Postal must be 0000-000";
        this.codigo_postal = codigo_postal;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public boolean validCodigo_Postal(String codigo_postal){
        if(codigo_postal.length() == 8){
            if(Character.isDigit(codigo_postal.charAt(0)) && Character.isDigit(codigo_postal.charAt(1)) &&
               Character.isDigit(codigo_postal.charAt(2)) && Character.isDigit(codigo_postal.charAt(3)) &&
               Character.isDigit(codigo_postal.charAt(5)) && Character.isDigit(codigo_postal.charAt(6)) &&
               Character.isDigit(codigo_postal.charAt(7)))
               return true;
        }
        return false;
    }

    public void full(){
        Viatura [] aux = stock;
        stock = new Viatura[size*5];
        for (int i = 0; i < aux.length; i++) {
            stock[i]= aux[i];
        }
    }

    public void add(Viatura a){
        if(size++ == stock.length)
            full();
        stock[size-1] = a;
    
    }

    public Viatura get(int index){
    assert index >= 0 && index < size: "it must be less than size";
        return stock[index];
    }

    @Override
    public String toString(){
        String text = String.format("Name : %s; Codigo Postal: %s; Email: %s\n", getName(), getCodigo_Postal(), getEmail());
        for (int i = 0; i < size; i++) {
           text += stock[i] + "\n";
        }
        return text;
    }

    @Override
    public boolean equals(Object obj){
        if(obj == null)
            return false;
        if(getClass() != obj.getClass())
            return false;
        if(obj == this) 
            return true;
            Empresa other = (Empresa)obj;
        return this.name.equals(other.getName()) && this.codigo_postal.equals(other.getCodigo_Postal()) &&
               this.email.equals(other.getEmail());
    }

    @Override
    public int hashCode(){
        return name.hashCode() * codigo_postal.hashCode() * email.hashCode();
    }

    public void orderPower(){
        boolean done = false;
        while(!done){
            done = true;
            Viatura tmp;
            for (int i = 0; i < size()-1; i++) {
                if(stock[i].getPower() < stock[i+1].getPower()){
                    tmp = stock[i];
                    stock[i] = stock[i+1];
                    stock[i+1] = tmp;
                    done = false;
                }
            }
        }
    }
}
   