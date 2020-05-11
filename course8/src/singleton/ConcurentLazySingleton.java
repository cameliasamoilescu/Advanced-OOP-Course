package singleton;

public class ConcurentLazySingleton {

    private static volatile ConcurentLazySingleton instance;

    private ConcurentLazySingleton(){

    }

    public ConcurentLazySingleton getInstance(){
        if (instance == null){
            synchronized (ConcurentLazySingleton.class){
                if (instance == null){
                    instance = new ConcurentLazySingleton();
                }

            }
        }
        return instance;
    }
}
