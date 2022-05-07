package aula7;
import help.Help;

public class Ex1 {
    public static void main(String args[]){

        String cores [] = {"red", "blue", "green", "orange", "black"};
        int size = 1000;
        //Cicrl
        Circle balls [] = new Circle[size];

        //create balls
        for (int i = 0; i < balls.length; i++) {
            balls[i] = new Circle(Help.randomint(1, 10), Help.randomint(1, 10), Help.randomint(1, 10), cores[Help.randomint(0, 4)]);
        }

        // for (int i = 0; i < balls.length; i++) {
        //     System.out.println(balls[i]);
        // }

        int same = 0;
        for (int i = 1; i < balls.length; i++) {
            if(balls[0].equals(balls[i]))
                same++;
        }

        int same1 = 0;
        for (int i = 1; i < balls.length; i++) {
            if(balls[0].hashCode() == balls[i].hashCode())
                same1++;
        }

        System.out.println("There are " + same + " Circles equal to the 1st and with the same hashcode "+ same1 + "\n");


        //Triangles
        Triangle doritos [] = new Triangle[size];

        //create Doritos
        for (int i = 0; i < doritos.length; i++) {
            do{
                doritos[i] = new Triangle(Help.randomint(1, 10), Help.randomint(1, 10), Help.randomint(1, 10),cores[Help.randomint(0, 4)]);
            }while(doritos[i].getlado1() == doritos[i].getlado2() || doritos[i].getlado2() == doritos[i].getlado3() || doritos[i].getlado1() == doritos[i].getlado3());
        }

        // for (int i = 0; i < doritos.length; i++) {
        //     System.out.println("Triangulo -> " + i + doritos[i]);
        // }

        same = 0;
        for (int i = 1; i < doritos.length; i++) {
            if(doritos[0].equals(doritos[i]))
                same++;
        }

        same1 = 0;
        for (int i = 1; i < doritos.length; i++) {
            if(doritos[0].hashCode() == doritos[i].hashCode())
                same1++;
        }

        System.out.println("There are " + same + " Triangles equal to the 1st and with the same hashcode "+ same1 + "\n");


        //Retangle
        Retangle casa [] = new Retangle[size];

        //create casa
        for (int i = 0; i < balls.length; i++) {
            casa[i] = new Retangle(Help.randomint(1, 10), Help.randomint(1, 10), cores[Help.randomint(0, 4)]);;
        }

        // for (int i = 0; i < casa.length; i++) {
        //     System.out.println("Retangle -> " + i + casa[i]);
        // }

        same = 0;
        for (int i = 1; i < casa.length; i++) {
            if(casa[0].equals(casa[i]))
                same++;
        }

        same1 = 0;
        for (int i = 1; i < doritos.length; i++) {
            if(casa[0].hashCode() == casa[i].hashCode())
                same1++;
        }

        System.out.println("There are " + same + " Retangle equal to the 1st and with the same hashcode "+ same1 + "\n");

    }
}
