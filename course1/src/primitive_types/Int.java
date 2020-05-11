package primitive_types;

public class Int {
    static int defaultInt;

    public static void main(String[] args) {
        int i1 = 12_34_567_8;
        System.out.println("i1 " + i1);

        int i2 = 0b0101_0_101_0101; // binar
        System.out.println("i2 " + i2);


        int i3 = 0_167, i4 = 0x57_FAE;
        System.out.println("i3 " + i3);
        System.out.println("i4 " + i4);


        System.out.println("default " + defaultInt);
    }
}
