package help;

import java.util.*;

////////////////////////////////
//  class to Help le Francois //
////////////////////////////////
public class Help {
    static Scanner sc = new Scanner(System.in);

    //get int num
    public static int getint(String text){
        int i;
        while(true){
            try{
                System.out.print(text);
                i = sc.nextInt();
                break;
            }
            catch(InputMismatchException e){
                System.out.print("Input Inválido.\n");
                sc.nextLine();
            }
        }   
        return i;
    }

    //get int num with range
    public static int getint(String text, int min , int max){
        int i;
        while(true){
            try{
                System.out.print(text);
                i = sc.nextInt();
                if(i<min ||i> max)
                    throw new InputMismatchException();
                break;
            }
            catch(InputMismatchException e){
                System.out.print("Input Inválido.\n");
                sc.nextLine();
            }
        }
        return i;
    }

    //Get int with min
    public static int getint(String text, int min){
        int i;
        while(true){
            try{
                System.out.print(text);
                i = sc.nextInt();
                if(i<min)
                    throw new InputMismatchException();
                break;
            }
            catch(InputMismatchException e){
                System.out.print("Input Inválido.\n");
                sc.nextLine();
            }
        }
        return i;
    }

    //get int with max
    public static int getintmax(String text, int max){
        int i;
        while(true){
            try{
                System.out.print(text);
                i = sc.nextInt();
                if(i> max)
                    throw new InputMismatchException();
                break;
            }
            catch(InputMismatchException e){
                System.out.print("Input Inválido.\n");
                sc.nextLine();
            }
        }
        return i;
    }

    //Get double num
    public static double getdouble(String text){
        double i;
        while(true){
            try{
                System.out.print(text);
                i = sc.nextDouble();
                break;
            }
            catch(InputMismatchException e){
                System.out.print("Input Inválido.\n");
                sc.nextLine();
            }
        }
        return i;
    }

    //Get double with range
    public static double getdouble(String text, double min , double max){
        double i;
        while(true){
            try{
                System.out.print(text);
                i = sc.nextDouble();
                if(i<min ||i> max)
                    throw new InputMismatchException();
                break;
            }
            catch(InputMismatchException e){
                System.out.print("Input Inválido.\n");
                sc.nextLine();
            }
        }
        return i;
    }

    //Get double with min
    public static double getdouble(String text, double min){
        double i;
        while(true){
            try{
                System.out.print(text);
                i = sc.nextDouble();
                if(i<min)
                    throw new InputMismatchException();
                break;
            }
            catch(InputMismatchException e){
                System.out.print("Input Inválido.\n");
                sc.nextLine();
            }
        }
        return i;
    }

    //get double with max
    public static double getdoublemax(String text, double max){
        double i;
        while(true){
            try{
                System.out.print(text);
                i = sc.nextDouble();
                if(i> max)
                    throw new InputMismatchException();
                break;
            }
            catch(InputMismatchException e){
                System.out.print("Input Inválido.\n");
                sc.nextLine();
            }
        }
        return i;
    }

    //Read string
    public static String getString (String text){
        System.out.print(text);
        return sc.nextLine();
    }

    //Read string with min characters
    public static String getString (String text, int min){
        String i;
        while(true){
            try{
                System.out.print(text);
                i = sc.nextLine();
                if(i.length() < min)
                    throw new InputMismatchException();
                break;
            }
            catch(InputMismatchException e){
                System.out.print("Input Inválido.\n");
                sc.nextLine();
            }
        }
        return i;
    }


    //creates a random num double
    public static double randomdouble(double min, double max){
        return (Math.random() * (max-min)) + min;
    }

    //creates a random num int
    public static int randomint(int min, int max){
        return (int)(Math.random() * (max-min) + min);
    }

    //counts number os digits
    public static int countdig(String text){
        return text.replaceAll("[\\D]", "").length();
    }

    //count number of sapaces
    public static int countspaces(String text){ 
        return text.replaceAll("[\\S]", "").length();
    }

    //evaluates if is lower case
    public static boolean islowercase(String text){
        return text.equals(text.toLowerCase());
    }

    //evaluates if is Upper case
    public static boolean isuppercase(String text){
        return text.equals(text.toUpperCase());
    }

    //textes with more than 1 space in a row makes it 1
    public static String fewerspaces(String text){
        return text.replaceAll("[\\s]+", " ");
    }

    // see if it is palimoro
    public static Boolean ispalíndromo(String text){
        for (int i = 0; i < (text.length()/2); i++) {
            if(text.charAt(i) !=  text.charAt((text.length()-1) - i))
                return false;
        }
        return true;
    }

    //meta acronimo
    public static String acronimo(String text){
        String [] sep = text.split("\\s");
        String ac="";
        for (int i = 0; i < sep.length; i++) {
            if(sep[i].length() >= 3){
                ac += sep[i].charAt(0);
            }
        }
        return ac.toUpperCase();
    }


    //getdiasdosmes
    public static int getdias(int mes, int ano){
        int [] dias = {31,28,31,30,31,30,31,31,30,31,30,31};

        if(isbissexto(ano) && mes == 2)
            return dias[mes -1] + 1;
        else
            return dias[mes -1];
    }

    //getmesstring
    public static String mestoString(int mes){
        String [] mesesstring = {"Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};
        return mesesstring[mes-1];
    }

    //É bissexto bissexto
    public static Boolean isbissexto(int ano){
        if( (ano % 400 == 0) || ( (ano % 4 == 0) && (ano % 100 != 0) ) )
            return true;
        return false;
    }

    //Print de um calendario
    public static void calendario(int dias, int mes, int ano){
        //cabecalho
        System.out.printf("   %s   %d \n", mestoString(mes),ano );
        System.out.print("Su Mo Tu We Th Fr Sa\n");

        //print dos espacos
        for (int i = 0; i < dias; i++) {
            if(dias == 7)
                break;
            System.out.print("   ");
        }

        //para os domingos visto que sao o 1 dia do mes
        if(dias == 7)
            dias = 0;

        //print do calendario
        for (int i = 1, count = dias; i <= getdias(mes, ano); i++ , count++) {
            if( count == 7){
                System.out.print("\n");
                count =0;
            }

            System.out.printf("%2d ", i);
        } 
    }

}
