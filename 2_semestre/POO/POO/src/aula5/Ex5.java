package aula5;
import help.Help;
import java.util.*;

public class Ex5 {
    static Scanner sc = new Scanner(System.in);
    public static void main(String args[]){
        Utilizador alunos [] = new Utilizador[100];
        Livro livros [] = new Livro[100];
        int op = 1;

        while(true){
            System.out.println(
            "\n1 - inscrever utilizador\n"+
            "2 - remover utilizador\n"+
            "3 - imprimir lista de utilizadores\n"+
            "4 - registar um novo livro\n"+
            "5 - imprimir lista de livros\n"+
            "6 - emprestar\n"+
            "7 - devolver\n"+
            "8 - sair\n");
            //chooses operation
            op = Help.getint("Choose Operation: ", 1, 8);

        
            if(op == 1){
                String nome = Help.getString("Aluno: ");
                int nMec =  Help.getint("nMec:", 0);
                //creates a acronimo 
                String curso = Help.getString("Curso: ");
                if(Help.countspaces(curso)>0)
                    curso = Help.acronimo(curso);

                for (int i = 0; i < alunos.length; i++) {
                    if(alunos[i]==null){
                        alunos[i] = new Utilizador(nome , nMec , curso );
                        break;
                    }
                }
            }
            if(op == 2){
                int tmpnMec = Help.getint("nMec to be removed: ", 0);
                boolean change = false;
                for (int i = 0; i < alunos.length; i++) {
                    if(alunos[i]==null)
                        break;
                    //find aluno with nmec
                    if(tmpnMec == alunos[i].getnMec()){
                        alunos[i]=null;
                        //change = true so it changes array positions
                        change = true;
                    }
                    //if change == true every postion goes one babck
                    if(change)
                        alunos[i] = alunos [i+1];
                }
            }
            if(op == 3){
                //prints every alino
                for (int i = 0; i < alunos.length; i++) {
                    if(alunos[i] != null){
                        System.out.print(alunos[i]);
                        System.out.println();
                    }
                }
            }
            if(op == 4){
                //new book
                String book = Help.getString("Titulo: ");
                for (int i = 0; i < livros.length; i++){
                    if(livros[i]==null){
                        livros[i] = new Livro(book);
                        break;
                    }
                    //cant put existeing books
                    if(book.equals(livros[i].getTitulo())){
                        System.out.print("This was already registered.");
                        break;
                    }
                }
            }
            if(op == 5)
                //prints every book
                for (int i = 0; i < livros.length; i++) {
                    if(livros[i] != null){
                        System.out.print(livros[i]);
                        System.out.println();
                    }
                }
            if(op == 6){
                int aluno_tmp = -1;
                boolean existbook = false;
                boolean existaluno = false;
                //gets book to be borrowed and student and validates inputs
                int tmpid = Help.getint("Id of book: ", 100);
                int tmpnMec = Help.getint("nMec of student: ", 0);
                for (int i = 0; i < 100; i++) {
                    if(alunos[i] == null && livros[i] == null)
                        break;
                    if(livros[i]!=null && livros[i].getId() == tmpid ){
                        existbook = true;
                    }
                    if( alunos[i]!=null && alunos[i].getnMec() == tmpnMec){
                        existaluno = true;
                        aluno_tmp = i;
                    }
                }

                //if student invalid or book invalid doesnt borrow
                if(existaluno && existbook){
                    for (int i = 0; i < livros.length; i++) {
                        if(livros[i]==null){
                            break;
                        }
                        //checks if its alread y borroewd and borrows if not
                        if( tmpid == livros[i].getId()){
                            if(livros[i].getTipoEmprestimo() != "CONDICIONAL"){
                                if(!alunos[aluno_tmp].borrowing())
                                    livros[i].setTipoEmprestimo("CONDICIONAL");
                                else    
                                    System.out.print("Can't borrow more than 3 books\n");
                            }
                            else
                                System.out.print("Book Already Borrowed\n");
                        }
                    }
                }
                else{
                    if(!existaluno && existbook)
                        System.out.print("student not valid");
                    else if(!existbook && existaluno)
                        System.out.print("Book not valid\n");
                    else
                        System.out.print("Both inputs invalid\n");
                }
        
            }
            if(op == 7){
                boolean existbook = false;
                boolean existaluno = false;
                //gets book to be borrowed and student and validates inputs
                int tmpid = Help.getint("Id of book: ", 100);
                int tmpnMec = Help.getint("nMec of student: ", 0);
                for (int i = 0; i < 100; i++) {
                    if(alunos[i] == null && livros[i] == null)
                        break;
                    if( livros[i]!=null && livros[i].getId() == tmpid){
                        existbook = true;
                    }
                    if( alunos[i]!=null && alunos[i].getnMec() == tmpnMec){
                        existaluno = true;
                    }
                }
                //if student invalid or book invalid doesnt borrow
                if(existaluno && existbook){
                    for (int i = 0; i < livros.length; i++) {
                        if(livros[i]==null){
                            break;
                        }
                        //checks if its alreafy borroewd and borrows if not
                        if( tmpid == livros[i].getId()){
                            if(livros[i].getTipoEmprestimo() != "NORMAL")
                                livros[i].setTipoEmprestimo("NORMAL");
                            else
                                System.out.print("The book was already in the library\n");
                        }
                    }
                }
                else{
                    if(!existaluno && existbook)
                        System.out.print("student not valid");
                    else if(!existbook && existaluno)
                        System.out.print("Book not valid\n");
                    else
                        System.out.print("Both inputs invalid\n");
                }
        
            }
            if(op == 8){         
                break;
            }
            
        }
    }
}
