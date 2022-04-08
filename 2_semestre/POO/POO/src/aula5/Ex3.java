package aula5;
import help.Help;
public class Ex3 {
    public static void main(String args[]){

        //Cicrl
        Circle balls [] = new Circle[20];

        //create balls
        for (int i = 0; i < balls.length; i++) {
            balls[i] = new Circle(Help.randomint(1, 5), Help.randomint(1, 5), Help.randomint(1, 5));
        }

        for (int i = 0; i < balls.length; i++) {
            System.out.println(balls[i]);
        }

        int same = 0;
        for (int i = 1; i < balls.length; i++) {
            if(balls[0].equals(balls[i]))
                same++;
        }

        System.out.println("There are " + same + " Circles equal to the 1st\n");



        //Triangles
        Triangle doritos [] = new Triangle[20];

        //create Doritos
        for (int i = 0; i < balls.length; i++) {
            doritos[i] = new Triangle(Help.randomint(1, 5), Help.randomint(1, 5), Help.randomint(1, 5));;
        }

        for (int i = 0; i < doritos.length; i++) {
            System.out.println("Triangulo -> " + i + doritos[i]);
        }

        same = 0;
        for (int i = 1; i < doritos.length; i++) {
            if(doritos[0].equals(doritos[i]))
                same++;
        }

        System.out.println("There are " + same + " Triangles equal to the 1st\n");


        //Retangle
        Retangle casa [] = new Retangle[20];

        //create casa
        for (int i = 0; i < balls.length; i++) {
            casa[i] = new Retangle(Help.randomint(1, 5), Help.randomint(1, 5));;
        }

        for (int i = 0; i < casa.length; i++) {
            System.out.println("Retangle -> " + i + casa[i]);
        }

        same = 0;
        for (int i = 1; i < casa.length; i++) {
            if(casa[0].equals(casa[i]))
                same++;
        }

        System.out.println("There are " + same + " Retangle equal to the 1st\n");

    }
}
