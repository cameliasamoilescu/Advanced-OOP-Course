package exceptions.ex1;

import jdk.nashorn.internal.runtime.ECMAException;

import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args) {
        int a, b;

        try {
            createFile();
            Scanner scanner = new Scanner(new File("test.txt"));

            a = scanner.nextInt();
            b = scanner.nextInt();

            double result = a / b;
            System.out.println(result);
            scanner.close();
        }catch (IOException | NoSuchElementException | ArithmeticException e) {
            System.out.println(e);

//        }catch (NoSuchElementException e){
//            System.out.println(e);
//            a = 0;
//        }catch (ArithmeticException e){
//            System.out.println(e);
        }
        catch(Exception e){
            System.out.println(e);
        }finally {
            System.out.println("finally");
            b = 0;
        }


    }

    static void createFile() throws IOException {
        File file = new File("test.txt");
        if (file.createNewFile()) {
            System.out.println("file crated");
        }else {
            System.out.println("file already exists");
        }
        throw new IOException("IOException while creating file");
    }
}
