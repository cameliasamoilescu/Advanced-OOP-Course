package primitive_types;

public class Long {
    static long defaultLong;

    public static void main(String[] args) {

        long l1 = 12345;
        long l2 = 12345L; // daca se termina cu l sau L este long daca nu, este int

        System.out.println("l1 " + l1);
        System.out.println("l2 " + l2);


        long l3 = -0b010111010101L;
        System.out.println("l3 " + l3);
    }
}
