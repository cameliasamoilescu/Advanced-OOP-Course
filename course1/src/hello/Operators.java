package hello;

public class Operators {

    public static void main(String[] args) {

        int x = 10, y = 20, z = 30;

        boolean a = (x < z) && (x == x);// short circuiting evaluation
        boolean b = (x < z) && (x == z);

        /*
        && will stop evaluating if the first operand is false, but & won't
        || will stop evaluating if the first operand is true, but | won't
         */

        System.out.println("(x < z) && (x == x)" + a);
        System.out.println("(x < z) && (x == z)" + b);

        System.out.println(" ");
        boolean a1 = (x < z) & (x == x);
        boolean b1 = (x < z) & (x == z);

        System.out.println("(x < z) & (x == x)" + a1);
        System.out.println("(x < z) & (x == z)" + b1);

        boolean b2 = true;
        boolean b3 = false;

        boolean b4 = b2 || (b3 = 'A' == 65); // short circuiting OR(||)

        System.out.println("b4 " + b4);
        System.out.println("b3 " + b3);

        int num;
        num = b3 ? 1 : 0; // If, else

        System.out.println("num " + num);


        b2 = args instanceof Object; // instanceof operator;

        /*
        instanceof Object will return TRUE for all non-null object references,
         ince all java objects are inherited from Object class/

         instanceof will always return FALSE is object reference is null.

         */
        System.out.println("b2 " + b2);

        b3 = null instanceof Object;// null nu este o instabta
        System.out.println("b3 " + b3);

    }



}
