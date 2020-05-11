package Arrays_class;

import java.util.Arrays;

public class Ex3 {
    public static void main(String[] args) {
        int[] ints = {2, 5, 7, 0, 22, 55, -234, 77};


        Arrays.sort(ints);
        System.out.println(Arrays.toString(ints));

        //binarySearch returneaza -valoarea pozitiei unde ar trebui inserat elementul daca nu il gaseste -1 )
        System.out.println(Arrays.binarySearch(ints, 8));
        System.out.println(Arrays.binarySearch(ints, 5));


    }
}
