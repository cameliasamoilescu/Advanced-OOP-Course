package Arrays_class;

import java.util.Arrays;

public class Ex1 {
    public static void main(String[] args) {
        int[][] ints = new int[2][];

        ints[0] = new int[]{3, 5, 6};
        ints[1] = new int[]{1, 4, 7, 8, 9};


        //CLONE
        int[][] copyArray = ints.clone();


        System.out.println("Arrays.equals: " + Arrays.equals(ints, copyArray));
        System.out.println("Arrays.deepEquals: " + Arrays.deepEquals(ints, copyArray));
        System.out.println();


        /** System.out.println(Arrays.toString(ints));
         afiseaza referinte deci folosim metoda deepToString
         */


        System.out.println(Arrays.deepToString(ints));
        System.out.println();
        System.out.println("Arrays.hashCode: " + Arrays.hashCode(ints));
        System.out.println("Arrays.deepHashCode: " + Arrays.deepHashCode(ints));
        System.out.println();

        short[] shortArray = new short[5];

        //FILL
        Arrays.fill(shortArray, (short) 10);
        System.out.println(Arrays.toString(shortArray));





    }

}
