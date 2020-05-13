package ex3;

public class Ex3 {

    public static void outOfMemory(){
        Integer[] array = new Integer[15000 * 100000];
    }

    public static void stackOverflow(int n){
        n -= 1;
        if(n == 10){
            System.out.println("final");
            return;
        }
        else{
            stackOverflow(n);
        }

    }

    public static void main(String[] args) {
        try {
            outOfMemory();

        }catch (OutOfMemoryError e){
            System.out.println(e);
        }

        System.out.println("After OutOfMemory");
//        stackOverflow(7);

        try {
            stackOverflow(7);

        }catch (StackOverflowError e){
            System.out.println(e);
        }

        System.out.println("After StackOverflowError");


    }
}
