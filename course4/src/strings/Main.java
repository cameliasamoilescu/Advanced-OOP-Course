package strings;

public class Main {
    static String membruClasa;
    public static void main(String[] args) {

        System.out.println(membruClasa);

        String s1 = "";
        String s = " "; //isBlank()

        String s2 = "abc"; // string pool
        System.out.println(s2);// abc

        s2.toUpperCase(); // imutabilitate, valoarea referentiata de s2 nu se modifica
        System.out.println(s2);// abc

        //s2 = s2.toUpperCase();
        //System.out.println(s2);//ABC

        String s3 = new String("abc"); // alocare de memorie pe heap
        String s4 = "abc";//referinta catre acelasi obiect "abc" din String pool

        // compar referintele lor
        System.out.println(s2 == s3); //false
        System.out.println(s3 == s4); //false
        System.out.println(s2 == s4); //true

        //comparatie pe baza continutului
        System.out.println(s2.equals(s3)); //true

        s3 = s3.intern();//trecere in String pool
        System.out.println(s2 == s3);// true

        String s5 = "a\\bc \n de\tf";
        System.out.println(s5);

        String adresa = s1 + s2 + s3.toUpperCase() + s4.length(); // ineficient
        StringBuilder sb = new StringBuilder(adresa);
        sb.append(1234); //aceeasi instanta de stringbuilder
        System.out.println("string builder: " + sb);

        StringBuffer sbf = new StringBuffer(adresa);
        StringBuffer sbf1 = new StringBuffer(sb);
        StringBuilder sb1 = new StringBuilder(sbf);


    }
}
