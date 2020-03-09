package Statements;

import java.util.Scanner;

public class For {
    public static void main(String[] args) {
        int inputNumber;
        int reverseNumber = 0;

        System.out.println("Enter an int: ");

        Scanner scanner = new Scanner(System.in);
        inputNumber = scanner.nextInt();
        scanner.close();



        for(; inputNumber != 0;){
            reverseNumber *= 10;
            reverseNumber += inputNumber%10;
            inputNumber /= 10;
        }


        System.out.println("reverse of the input number: " + reverseNumber);
    }


}
