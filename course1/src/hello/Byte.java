package hello;
/**
 *tipuri de date:
 primitive: byte(8 bit), short(16 bit), int(32), long(64), float(32), double(64), boolean, char
 referinta: adresa catre un obiect creat in memorie(heap)

 La declarare declaram tipul si numele variabilei
 Variabilele locale trebuie initializate ininte de folosire


 */


public class Byte{
    static byte defaultValue;

    public static void main(String[] args) {

        byte b1 = -128;
        System.out.println(b1);


        /**
         * byte b1;
         * b1 = 33;
         */

        byte b2 = 127;
        System.out.println(b2);

        b2++; // b2 = b2 + 1

        System.out.println(b2++);
        System.out.println(++b2);

        //byte b3 = 12345; //nu compileaza

        byte b3 = (byte)12345;
        System.out.println(b3);


        //valoarea implicita a unei variabile primitive este 0
        System.out.println(defaultValue);

    }
}