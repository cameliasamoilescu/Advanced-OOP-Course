package Statements;

import java.util.Scanner;

public class Switch {
    public static void main(String[] args) {
        boolean isVowel = false;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a character: ");


        //
        char inputChar = scanner.next().charAt(0);
        scanner.close();

        switch (inputChar) { // works only with single integer value, enum value or Strin
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
            case 'A':
            case 'E':
            case 'I':
            case 'O':
            case 'U': {
                isVowel = true;
                break; //necessary
            }
            default: {
                System.out.println(inputChar + " surely is not a vowel");
            }
        }


        if(isVowel){
            System.out.println(inputChar + " is a vowel");
        }
        else {
            if ((inputChar >= 'a' && inputChar <= 'z') || (inputChar >= 'A' && inputChar <= 'Z'))
                System.out.println(inputChar + " is a consonant");
            else
                System.out.println("Input is not a letter");
        }
    }

    }

