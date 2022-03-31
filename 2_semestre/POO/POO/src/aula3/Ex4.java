package aula3;
import java.util.*;

public class Ex4 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int nums[] = new int [10];
        int i=0;
        int max, min;
        double media;
        //read
        while(true){
            try{
                System.out.print("Introduza um Numero:");
                nums[i] = sc.nextInt();
                if(nums[0]==nums[i] && i !=0)
                    break;
                i++;
                
            }
            catch(InputMismatchException e){
                System.out.print("Input Inválido.\n");
                sc.nextLine();
            }
        }
        max = nums[i];
        min = nums[i];
        media = 0;
        for(int j = i ; j>= 0; j--){
            media += nums[j];
            if(nums[j]>max)
                max = nums[j];
            else if(nums[j]<min)
                min = nums[j];
        }
        media= media /(i+1);
        System.out.printf("media:%.2f\n max:%d\n min:%d", media, max, min);
        sc.close();
    }
}