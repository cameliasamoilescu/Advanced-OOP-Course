package primitive_types;

public class Double {
    static double defaultDouble;

    public static void main(String[] args) {

        double d1 = 555;// int
        System.out.println("d1 " + d1);

        double d2 = 123_456_89_100L;// long -> L
        System.out.println("d2 " + d2);

        double d3 = 123.4f; //float -> f
        System.out.println("d3 " + d3);

        double d4 = 12345.6d; // double -> D sau d
        System.out.println("d4 " + d4);

        double d5 = 123.456e2D; // notatie stiintifica (e2 = * 10^2)
        System.out.println("d5 " + d5);

    }
}
