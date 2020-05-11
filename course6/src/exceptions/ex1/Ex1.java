package exceptions.ex1;

/**
 *
 * try catch() finally()
 *
 *
 * java.lang -> Throwable
 *                 Error
     *                  OutofMemoryException
     *                  StackOverflowException
 *                 Exception
 *                      RuntimeException
 *                          java.lang, NPE, ArithmeticException, IllegalArgumentException(NumberFormatException), ClassCastException
 *                      other exceptions
 *                          IoException(java.io), SqlException(java.sql)
 *                              FileNotFoundException(java.io)
 */

public class Ex1 {
    public static void main(String[] args) throws Exception{
        try {
            m1();
        }catch (NullPointerException e) {
            System.out.println(e);
        }finally {
            System.out.println("in finally");
        }
    }

    static void m1() throws Exception{
        System.out.println("in m1");
        m2();

       throw new Exception();
    }

    static void m2(){
        System.out.println("in m2");
        throw new RuntimeException("exception in m2");
//        m3();
    }

    static void m3(){
        System.out.println("in m3");

        //throws NPE
        Object o = null;
        o.toString();
    }
}

