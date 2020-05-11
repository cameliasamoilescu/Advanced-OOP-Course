package hello;

import java.util.Scanner;

public class ScannerDemo {

    public static void main(String[] args) {
        /*
        // A simple text scanner which can parse
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name: ");

        // Here we actually read keyboard input

        String myName = scanner.nextLine();

        // Close the resource !!

        scanner.close();

        // Display the input to console

        System.out.println("My name is: " + myName);

        */

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");

        int number = scanner.nextInt();

        scanner.close();

        if (number > 0){
            System.out.println(number + " is positive");

        }
        else if (number < 0){
            System.out.println(number + " is negative");
        }

    }
}
