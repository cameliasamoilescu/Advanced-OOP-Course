package Arrays;

public class Ex1 {
    public static void main(String[] args) {


        int[] intArray;

        intArray = new int[5];

        intArray[0] = 1;
        intArray[2] = 2;
        intArray[4] = 3;

        //intArray[5] = 5; va compila, cu eroare la executie

        for(int i = 0; i < intArray.length; i ++){
            System.out.println("Elementul de pe pozitia " + i + " este " + intArray[i]);
        }

        // se pot pune [] si dupa numele array-ului, dar se prefera inainte
        int anotherIntArray[] = new int[10];


        /*

        byte[] byteArray;
        short[] shortArray;
        long[] longArray;§
        float[] floatArray;
        double[] doubleArray;
        char[] charArray;
        boolean[] booleanArray;
        Stringp[] stringArray = args;
        Object[] objectArray;

         */
    }
}
