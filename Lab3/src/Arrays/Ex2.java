package Arrays;

import java.util.Arrays;

public class Ex2 {

    public static void main(String[] args) {
        char[] chars = {'a', 'b', 'c', 'd'};
        // chars.length => 4

        for (char c : chars){
            System.out.println(c);
        }


        System.out.println(new String(chars));


        byte[] bytes = new byte[]{0, 2, 4, -128};

        System.out.println(bytes);
        System.out.println(Arrays.toString(bytes)); // toString este o metoda a clasei Arrays


        int[] intArray = {};// lungimea vectorului este 0 si nu poate fi schimbata dupa creare

       /* intArray[0] = 0;
        System.out.println(intArray[0]); => EROARE
        */
    }
}
