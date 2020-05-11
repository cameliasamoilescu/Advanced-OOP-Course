package Arrays_class;

import java.util.Arrays;

public class Ex2 {
    public static void main(String[] args) {
        int[] ints = {2, 3, 4, 5};
        int[] intCopy;

        //CLONE
        intCopy = ints.clone();
        System.out.println(Arrays.toString(intCopy));
        System.out.println();

        int[] anotherCopy = new int[5];

        //ARRAYCOPY
        System.arraycopy(ints, 0, anotherCopy, 0, 3);
        System.out.println(Arrays.toString(anotherCopy));
        System.out.println();


        //COPYOF
        int[] anotherCopy1 = Arrays.copyOf(ints, 2);
        System.out.println(Arrays.toString(anotherCopy1));


        int[] ints1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        System.out.println(Arrays.toString(Arrays.copyOfRange(ints1, 0, 10))); //[0,9] sau [0, 10)
        System.out.println(Arrays.toString(Arrays.copyOfRange(ints1, 4, 4)));

        // System.out.println(Arrays.toString(Arrays.copyOfRange(ints1, 4, 3))); indexul de inc <= indexul de sf


    }

}
