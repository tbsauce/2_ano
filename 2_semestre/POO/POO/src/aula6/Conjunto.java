package aula6;


public class Conjunto {
    
    private int [] vector;
    
    Conjunto(){
        vector = new int[0];
    }

    void insert(int num){
        if(!contains(num)){
            int [] aux = this.vector;
            int size = 1 + this.size();
            this.vector = new int[size];
            this.vector[size - 1] = num;
            for (int i = 0; i < aux.length; i++) {
                this.vector[i] = aux[i];
            }
        }
    }


    boolean contains(int num){
        for (int i = 0; i < this.size(); i++) {
            if(num == this.getpos(i))
                return true;
        }
        return false;
    }

    void remove(int num){
        boolean sub = false;
        if(contains(num)){
            int [] aux = this.vector;
            for (int i = 0; i < this.size() -1; i++) {
                if(num == this.vector[i])
                    sub = true;
                if(sub)
                    aux[i]= this.vector[ i+1 ];
            }

            this.vector = new int[this.size() -1];
            for (int i = 0; i < this.size(); i++) {
                this.vector[i] = aux[i];
            }
           
        }
    }

    void empty(){
        this.vector = new int[0];
    }

    @Override
    public String toString(){
        String text = "";
        for (int i = 0; i < vector.length; i++) {
            text += this.vector[i] + "; ";
        }
        return text;
    }

    int size(){
        return (this.vector).length;
    }

    Conjunto combine(Conjunto add){
        Conjunto aux = this;
        for (int i = 0; i < add.size(); i++) {
            aux.insert(add.getpos(i));
        }
        return aux;
    }

    Conjunto subtract(Conjunto dif){
        Conjunto aux = this;
        for (int i = 0; i < dif.size(); i++) {
            aux.remove(dif.getpos(i));
        }
        return aux;
    }

    Conjunto intersect(Conjunto inter){
        Conjunto aux = new Conjunto();
        for (int i = 0; i < inter.size(); i++) {
            if (contains(inter.getpos(i))) {
                aux.insert(inter.getpos(i));
            }
        }
        return aux;
    }

    int getpos(int i){
        return this.vector[i];
    }
}
