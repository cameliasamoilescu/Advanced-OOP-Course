package hashset;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        HashS h1 = new HashS();

        h1.add(1);
        System.out.println(h1);
        System.out.println(h1.getNr_adaugate());
        h1.addAll(Arrays.asList(1,5,3,4,5));

        System.out.println(h1.getNr_adaugate());
        System.out.println(h1);

//        Metoda addAll apeleaza metoda add

        System.out.println("---------LinkedList--------");
        LinkedL l1 = new LinkedL();

        l1.add(1);
        System.out.println(l1);
        System.out.println(l1.getNr_adaugate());
        l1.addAll(Arrays.asList(1,5,3,4,5));

        System.out.println(l1.getNr_adaugate());
        System.out.println(l1);


//        Metoda addAll nu apeleaza metoda add
    }
}
