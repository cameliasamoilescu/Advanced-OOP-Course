package workwiththreads;

public class Processor implements Runnable{
    @Override
    public void run() {
        accessCommonResource();

    }
    private static synchronized void accessCommonResource(){
        while(true){
            System.out.println("hello " + Thread.currentThread().getName());
            try{
                Thread.sleep(1000);
//                System.out.println(Thread.currentThread().getState());

            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

}
