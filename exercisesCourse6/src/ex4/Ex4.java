package ex4;

public class Ex4 {

    public static int getElement(int n){

        try{

            int[] vect = {10,20,30,40,50};
            return vect[n];

        }catch (Exception e){
            System.out.println(e);
            return -1;
        }finally {
            System.out.println("You are in finally");
        }
    }

    public static void main(String[] args) {
        System.out.println(getElement(3));
        System.out.println(getElement(10));
    }
}
