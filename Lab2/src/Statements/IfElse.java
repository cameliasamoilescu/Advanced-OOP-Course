package Statements;

import java.util.Scanner;

public class IfElse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number: ");

        int number = scanner.nextInt();
        scanner.close();


        if(number > 0){
            System.out.println(number + " is positive");
        }
        else if(number < 0){
            System.out.println(number + " is negative");
        }
        else {
            System.out.println(number + " is neither positive nor negative");
        }
    }
}
