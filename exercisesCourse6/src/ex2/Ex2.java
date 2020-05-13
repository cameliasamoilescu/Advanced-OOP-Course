package ex2;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Vector;

public class Ex2 {
    public static void main(String[] args) {

        Vector<Integer> vector1 = new Vector<Integer>();
        Vector<Double> vector2 = new Vector<Double>();



        try {
            createFile();
            Scanner scanner = new Scanner(new File("src/Ex2/test.txt"));

            while(scanner.hasNext()){
                if(scanner.hasNextInt()){
                    int i = scanner.nextInt();
                    System.out.println(i);
                    vector1.add(i);
                }
                else{
                    double d = scanner.nextDouble();
                    System.out.println(d);
                    vector2.add(d);

                }
            }

            Collections.sort(vector1);
            Collections.sort(vector2);

            System.out.println(vector1);
            System.out.println(vector2);

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("fisierul nu exista ");
        } catch (IOException e) {
            System.out.println("nu s-a putut deschide fisierul");
        } catch (NoSuchElementException e) {
            System.out.println("fisierul nu contine elemente");
        }
    }

    static void createFile() throws IOException {
        File file = new File("test.txt");
        if (file.createNewFile()) {
            System.out.println("fisier creat");
        } else {
            System.out.println("fisierul exista deja");
        }
    }
}
