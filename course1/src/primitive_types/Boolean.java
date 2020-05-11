package primitive_types;

public class Boolean {
    static boolean defaultBoolean;

    public static void main(String[] args) {
        boolean v1 = false;
        System.out.println("v1 " + v1);

        boolean v2 = true;
        System.out.println("v2 " + v2);


        boolean v3 = 'D' == 68;
        System.out.println("v3 " + v3);


        boolean v4 = 'D' == 65;
        System.out.println("v4 " + v4);

        // default variable is false
        System.out.println("default " + defaultBoolean);


    }
}
