package ex1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws FileNotFoundException, IOException{

        Calculator c = new CalculatorNou();

        File file = new File("src/Ex1/test.txt");
        Scanner scanner = new Scanner(file);

        double a, b;
        a = scanner.nextDouble();
        b = scanner.nextDouble();

        try{
            double sum = c.add(a,b);
            System.out.println(sum);
        }
        catch (Exception e){
            System.out.println(e);
        }

        a = scanner.nextDouble();
        b = scanner.nextDouble();

        try{
            double div = c.divide(a,b);
            System.out.println(div);
        }
        catch (Exception e){
            System.out.println(e);
        }


        try{

            int n = scanner.nextInt();

            Double[] vector = new Double[n];

            for(int i = 0; i < n; i ++){
                vector[i] = scanner.nextDouble();
            }

            System.out.println(c.average(vector));

        }
        catch (Exception e){
            System.out.println(e);
        }




        a = Double.POSITIVE_INFINITY;
        b = 3.0;
        try{
            double sum = c.add(a,b);
            System.out.println(sum);
        }
        catch (Exception e){
            System.out.println(e);
        }

        a = Double.NEGATIVE_INFINITY;
        b = -3.0;
        try{
            double sum = c.add(a,b);
            System.out.println(sum);
        }
        catch (Exception e){
            System.out.println(e);
        }

        a = 3.0;
        b = 0.0;
        try{
            double div = c.divide(a,b);
            System.out.println(div);
        }
        catch (Exception e){
            System.out.println(e);
        }


        try{
            double sum = c.add(a, null);
            System.out.println(sum);
        }
        catch (Exception e){
            System.out.println(e);
        }

        scanner.close();
    }


}
