package Statements;


import java.util.Scanner;

public class While {
    public static void main(String[] args) {
        int inputNumber;
        int reverseNumber = 0;

        System.out.println("Input an int number: ");

        Scanner scanner = new Scanner(System.in);

        inputNumber = scanner.nextInt();
        scanner.close();


        while(inputNumber != 0)//condition
        {
            reverseNumber *= 10;
            reverseNumber += (inputNumber % 10);
            inputNumber /= 10;
        }


        System.out.println("Reverse of input number is: " + reverseNumber);

    }
}
