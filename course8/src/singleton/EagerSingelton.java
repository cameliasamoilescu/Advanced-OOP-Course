package singleton;

public class EagerSingelton {
    private static EagerSingelton instance;

    static{
        instance = new EagerSingelton();
    }

    private EagerSingelton(){

    }

    public static EagerSingelton getInstance(){
        return instance;
    }
}
